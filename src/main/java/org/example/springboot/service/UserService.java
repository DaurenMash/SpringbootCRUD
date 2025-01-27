package org.example.springboot.service;

import org.example.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void delete(Long id);

    void edit(User user);

    void add(User user);
}
