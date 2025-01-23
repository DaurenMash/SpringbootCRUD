package org.example.springboot.DAO;

import org.example.springboot.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();


    void saveOrUpdate(User user);
    User findById(Long id);
    void delete(Long id);

}
