package com.enigmacamp.springsampledocker.service;

import com.enigmacamp.springsampledocker.model.Todo;
import com.enigmacamp.springsampledocker.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Override
    public Todo create(Todo todo) {
        try {
            return todoRepository.create(todo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> getAll() {
        try {
            return todoRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todo getById(String id) {
        try {
            return todoRepository.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
