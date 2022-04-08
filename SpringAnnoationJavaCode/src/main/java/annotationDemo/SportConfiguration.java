package annotationDemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfiguration {

    @Bean
    public FortuneService happyFortuneService()
    {
        return new HappyFortuneService();
    }

    @Bean
    public Coach swimCoach()
    {
        SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
        return mySwimCoach;
    }

}
