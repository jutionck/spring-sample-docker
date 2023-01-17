package com.enigmacamp.springsampledocker.controller;

import com.enigmacamp.springsampledocker.model.Todo;
import com.enigmacamp.springsampledocker.service.TodoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    TodoService todoService;

    public TodoController(@Qualifier("todoServiceImpl") TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> listTodo() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id) {
        return todoService.getById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.create(todo);
    }
}
