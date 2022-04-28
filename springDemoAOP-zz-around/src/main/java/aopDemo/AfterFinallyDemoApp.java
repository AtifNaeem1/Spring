package aopDemo;

import aopDemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts=null;
        try
        {

            //add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDao.findAccounts(tripWire);
        }
        catch (Exception exc)
        {
            System.out.println("\n\nMain program.. caught exception " + exc);
        }

        //display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

        //close the context
        context.close();
    }
}
