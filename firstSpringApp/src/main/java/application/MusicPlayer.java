package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicPlayer {
    private List<Music> musicList;
    private String name;
    private int volume;
    private Music music;

    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(ClassicalMusic music) {
        this.music = music;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String playMusic(){
        return music.getSong();
//        if(musicList != null && !musicList.isEmpty())
//            musicList.forEach(m -> System.out.println(m.getSong()));
//        else System.out.println(music.getSong());
    }

    public List<Music> getMusic() {
        return musicList;
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
