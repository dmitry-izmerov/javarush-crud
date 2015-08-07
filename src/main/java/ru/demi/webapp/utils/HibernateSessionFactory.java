package ru.demi.webapp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.demi.webapp.entity.User;

/**
 * Created by demi
 * on 06.08.15.
 */
public class HibernateSessionFactory
{
    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try {
            return new Configuration().
                    configure().
                    addAnnotatedClass(User.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
