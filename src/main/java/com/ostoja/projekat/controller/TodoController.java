package com.ostoja.projekat.controller;

import com.ostoja.projekat.model.Todo;
import com.ostoja.projekat.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService TodoService;

    @GetMapping
    public List<Todo> findAll() {
        return TodoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Todo> findById(@PathVariable Long id) {
        return TodoService.findById(id);
    }

    @GetMapping("/title/{title}")
    public List<Todo> findByTitle(@PathVariable String title) {
        return TodoService.findByTitle(title);
    }

    @GetMapping("/date/{date}")
    public List<Todo> findByCreatedDateAfter(@PathVariable LocalDateTime date) {
        return TodoService.findByCreatedDateAfter(date);
    }

    @ResponseBody
    @PostMapping
    public Todo save(@RequestBody Todo Todo) {
        if(Todo.getTitle() == "" || Todo.getDescription() == "") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing_content");
        } else {
            return TodoService.save(Todo);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        TodoService.deleteById(id);
    }
}