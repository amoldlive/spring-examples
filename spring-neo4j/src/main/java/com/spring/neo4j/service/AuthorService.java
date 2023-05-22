package com.spring.neo4j.service;

import com.spring.neo4j.repository.AuthorRepository;
import com.spring.neo4j.repository.node.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author add( Author author){
        return authorRepository.save(author);
    }

    public Author update(Author author) throws Exception {
      Optional<Author> authorFromDB=  authorRepository.findById(author.getId());
      if(authorFromDB.isPresent()){
        Author authorFromDBVal = authorFromDB.get();
        authorFromDBVal.setBookList(author.getBookList());
        authorFromDBVal.setName(author.getName());
        authorRepository.save(authorFromDBVal);
      }else{
          throw  new Exception("No Data Found in DB for ID "+author.getId());
      }
      return author;
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
