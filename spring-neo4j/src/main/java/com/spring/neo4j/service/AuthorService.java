package com.spring.neo4j.service;

import com.spring.neo4j.repository.AuthorRepository;
import com.spring.neo4j.repository.node.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    /**
     * Update author.
     *
     * @param author the author
     * @return the author
     * @throws Exception the exception
     */
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

    /**
     * Delete author.
     *
     * @param id the id
     * @return the author
     */
    public Author delete(Long id) {
        Author author=authorRepository.findById(id).get();
        authorRepository.deleteById(id);
        return author;
    }
}
