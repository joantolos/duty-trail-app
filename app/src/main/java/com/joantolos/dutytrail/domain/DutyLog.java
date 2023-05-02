package com.joantolos.dutytrail.domain;

import java.sql.Timestamp;

public class DutyLog {

    private final Duty duty;
    private final Squad squad;
    private final Timestamp performed;

    public DutyLog(Duty duty, Squad squad, Timestamp performed) {
        this.duty = duty;
        this.squad = squad;
        this.performed = performed;
    }

    public Duty getDuty() {
        return duty;
    }

    public Squad getSquad() {
        return squad;
    }

    public Timestamp getPerformed() {
        return performed;
    }
}
