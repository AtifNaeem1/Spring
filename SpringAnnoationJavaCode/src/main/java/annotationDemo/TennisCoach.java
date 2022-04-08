package annotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach{

//    field injection

    @Autowired
    private FortuneService fortuneService;



    public TennisCoach()
    {

    }

//    injecting using constructor
//
//    public TennisCoach(FortuneService fortuneService)
//    {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "inside tennis Coach class";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

//    injecting using any method

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService){
//        this.fortuneService = fortuneService;
//    }

}
