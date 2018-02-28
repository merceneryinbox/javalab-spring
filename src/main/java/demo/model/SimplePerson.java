package demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SimplePerson {
    String name;
    String surname;
    LocalDate date;
}
