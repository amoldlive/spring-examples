package com.spring.neo4j.controller;

import com.spring.neo4j.repository.node.Author;
import com.spring.neo4j.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/author")
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @PostMapping("/author")
    public Author add(@RequestBody Author author){
        return authorService.add(author);
    }

    @PutMapping("/author")
    public Author update(@RequestBody Author author) throws Exception {
        return authorService.update(author);
    }

    @DeleteMapping("/author/{id}")
    public void delete(@PathVariable Long id){
         authorService.delete(id);
    }

}
