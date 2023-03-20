package com.example.myfirstwebapp.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    @Size(min = 10, message = "enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo() {};

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done){
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public  void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return  description;
    }
    public void setTargetDate(LocalDate targetDate){
        this.targetDate = targetDate;
    }
    public  LocalDate getTargetDate(){
        return  targetDate;
    }
    public void setDone(boolean done){
        this.done = done;
    }
    public boolean getDone(){
        return  done;
    }

    @Override
    public String toString() {
        return "Todo [id = " + id + " ,username = " + username + " ,description = " + description + " ,targetDate = "
                + targetDate + " ,done = " + done + "]";
    }


}
