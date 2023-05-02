package com.joantolos.dutytrail.app;

import com.joantolos.dutytrail.domain.Squad;
import com.joantolos.dutytrail.domain.User;
import com.joantolos.dutytrail.domain.error.SubscriptionException;

import org.junit.Test;

public class UserTest {

    @Test(expected = SubscriptionException.class)
    public void shouldRaiseExceptionWhenAddingSquadOnUnSubscribedUser() throws SubscriptionException {
        User nonSubscribedUser = new User("John Doe", 1);
        //User.UNSUBSCRIBED_MAX_SQUADS
        nonSubscribedUser.addSquad(new Squad(1, "Family"));
        nonSubscribedUser.addSquad(new Squad(2, "Soccer Team"));
        nonSubscribedUser.addSquad(new Squad(3, "Work"));
    }
}
