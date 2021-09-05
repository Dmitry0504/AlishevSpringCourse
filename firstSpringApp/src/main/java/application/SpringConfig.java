package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan("application")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic(){
        return ClassicalMusic.getClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return RockMusic.getRockMusic();
    }

    @Bean
    public PopMusic popMusic() {
        return PopMusic.getPopMusic();
    }

    public List<Music> musicList() {
        return List.of(classicalMusic(), popMusic(), rockMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
}
