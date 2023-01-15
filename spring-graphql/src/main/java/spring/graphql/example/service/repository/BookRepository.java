package spring.graphql.example.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.graphql.example.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
