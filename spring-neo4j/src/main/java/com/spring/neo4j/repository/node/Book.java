package com.spring.neo4j.repository.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * The type Book.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Book")
public class Book {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue
    Long id;
    /**
     * The Name.
     */
    String name;

}
