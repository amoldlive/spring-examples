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
    public Book save(@Argument  Book book){
        return bookService.save(book);
    }

    @QueryMapping("books")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }


    @QueryMapping("book")
    public Optional<Book> getBookById(@Argument  int id){
        return bookService.findById(id);
    }



    @QueryMapping("delete")
    public void deleteBook(@Argument  int id){
         bookService.deleteById(id);
    }




}
