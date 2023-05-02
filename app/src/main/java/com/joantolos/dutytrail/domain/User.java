package com.joantolos.dutytrail.domain;

import com.joantolos.dutytrail.domain.error.SubscriptionException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class User {

    public static final int UNSUBSCRIBED_MAX_SQUADS = 2;
    public static final int UNSUBSCRIBED_MAX_DUTIES = 5;
    private final String name;
    private final int id;
    private boolean premium;
    private final List<Squad> squads;
    private final List<DutyLog> dutyLogs;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.premium = false;
        this.squads = new ArrayList<>();
        this.dutyLogs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void makePremium() {
        this.premium = true;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public List<DutyLog> getDutyLogs() {
        return dutyLogs;
    }

    public void addSquad(Squad squad) throws SubscriptionException {
        if (squads.size() == UNSUBSCRIBED_MAX_SQUADS && !isPremium())
            throw new SubscriptionException(String.format("Only %d squads per user allowed. Upgrade your account to have unlimited squads", UNSUBSCRIBED_MAX_SQUADS));
        squads.add(squad);
    }

    public void addDuty(Duty duty, Squad squad) throws SubscriptionException {
        if (squads.size() == UNSUBSCRIBED_MAX_DUTIES && !isPremium())
            throw new SubscriptionException(String.format("Only %d duties per user allowed. Upgrade your account to have unlimited duties", UNSUBSCRIBED_MAX_DUTIES));
        squad.addDuty(duty);
    }

    public void performDuty(Duty duty, Squad squad) {
        dutyLogs.add(new DutyLog(duty, squad, new Timestamp(System.currentTimeMillis())));
    }
}
