package lab.mvc.form.bean;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class CountryFormBean {

    @NotNull
    @Size(min = 2, max = 20)
    String name;

    @NotNull
    @Size(min = 2, max = 5)
    String codeName;
}
