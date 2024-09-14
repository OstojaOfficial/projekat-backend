package com.ostoja.projekat.controller;

import com.ostoja.projekat.model.Todo;
import com.ostoja.projekat.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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

    @PostMapping
    public Todo save(@RequestBody Todo Todo) {
        return TodoService.save(Todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        TodoService.deleteById(id);
    }
}