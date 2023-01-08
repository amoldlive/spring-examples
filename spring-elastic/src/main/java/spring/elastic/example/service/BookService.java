package spring.elastic.example.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.elastic.example.entity.Book;
import spring.elastic.example.service.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBoks(){
       return (List<Book>) bookRepository.findAll();
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }

}
