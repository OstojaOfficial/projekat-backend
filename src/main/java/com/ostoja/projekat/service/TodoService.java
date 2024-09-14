package com.ostoja.projekat.service;

import com.ostoja.projekat.model.Todo;
import com.ostoja.projekat.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository TodoRepository;

    public List<Todo> findAll() {
        return TodoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return TodoRepository.findById(id);
    }

    public Todo save(Todo Todo) {
        return TodoRepository.save(Todo);
    }

    public void deleteById(Long id) {
        TodoRepository.deleteById(id);
    }

    public List<Todo> findByTitle(String title) {
        return TodoRepository.findByTitle(title);
    }

    public List<Todo> findByPublishedDateAfter(LocalDateTime date) {
        return TodoRepository.findByPublishedDateAfter(date);
    }
}