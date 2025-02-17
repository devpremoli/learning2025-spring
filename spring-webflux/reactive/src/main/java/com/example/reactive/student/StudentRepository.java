package com.example.reactive.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    Flux<Student> findAllByFirstNameIgnoreCase(String firstName);
}
