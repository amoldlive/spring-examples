package com.spring.neo4j.repository.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Author")
public class Author {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @Relationship(type = "AUTHORED")
    List<Book> books;
}
