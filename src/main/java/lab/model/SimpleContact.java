package lab.model;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component("contact")
@Value
public class SimpleContact implements Contact {
    private String type;
    private String value;

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
