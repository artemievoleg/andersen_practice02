package util;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Person.class);
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

}
