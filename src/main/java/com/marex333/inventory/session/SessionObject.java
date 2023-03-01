package com.marex333.inventory.session;

import com.marex333.inventory.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionObject {
    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return this.user != null;
    }
    public boolean isAdmin() {
        return this.user != null && user.getRole() == User.Role.ADMIN;
    }
}
