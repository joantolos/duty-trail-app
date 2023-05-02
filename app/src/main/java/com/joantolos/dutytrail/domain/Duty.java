package com.joantolos.dutytrail.domain;

import java.util.UUID;

public class Duty {

    private final String id;
    private final String name;
    private final Integer effort;

    public Duty(String name, Integer effort) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.effort = effort;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEffort() {
        return effort;
    }
}
