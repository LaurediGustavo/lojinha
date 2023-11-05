package br.com.lojinha.lojinhaProducer.exception;

import br.com.lojinha.lojinhaProducer.enumerador.PriorityEnum;

public class MessageException extends Exception {

    private PriorityEnum priority;

    private String message;

    public MessageException(PriorityEnum priority, String message) {
        this.priority = priority;
        this.message = message;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
