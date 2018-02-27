package lab.model.simple;

import lab.model.Contact;
import lab.model.Country;
import lab.model.Person;
import lab.model.User;
import lombok.*;
import lombok.experimental.Wither;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
//@Component("person")
public class UsualPerson implements Person {

    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;

    @ManyToOne(targetEntity = SimpleCountry.class)
    @JoinColumn(name = "country_id")
    Country country;

    int age;
    float height;
    boolean isProgrammer;

    @Wither
    boolean isBroke;

    @OneToMany(targetEntity = SimpleContact.class)
    @Singular
    List<Contact> contacts;
}