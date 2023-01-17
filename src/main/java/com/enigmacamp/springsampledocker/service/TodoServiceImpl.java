package com.enigmacamp.springsampledocker.service;

import com.enigmacamp.springsampledocker.model.Todo;
import com.enigmacamp.springsampledocker.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    TodoRepository todoRepository;
    @Override
    public Todo create(Todo todo) {
        try {
            return todoRepository.save(todo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        Iterable<Todo> result = todoRepository.findAll();
        for (Todo todo: result) {
            todos.add(todo);
        }
        return todos;
    }

    @Override
    public Todo getById(String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            throw new RuntimeException("Course not found");
        }
        return todo.get();
    }
}
