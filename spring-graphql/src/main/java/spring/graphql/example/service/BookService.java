package spring.graphql.example.service;

import spring.graphql.example.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    boolean deleteById(Long id);

}
