package ru.senya.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.senya.crud.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User ", User.class);
        return List.copyOf(query.getResultList());
    }

    @Override
    public User findUserByID(int id) {
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }
    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }
}
