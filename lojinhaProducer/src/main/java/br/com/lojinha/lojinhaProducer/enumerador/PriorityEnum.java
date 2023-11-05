package br.com.lojinha.lojinhaProducer.enumerador;

public enum PriorityEnum {

    PRIORITY_ERROR(9),

    PRIORITY_DEBUG(4),

    PRIORITY_WARN(1);

    private final Integer priority;

    PriorityEnum(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

}
