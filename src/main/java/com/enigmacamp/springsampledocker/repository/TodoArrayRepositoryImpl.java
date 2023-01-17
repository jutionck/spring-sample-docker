package com.enigmacamp.springsampledocker.repository;

import com.enigmacamp.springsampledocker.model.Todo;
import com.enigmacamp.springsampledocker.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TodoArrayRepositoryImpl implements TodoArrayRepository {
    @Autowired
    IdGenerator idGenerator;
    private List<Todo> todos = new ArrayList<>();
    @Override
    public Todo create(Todo todo) throws Exception {
        todo.setTodoId(idGenerator.random());
        todos.add(todo);
        return todo;
    }

    @Override
    public List<Todo> getAll() throws Exception {
        return todos;
    }

    @Override
    public Todo getById(String id) throws Exception {
        for (Todo todo : todos) {
            if (Objects.equals(todo.getTodoId(), id)) {
                return todo;
            }
        }
        return null;
    }
}
