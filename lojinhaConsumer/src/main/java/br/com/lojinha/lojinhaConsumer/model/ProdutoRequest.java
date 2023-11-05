package br.com.lojinha.lojinhaConsumer.model;

import java.io.Serializable;

public class ProdutoRequest implements Serializable {

    private String message;

    public ProdutoRequest() {}

    public ProdutoRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
