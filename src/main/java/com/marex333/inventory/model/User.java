package com.marex333.inventory.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    public List<Alcohol> getAlcoholList() {
        return alcoholList;
    }

    public void setAlcoholList(List<Alcohol> alcoholList) {
        this.alcoholList = alcoholList;
    }

    private List<Alcohol> alcoholList;

    public User(int id, String login, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        alcoholList = new ArrayList();
    }

    public User() {
        alcoholList = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getUserPower() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
    public enum Role {
        ADMIN,
        USER,
        DEMO
    }
    public static class UserBuilder {
        User user = new User();
        public UserBuilder id(int id) {
            this.user.setId(id);
            return this;
        }
        public UserBuilder login(String login) {
            this.user.setLogin(login);
            return this;
        }
        public UserBuilder password(String password) {
            this.user.setPassword(password);
            return this;
        }
        public UserBuilder firstName(String firstName) {
            this.user.setFirstName(firstName);
            return this;
        }
        public UserBuilder lastName(String lastName) {
            this.user.setLastName(lastName);
            return this;
        }
        public UserBuilder role(Role role) {
            this.user.setRole(role);
            return this;
        }
        public User build() {
            return user;
        }
        public UserBuilder clone(User user) {
            id(user.getId()).
                    login(user.getLogin()).
                    password(user.getPassword()).
                    firstName(user.getFirstName()).
                    lastName(user.getLastName()).
                    role(user.getRole());
            return this;
        }
    }
}
