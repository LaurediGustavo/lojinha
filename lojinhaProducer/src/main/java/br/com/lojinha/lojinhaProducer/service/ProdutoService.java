package br.com.lojinha.lojinhaProducer.service;

import br.com.lojinha.lojinhaProducer.model.ProdutoRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.pedidos-destination}")
    private String pedidosDestination;

    public void enviar(ProdutoRequest produtoRequest) {
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(produtoRequest);

        jmsTemplate.convertAndSend(pedidosDestination, jsonPerson);
        System.out.println(jsonPerson);
    }

}
