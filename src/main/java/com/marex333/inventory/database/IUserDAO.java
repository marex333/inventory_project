package com.marex333.inventory.database;

import com.marex333.inventory.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(final String login);
    List<User> getUsers();
    void persistUser(User user);
}