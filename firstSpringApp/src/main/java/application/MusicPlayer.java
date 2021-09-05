package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

@Component("MP")
@Scope("prototype")
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicList;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic(Genre genre){
        Random random = new Random();
        int x = random.nextInt(3);
        switch (genre){
            case POP:
                return musicList.get(1).getSong().get(x);
            case CLASSICAL:
                return musicList.get(0).getSong().get(x);
            case ROCK:
                return musicList.get(2).getSong().get(x);
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

    @PostConstruct
    public void doMyInit() {
        System.out.println("MP initialization " + this);
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("MP destruction " + this);
    }

}
