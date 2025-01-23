package org.example.springboot.service;

import org.example.springboot.DAO.UserDao;
import org.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
