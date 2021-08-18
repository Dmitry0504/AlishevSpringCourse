package application;

import org.springframework.stereotype.Component;

@Component
public class PopMusic implements Music {

    private PopMusic() {
    }

    public static PopMusic getPopMusic() {
        return new PopMusic();
    }
    @Override
    public String getSong() {
        return "You beautiful";
    }
}
