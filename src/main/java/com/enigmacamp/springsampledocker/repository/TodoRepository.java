package com.enigmacamp.springsampledocker.repository;

import com.enigmacamp.springsampledocker.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {
}
