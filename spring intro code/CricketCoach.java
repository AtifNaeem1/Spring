public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach()
    {
        System.out.println("CricketCoach  : inside no arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkOut() {
        System.out.println(emailAddress+"\n" + team);
        return "with cricket coach";
    }

    @Override
    public String getFortune() {
        return fortuneService.getDailyFortune();
    }


}
