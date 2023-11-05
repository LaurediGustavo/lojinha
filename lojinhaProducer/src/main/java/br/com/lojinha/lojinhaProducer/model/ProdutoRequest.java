package br.com.lojinha.lojinhaProducer.model;

import java.io.Serializable;

public class ProdutoRequest implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
