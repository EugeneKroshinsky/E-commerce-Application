package innowise.internship.onlineshop.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Initialization of SessionFactory failed: " + e.getMessage());
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

