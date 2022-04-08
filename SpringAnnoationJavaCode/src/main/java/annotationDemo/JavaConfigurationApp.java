package annotationDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigurationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(SportConfiguration.class);

        Coach theCoach = context.getBean("swimCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());


        context.close();
    }
}
