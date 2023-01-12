package com.enigmacamp.springsampledocker.repository;

import com.enigmacamp.springsampledocker.model.Todo;

import java.util.List;

public interface TodoRepository {
    Todo create(Todo todo) throws Exception;
    List<Todo> getAll() throws Exception;
    Todo getById(String id) throws Exception;
}
