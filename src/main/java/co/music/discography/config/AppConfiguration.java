package co.music.discography.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan(basePackages = "co.music.discography")
@PropertySource("classpath:application.properties")
public class AppConfiguration{

    @Bean
    public static PropertySourcesPlaceholderConfigurer configure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
