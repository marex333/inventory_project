package com.marex333.inventory;

import com.marex333.inventory.database.memory.UserDB;
import com.marex333.inventory.database.sequence.UserIdSequence;
import com.marex333.inventory.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}