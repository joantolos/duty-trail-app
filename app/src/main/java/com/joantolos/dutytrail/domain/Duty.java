package com.joantolos.dutytrail.domain;

public class Duty {

    private final int id;
    private final String name;
    private final Integer effort;

    public Duty(int id, String name, Integer effort) {
        this.id = id;
        this.name = name;
        this.effort = effort;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEffort() {
        return effort;
    }
}
