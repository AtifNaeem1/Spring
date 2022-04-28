package aopDemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addSillyMember()
    {
        System.out.println(getClass() + ": Doing stuff: Adding a membership Account");
    }

    public void goToSleep()
    {
        System.out.println(getClass()+": I'm going to sleep now");
    }
}
