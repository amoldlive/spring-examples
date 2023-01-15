package spring.graphql.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import spring.graphql.example.entity.Book;
import spring.graphql.example.service.BookService;

import java.util.List;
import java.util.Optional;


@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping("save")
    public Book save(@Argument Book book) {
        return bookService.save(book);
    }

    @QueryMapping("findAll")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @QueryMapping("findById")
    public Optional<Book> getBookById(@Argument Long id) {
        return bookService.findById(id);
    }

    @MutationMapping("deleteById")
    public boolean deleteBook(@Argument Long id) {
        return bookService.deleteById(id);

    }


}
