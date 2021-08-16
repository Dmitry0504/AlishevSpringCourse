package application;

import java.util.List;

public class MusicPlayer {
    private List<Music> musicList;
    private String name;
    private int volume;

    public MusicPlayer() {
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setMusic(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic(){
        musicList.forEach(m -> System.out.println(m.getSong()));
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
}
