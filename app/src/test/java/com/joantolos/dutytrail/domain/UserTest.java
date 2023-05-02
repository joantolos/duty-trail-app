package com.joantolos.dutytrail.domain;

import com.joantolos.dutytrail.domain.error.SubscriptionException;
import com.joantolos.dutytrail.prototype.UserBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User unSubscribedUser;
    private User subscribedUser;

    @Before
    public void setUp() throws SubscriptionException {
        unSubscribedUser = UserBuilder.buildUnsubscribed();
        subscribedUser = UserBuilder.buildSubscribed();
    }

    @Test(expected = SubscriptionException.class)
    public void shouldRaiseExceptionWhenAddingSquadOnUnSubscribedUser() throws SubscriptionException {
        unSubscribedUser.addSquad(new Squad("Work"));
    }

    @Test
    public void shouldAllowAddingSquadOnSubscribedUser() throws SubscriptionException {
        subscribedUser.addSquad(new Squad("Work"));
    }

    @Test(expected = SubscriptionException.class)
    public void shouldRaiseExceptionWhenAddingDutyOnUnSubscribedUser() throws SubscriptionException {
        unSubscribedUser.addDuty(new Duty("Tidy kids room", 2), unSubscribedUser.getSquads().get(0));
    }

    @Test
    public void shouldAllowAddingDutyOnSubscribedUser() throws SubscriptionException {
        subscribedUser.addDuty(new Duty("Tidy kids room", 2), unSubscribedUser.getSquads().get(0));
    }

    @Test
    public void shouldPerformDuty() {
        Assert.assertEquals(0, subscribedUser.getDutyLogs().size());
        Squad squad = subscribedUser.getSquads().get(0);
        Duty duty = squad.getDuties().get(0);
        subscribedUser.performDuty(duty, squad);
        Assert.assertEquals(1, subscribedUser.getDutyLogs().size());
    }
}
