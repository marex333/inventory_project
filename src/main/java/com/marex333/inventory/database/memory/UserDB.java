package com.marex333.inventory.database.memory;

import com.marex333.inventory.database.IUserDAO;
import com.marex333.inventory.database.sequence.IIdSequence;
import com.marex333.inventory.database.sequence.IUserIdSequence;
import com.marex333.inventory.exceptions.UserExistException;
import com.marex333.inventory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDB implements IUserDAO {
    private final List<User> users = new ArrayList<>();
    private final IIdSequence userIdSequence;

    public UserDB(@Autowired IUserIdSequence userIdSequence) {
        this.userIdSequence = userIdSequence;
        users.add(new User(this.userIdSequence.getId(),"admin", "21232f297a57a5a743894a0e4a801fc3", "Dawid", "maron", User.Role.ADMIN));
        users.add(new User(this.userIdSequence.getId(),"user", "ee11cbb19052e40b07aac0ca060c23ee", "Yser", "userowy", User.Role.USER));
        users.add(new User(this.userIdSequence.getId(),"demo", "fe01ce2a7fbac8fafaed7c982a04e229", "Demo", "Demo", User.Role.DEMO));
    }

    @Override
    public Optional<User> getUserByLogin(final String login) {
        return this.users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    @Override
    public void persistUser(User user) {
        Optional op = getUserByLogin(user.getLogin());
        if (op.isPresent()) {
            throw new UserExistException();
        } else {
            user.setId(userIdSequence.getId());
            //user.setPassword(DigestUtils.md5Hex(user.getPassword()));   To już robię w service
            users.add(user);
        }
    }
}
