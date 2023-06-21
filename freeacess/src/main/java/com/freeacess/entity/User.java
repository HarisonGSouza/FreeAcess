package com.freeacess.entity;

import com.freeacess.exception.EntityException;

public class User {

    private int id;
    private String user_name;
    private String password;

    private User() {
        this.id = 0;
        this.user_name = null;
        this.password = null;
    }

    private User(User.UserBuilder builder) throws EntityException {
        super();
        setId(builder.id);
        setUserName(builder.user_name);
        setPassword(builder.password);
    }

    public static class UserBuilder {
        private int id;
        private String user_name;
        private String password;

        public UserBuilder() {
        }

        public UserBuilder(int id, String user_name, String password) {

            super();
            this.id = id;
            this.user_name = user_name;
            this.password = password;

        }

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setUserName(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() throws EntityException {
            return new User(this);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}