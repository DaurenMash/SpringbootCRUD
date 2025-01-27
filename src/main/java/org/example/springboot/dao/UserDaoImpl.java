package org.example.springboot.dao;

import org.springframework.stereotype.Repository;
import org.example.springboot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        if (user.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не должно быть пустым");
        }
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void edit(User user) {
        User userToEdit = findById(user.getId());
        if (userToEdit != null) {
            userToEdit.setName(user.getName());
            entityManager.merge(userToEdit);
        }
    }

}
