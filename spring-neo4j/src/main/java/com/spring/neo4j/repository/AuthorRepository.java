package com.spring.neo4j.repository;

import com.spring.neo4j.repository.node.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Author repository.
 */
@Repository
public interface AuthorRepository extends Neo4jRepository<Author, Long> {
}
