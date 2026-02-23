package co.music.discography.config;

import co.music.discography.repositories.ArtistRepository;
import co.music.discography.repositories.TrackRepository;
import co.music.discography.services.ArtistService;
import co.music.discography.services.TrackService;
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

    @Bean
    public ArtistRepository artistRepository(){
        ArtistRepository artistRepository = new  ArtistRepository();
        artistRepository.init();
        return artistRepository;
    }

    @Bean
    public TrackRepository trackRepository(){
        return new TrackRepository();
    }

    @Bean
    public ArtistService artistService(){
        ArtistService artistService = new ArtistService();
        artistService.setArtistRepository(artistRepository());
        return artistService;
    }

    @Bean
    public TrackService trackService(){
        TrackService trackService = new TrackService();
        trackService.setRepo(trackRepository());
        trackService.setArtistService(artistService());
        return trackService;
    }

}
