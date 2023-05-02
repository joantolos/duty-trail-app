package com.joantolos.dutytrail.prototype;

import com.joantolos.dutytrail.domain.Duty;
import com.joantolos.dutytrail.domain.Squad;
import com.joantolos.dutytrail.domain.User;
import com.joantolos.dutytrail.domain.error.SubscriptionException;

public class UserBuilder {

    public static User buildUnsubscribed() throws SubscriptionException {
        User nonSubscribedUser = new User("John Doe");

        Squad family = new Squad("Family");
        family.addDuty(new Duty("Do the dishes", 2));
        family.addDuty(new Duty("Clean the bathroom", 4));
        family.addDuty(new Duty("Shop groceries", 5));
        family.addDuty(new Duty("Sweep the floor", 3));
        family.addDuty(new Duty("Make the bed", 1));

        nonSubscribedUser.addSquad(family);

        Squad soccerTeam = new Squad("Soccer Team");
        soccerTeam.addDuty(new Duty("Clean up practice gear", 2));
        soccerTeam.addDuty(new Duty("Clean dressing room", 5));

        nonSubscribedUser.addSquad(soccerTeam);

        return nonSubscribedUser;
    }

    public static User buildSubscribed() throws SubscriptionException {
        User subscribedUser = new User("John Premium");
        subscribedUser.upgrade();

        Squad family = new Squad("Family");
        family.addDuty(new Duty("Do the dishes", 2));
        family.addDuty(new Duty("Clean the bathroom", 4));
        family.addDuty(new Duty("Shop groceries", 5));
        family.addDuty(new Duty("Sweep the floor", 3));
        family.addDuty(new Duty("Make the bed", 1));

        subscribedUser.addSquad(family);

        Squad soccerTeam = new Squad("Soccer Team");
        soccerTeam.addDuty(new Duty("Clean up practice gear", 2));
        soccerTeam.addDuty(new Duty("Clean dressing room", 5));

        subscribedUser.addSquad(soccerTeam);

        return subscribedUser;
    }
}
