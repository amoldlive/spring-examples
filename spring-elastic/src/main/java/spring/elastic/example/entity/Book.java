package spring.elastic.example.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    private int id;
    private String bookName;
    private String author;

    private String date;
}
