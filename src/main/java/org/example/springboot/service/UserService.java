package org.example.springboot.service;

import org.example.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();



    void saveOrUpdate(User user);
    User findById(Long id);
    void delete(Long id);
}
