package lab.model;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class Squishee {
    private String name;

    public Squishee(String usual_squishee, String name) {

        this.name = name;
    }
}
