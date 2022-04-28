package aopDemo;

import aopDemo.dao.AccountDAO;
import aopDemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        //get membership bean from container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);


        //call the business method
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
        theAccountDao.addAccount(account);

        //call getter and setter
        theAccountDao.setName("Ajay");
        theAccountDao.setServiceCode("silver");

        String name = theAccountDao.getName();
        String code = theAccountDao.getServiceCode();

        //call the membership business method
        theMembershipDAO.addSillyMember();


        //close the context
        context.close();
    }
}
