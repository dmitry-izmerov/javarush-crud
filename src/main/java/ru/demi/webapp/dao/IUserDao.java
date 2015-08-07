package ru.demi.webapp.dao;

import ru.demi.webapp.entity.User;

import java.util.List;

/**
 * Created by demi
 * on 06.08.15.
 */
public interface IUserDao
{
    Integer createUser(String name, int age, boolean isAdmin);
    List<User> findAll();
    void updateUser(Integer id, String name, int age, boolean isAdmin);
    void deleteUser(Integer id);
}
