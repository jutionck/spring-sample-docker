package com.enigmacamp.springsampledocker;

import com.enigmacamp.springsampledocker.model.Todo;
import com.enigmacamp.springsampledocker.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSampleDockerApplication implements CommandLineRunner {
    @Autowired
    TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(SpringSampleDockerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Todo App");
        Todo newTodo01 = new Todo();
        newTodo01.setName("Makan");
        newTodo01.setCompleted(false);

        todoService.create(newTodo01);

        List<Todo> todos = todoService.getAll();
        for (Todo todo: todos) {
            System.out.println(todo.toString());
        }
    }
}
