package demo.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class SimpleBook implements Book {
    long id;
    String title;
    Author author;
    LocalDate dateRelease;
    String comment;
}
