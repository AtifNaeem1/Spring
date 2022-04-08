package annotationDemo;


import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService)
    {
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "inside Swim Coach";
    }

    @Override
    public String getDailyFortune() {
        printPropertyValue();
        return fortuneService.getDailyFortune();
    }

    public void printPropertyValue()
    {
        System.out.println("Printing property values : team="+team + " email=" + email );
    }

}
