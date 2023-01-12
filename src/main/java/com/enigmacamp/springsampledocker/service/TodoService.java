package com.enigmacamp.springsampledocker.service;

import com.enigmacamp.springsampledocker.model.Todo;

import java.util.List;

public interface TodoService {
    Todo create(Todo todo);
    List<Todo> getAll();
    Todo getById(String id);
}
