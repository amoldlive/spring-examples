package com.spring.neo4j.controller;

import com.spring.neo4j.repository.node.Author;
import com.spring.neo4j.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Author controller.
 */
@RestController
public class AuthorController {


    private final AuthorService authorService;

    /**
     * Instantiates a new Author controller.
     *
     * @param authorService the author service
     */
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping("/getall")
    public List<Author> getAll(){
        return authorService.getAll();
    }

    /**
     * Add author.
     *
     * @param author the author
     * @return the author
     */
    @PostMapping("/add/author")
    public Author add(@RequestBody Author author){
        return authorService.add(author);
    }
}
