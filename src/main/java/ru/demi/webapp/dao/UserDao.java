package ru.demi.webapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.demi.webapp.dao.exception.DaoSystemException;
import ru.demi.webapp.entity.User;
import ru.demi.webapp.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by demi
 * on 06.08.15.
 */
public class UserDao implements IUserDao
{
    public Integer createUser(String name, int age, boolean isAdmin)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setAge(age);
            user.setIsAdmin(isAdmin);
            id = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
//            throw new DaoSystemException("");
        } finally {
            session.close();
        }
        return id;
    }

    public List<User> findAll()
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List<User> users = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("FROM User").list();
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                User user = (User) iterator.next();
                users.add(user);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    public void updateUser(Integer id, String name, int age, boolean isAdmin)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            user.setName(name);
            user.setAge(age);
            user.setIsAdmin(isAdmin);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public void deleteUser(Integer id)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
}