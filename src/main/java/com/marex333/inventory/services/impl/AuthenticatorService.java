package com.marex333.inventory.services.impl;

import com.marex333.inventory.database.IUserDAO;
import com.marex333.inventory.exceptions.UserPersistException;
import com.marex333.inventory.model.User;
import com.marex333.inventory.services.IAuthenticatorService;
import com.marex333.inventory.session.SessionObject;
import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthenticatorService implements IAuthenticatorService {
    @Autowired
    IUserDAO iUserDAO;
    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = iUserDAO.getUserByLogin(login);
        if (userBox.isPresent()) {
            if(DigestUtils.md5Hex(password).equals((userBox.get().getPassword()))) {
                sessionObject.setUser(new User.UserBuilder().clone(userBox.get()).password(null).build());

            } else {
                System.out.println("Wrong Password");
            }
        } else {
            System.out.println("Wrong Login");
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }

    @Override
    public void persist(User user, String password2) {
        System.out.println("tworzę użytkownika");
        if (!user.getPassword().equals(password2)) {
            System.out.println("password nie pasuje");
            throw new UserPersistException();
        }
        user.setRole(User.Role.USER);
        iUserDAO.persistUser(new User.UserBuilder().clone(user).build());
        user = null;
    }
}
