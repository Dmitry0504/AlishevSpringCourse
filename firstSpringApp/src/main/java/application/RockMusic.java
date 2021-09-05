package application;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class RockMusic implements Music {

    private RockMusic() {
    }

    public static RockMusic getRockMusic() {
        return new RockMusic();
    }

    @Override
    public List<String> getSong() {
        return List.of("Comatose", "Nothing else matters", "We will rock you");
    }
}
