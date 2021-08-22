package application;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PopMusic implements Music {

    private PopMusic() {
    }

    public static PopMusic getPopMusic() {
        return new PopMusic();
    }
    @Override
    public List<String> getSong() {
        return List.of("You beautiful", "Faded", "Pump it up");
    }
}
