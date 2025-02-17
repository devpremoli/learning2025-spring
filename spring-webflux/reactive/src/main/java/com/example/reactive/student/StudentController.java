package com.example.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    Mono<Student> save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(@PathVariable Integer id) {
        return studentService.findById(id);
    }
}
