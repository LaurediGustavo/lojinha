package br.com.lojinha.lojinhaConsumer.listener;

import br.com.lojinha.lojinhaConsumer.model.ProdutoRequest;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerService {

    @JmsListener(destination = "logs")
    public void receiveFromQueue(String message) throws JMSException {
        System.out.println(message);
    }

    @JmsListener(destination = "${activemq.topic-name}", containerFactory = "myFactory")
    public void receiveFromTopic(String produtoRequest) throws JMSException {
        System.out.println(produtoRequest);
    }

}
