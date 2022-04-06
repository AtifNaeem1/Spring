import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringMain {
    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCricketCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkOut());

        System.out.println(theCoach.getFortune());




        context.close();
    }
}


