package br.com.lojinha.lojinhaProducer.service;

import br.com.lojinha.lojinhaProducer.enumerador.PriorityEnum;
import br.com.lojinha.lojinhaProducer.exception.MessageException;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProdutoComErroService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.logs-destination}")
    private String logsDestination;

    @Autowired
    private ActiveMQConnectionFactory connectionFactory;

    public void enviarErro() throws JMSException {
        int opcao;

        try {
            Random random = new Random();
            int value = random.nextInt(10);

            if(value == 1) {
                opcao = random.nextInt(3);
                getMessage(opcao);
            }
        }
        catch (MessageException e) {

            System.out.println(e.getMessage() + " - " + e.getPriority().getPriority());

            jmsTemplate.execute(new SessionCallback<Object>() {
                @Override
                public Object doInJms(Session session) throws JMSException {
                    MessageProducer producer = session.createProducer(getDestination());
                    TextMessage message = session.createTextMessage(e.getMessage());

                    producer.send(message, DeliveryMode.PERSISTENT, e.getPriority().getPriority(), 300000);
                    producer.close();

                    return null;
                }
            });

        }
    }

    private Destination getDestination() {
        return new Queue() {
            @Override
            public String getQueueName() throws JMSException {
                return logsDestination;
            }
        };
    }

    private void getMessage(int opcao) throws MessageException {
        switch (opcao) {
            case 0 -> throw new MessageException(PriorityEnum.PRIORITY_ERROR ,"Error");
            case 1 -> throw new MessageException(PriorityEnum.PRIORITY_DEBUG, "Debug");
            case 2 -> throw new MessageException(PriorityEnum.PRIORITY_WARN, "Warn");
        }
    }

}
