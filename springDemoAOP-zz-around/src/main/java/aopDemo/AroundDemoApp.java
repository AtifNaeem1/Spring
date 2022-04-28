package aopDemo;

import aopDemo.dao.AccountDAO;
import aopDemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        TrafficFortuneService theTrafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: calling fortune");
        String data = theTrafficFortuneService.getFortune();
        System.out.println("My Fortune is: " + data);
        System.out.println("Finished");

        //close the context
        context.close();
    }
}
