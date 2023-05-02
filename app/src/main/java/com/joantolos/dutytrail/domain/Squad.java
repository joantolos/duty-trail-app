package com.joantolos.dutytrail.domain;

import java.util.ArrayList;
import java.util.List;

public class Squad {

    private final int id;
    private final String name;
    private final List<Duty> duties;

    public Squad(int id, String name) {
        this.id = id;
        this.name = name;
        this.duties = new ArrayList<>();
    }

    public int getId() {
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
