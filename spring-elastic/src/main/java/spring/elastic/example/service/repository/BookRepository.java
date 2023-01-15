package spring.elastic.example.service.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import spring.elastic.example.entity.Book;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

}
