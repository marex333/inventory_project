package com.marex333.inventory.services.impl;

import com.marex333.inventory.database.IUserDAO;
import com.marex333.inventory.exceptions.AuthenticationException;
import com.marex333.inventory.model.User;
import com.marex333.inventory.services.IAuthenticatorService;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthenticatorService implements IAuthenticatorService {
    @Autowired
    IUserDAO iUserDAO;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = iUserDAO.getUserByLogin(login);
        if (userBox.isPresent()) {
            if(DigestUtils.md5Hex(password).equals((userBox.get().getPassword()))) {
                System.out.println("Zalogowano na: " + userBox.get().getLogin());
            } else {
                System.out.println("Wrong Password");
            }
        } else {
            System.out.println("Wrong Login");
        }
    }

    @Override
    public void logout() {

    }

    @Override
    public void registerUser(User user) {
        user.setRole(User.Role.USER);
        iUserDAO.persistUser(user);
    }
}
