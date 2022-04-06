public class BaseballCoach implements Coach{

    private FortuneService fortuneService;

    BaseballCoach(FortuneService fortuneService)
    {
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "spend 30 minutes with baseball coach";
    }

    @Override
    public String getFortune() {
        return fortuneService.getDailyFortune();
    }
}
