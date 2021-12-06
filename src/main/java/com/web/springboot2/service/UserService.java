package com.web.springboot2.service;

import com.web.springboot2.model.User;

public interface UserService {
    void createNewUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    Iterable<User> getAllUsers();
}
