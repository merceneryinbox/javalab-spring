package lab.model.simple;

import lab.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "contact")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleContact implements Contact {
    @Id
    @GeneratedValue
    Long id;

    String type;
    String value;
}
