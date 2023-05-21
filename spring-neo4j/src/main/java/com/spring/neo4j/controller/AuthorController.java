package com.spring.neo4j.controller;

import com.spring.neo4j.repository.node.Author;
import com.spring.neo4j.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/author")
    public Author add(@RequestBody Author author){
        return authorService.add(author);
    }

    /**
     * Update author.
     *
     * @param author the author
     * @return the author
     * @throws Exception the exception
     */
    @PutMapping("/author")
    public Author update(@RequestBody Author author) throws Exception {
        return authorService.update(author);
    }

    /**
     * Delete author.
     *
     * @param id the id
     * @return the author
     */
    @DeleteMapping("/author/{id}")
    public Author delete(@PathVariable Long id){
        return authorService.delete(id);
    }

}
