package com.youcode.live_coding_gathergrid.repository;

import com.youcode.live_coding_gathergrid.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        User user = find(id);
        if (user == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public User find(long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        String jpqlQuery = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpqlQuery, User.class);
        return query.getResultList();
    }

    public boolean isEmailTaken(String email) {
        String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }
}
