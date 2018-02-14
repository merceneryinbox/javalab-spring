package lab.model;

import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Country")
@NoArgsConstructor
@AllArgsConstructor
public class SimpleCountry implements Country {

    @Id
    @Wither
    @GeneratedValue
    private Long id;
    private String name;
    private String codeName;

    @Override
    public Long getId() {
        return null;
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
