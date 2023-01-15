package spring.graphql.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    private int id;
    private String bookName;
    private String author;
    private String date;
}
