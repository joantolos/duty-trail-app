package com.joantolos.dutytrail.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Squad {

    private final String id;
    private final String name;
    private final List<Duty> duties;

    public Squad(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.duties = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Duty> getDuties() {
        return duties;
    }

    public void addDuty(Duty duty) {
        this.duties.add(duty);
    }

    public void removeDuty(Duty duty) {
        this.duties.remove(duty);
    }
}
