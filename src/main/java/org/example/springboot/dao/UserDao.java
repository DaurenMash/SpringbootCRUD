package org.example.springboot.dao;

import org.example.springboot.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Long id);

    void delete(Long id);

    void edit(User user);

    void add(User user);

}
