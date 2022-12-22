package com.reactive;

import com.reactive.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
   Mono<Person> getById(int id);
    Flux<Person> getAll();
}
