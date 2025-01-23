package org.example.springboot.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.example.springboot.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    public EntityManager entityManager;


    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveOrUpdate(User user) {
        entityManager.merge(user);
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

}
