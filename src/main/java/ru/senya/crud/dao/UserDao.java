package ru.senya.crud.dao;

import ru.senya.crud.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User findUserByID(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
