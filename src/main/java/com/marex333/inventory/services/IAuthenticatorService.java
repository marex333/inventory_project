package com.marex333.inventory.services;

import com.marex333.inventory.model.User;

public interface IAuthenticatorService {
    void authenticate(String login, String password);
    void logout();
    void registerUser(User user);
}
