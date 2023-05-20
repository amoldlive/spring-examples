package com.spring.neo4j.service;

import com.spring.neo4j.repository.AuthorRepository;
import com.spring.neo4j.repository.node.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * The type Author service.
 */
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    /**
     * Instantiates a new Author service.
     *
     * @param authorRepository the author repository
     */
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    /**
     * Add author.
     *
     * @param author the author
     * @return the author
     */
    public Author add( Author author){
        return authorRepository.save(author);
    }
}
