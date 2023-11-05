package br.com.lojinha.lojinhaProducer.controller;

import br.com.lojinha.lojinhaProducer.model.ProdutoRequest;
import br.com.lojinha.lojinhaProducer.service.ProdutoComErroService;
import br.com.lojinha.lojinhaProducer.service.ProdutoService;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoComErroService produtoComErro;

    @PostMapping("/comprar")
    public void comprar(@RequestBody ProdutoRequest produtoRequest) throws JMSException {
        this.produtoService.enviar(produtoRequest);
        this.produtoComErro.enviarErro();
    }
}
