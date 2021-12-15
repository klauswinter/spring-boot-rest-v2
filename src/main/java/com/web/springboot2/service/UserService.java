package com.web.springboot2.service;

import com.web.springboot2.model.User;

import java.util.Optional;

public interface UserService {
    void createNewUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    Optional<User> findUserById(Long id);
    Iterable<User> getAllUsers();
}
