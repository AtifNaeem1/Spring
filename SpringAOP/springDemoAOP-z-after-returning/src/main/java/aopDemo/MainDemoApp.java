package aopDemo;

import aopDemo.dao.AccountDAO;
import aopDemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        //call method to find the accounts
        List<Account> theAccounts = theAccountDao.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

        //close the context
        context.close();
    }
}
