package lab.model;

import lombok.Value;
import lombok.experimental.Wither;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
@Component("person")
public class UsualPerson implements Person {
    private int id;
    private String firstName;
    private String lastName;
    private Country country;
    private int age;
    private float height;
    private boolean isProgrammer;

    @Wither
    private boolean isBroke;

    private List<Contact> contacts;

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public Country getCountry() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public boolean isProgrammer() {
        return false;
    }

    @Override
    public Person withBroke(boolean broke) {
        return null;
    }

    @Override
    public boolean isBroke() {
        return false;
    }

    @Override
    public List<Contact> getContacts() {
        return null;
    }
}