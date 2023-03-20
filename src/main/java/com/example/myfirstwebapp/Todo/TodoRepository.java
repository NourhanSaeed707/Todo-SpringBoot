package com.example.myfirstwebapp.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.*;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username) ;

}
