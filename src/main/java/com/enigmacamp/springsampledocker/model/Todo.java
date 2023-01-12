package com.enigmacamp.springsampledocker.model;

public class Todo {
    private String todoId;
    private String name;
    private Boolean isCompleted;

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId='" + todoId + '\'' +
                ", name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
