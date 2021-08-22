package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component("MP")
@Scope("prototype")
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private Music rockMusic;
    private Music classicalMusic;
    private Music popMusic;

    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic")Music rockMusic,
                       @Qualifier("classicalMusic")Music classicalMusic,
                       @Qualifier("popMusic")Music popMusic) {
        this.rockMusic = rockMusic;
        this.classicalMusic = classicalMusic;
        this.popMusic = popMusic;
    }

    public String playMusic(Genre genre){
        Random random = new Random();
        int x = random.nextInt(3);
        switch (genre){
            case POP:
                return popMusic.getSong().get(x);
            case CLASSICAL:
                return classicalMusic.getSong().get(x);
            case ROCK:
                return rockMusic.getSong().get(x);
            default:
                return "incorrect genre";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void doMyInit() {
        System.out.println("MP initialization " + this);
    }

    public void doMyDestroy() {
        System.out.println("MP destruction " + this);
    }

}
