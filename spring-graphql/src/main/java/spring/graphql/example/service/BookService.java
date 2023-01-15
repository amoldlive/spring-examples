package spring.graphql.example.service;

import spring.graphql.example.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Optional<Book> findById(int id);
    List<Book> findAll();
    void deleteById(int id);
    Book updateById(Book book,int id);

}
