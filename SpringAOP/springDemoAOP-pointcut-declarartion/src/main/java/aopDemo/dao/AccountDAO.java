package aopDemo.dao;

import aopDemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount)
    {
        System.out.println(getClass() + ": Doing my db work : Add Account");
    }

    public boolean doWork()
    {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
