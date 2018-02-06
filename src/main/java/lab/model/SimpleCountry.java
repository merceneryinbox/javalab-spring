package lab.model;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component("country")
@Value
public class SimpleCountry implements Country {
    private int id;
    private String name;
    private String codeName;
}
