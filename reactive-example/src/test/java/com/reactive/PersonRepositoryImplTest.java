package com.reactive;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.reactive.entity.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;


class PersonRepositoryImplTest {

    PersonRepository personRepository;

    @BeforeEach
    public void setUp(){
        personRepository=new PersonRepositoryImpl();
    }

    /*Mono Operations*/
    @Test
    public void getByItBlock(){
        System.out.println(" getByItBlock >> ");

        int id=1;

        Mono<Person> personMono= personRepository.getById(1);
        Person person= personMono.block();
        System.out.println(person);
    }

    @Test
    void getByIdSubscribe() {
        System.out.println(" getByIdSubscribe >> ");

        int id=1;
        Mono<Person> personMono= personRepository.getById(1);

        personMono.subscribe(person -> {
            System.out.println(person);
        });

    }

    @Test
    void getByIdMapFunction() {
        int id=1;
        Mono<Person> personMono= personRepository.getById(1);
        personMono.map(person -> {  //works as a publisher of publisher
            System.out.println(person);
            return person.getFirstName();
        }).subscribe(firstName->{
            System.out.println(firstName);
        });
    }

    /*Flux Operations*/


    @Test
    void fluxTestBlockFirst() {
        Flux<Person> personFlux=personRepository.getAll();
        Person person = personFlux.blockFirst();
        System.out.println(person);
    }
    @Test
    void fluxTestBlockLast() {
        Flux<Person> personFlux=personRepository.getAll();
        Person person = personFlux.blockLast();
        System.out.println(person);
    }

    @Test
    void testFluxSubscribe() {
        Flux<Person> personFlux=personRepository.getAll();
         personFlux.subscribe(person -> {
             System.out.println(person);
         });

    }

    @Test
    void testFluxToListMono() {
        Flux<Person> personFlux=personRepository.getAll();
        personFlux.collectList().subscribe(
          list->{
            list.forEach(person -> {
                System.out.println(person);
            });
          });
    }

    /*Flux Filter Operations*/
    @Test
    void testFindPersonById(){
        int id=3;

        Flux<Person> personFlux=personRepository.getAll();
        Mono<Person> personMono=personFlux.filter(person -> person.getId()==id).next();
        personMono.subscribe(person -> {
            System.out.println(person);
        });
    }

    //wont throw any exception
    @Test
    void testFindPersonByIdNotFound(){
        int id=8; //invalid ID

        Flux<Person> personFlux=personRepository.getAll();
        Mono<Person> personMono=personFlux.filter(person -> person.getId()==id).next();
        personMono.subscribe(person -> {
            System.out.println(person);
        });
    }

    @Test
    void testFindPersonByIdNotFoundWithException(){
        int id=8; //invalid ID

        Flux<Person> personFlux=personRepository.getAll();
        Mono<Person> personMono=personFlux.filter(person -> person.getId()==id).single();
        personMono.doOnError(throwable -> {
            System.out.println(throwable.getMessage());
        }).subscribe(person -> {
            System.out.println(person);
        });
    }

    @Test
    void testFindPersonByIdNotFoundWithException2(){
        int id=8; //invalid ID

        Flux<Person> personFlux=personRepository.getAll();
        Mono<Person> personMono=personFlux.filter(person -> person.getId()==id).single();
        personMono.doOnError(throwable -> {
            System.out.println(throwable.getMessage());
        }).onErrorReturn(Person.builder().build())
                .subscribe(person -> {
            System.out.println(person);
        });
    }

}