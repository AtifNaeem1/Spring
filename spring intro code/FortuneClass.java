public class FortuneClass implements FortuneService{

    public FortuneClass()
    {
        System.out.println("FortuneClass  : inside no arg constructor");
    }
    @Override
    public String getDailyFortune() {
        return "Today is your lucky day!" ;
    }
}
