package spring.elastic.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.elastic.example.entity.Book;
import spring.elastic.example.service.BookService;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService  bookService;

    @PostMapping("/save")
    public Book save(Book book){
        return bookService.save(book);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBoks();
    }
}
