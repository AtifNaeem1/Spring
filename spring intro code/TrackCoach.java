public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    TrackCoach(FortuneService fortuneService)
    {
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "spend 30  minutes with Track coach";
    }

    @Override
    public String getFortune() {
        return fortuneService.getDailyFortune();
    }
}
