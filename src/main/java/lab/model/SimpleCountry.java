package lab.model;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component("country")
@Value
public class SimpleCountry implements Country {
    private int id;
    private String name;
    private String codeName;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getCodeName() {
        return null;
    }
}
