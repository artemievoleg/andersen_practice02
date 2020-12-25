package repository;

import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.MySessionFactory;

import java.util.List;

public class PersonRepository {

    public void createPerson(Person person){
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();

    }

    public List<Person> getAllPersons(){
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        List<Person> personList = session.createQuery("from model.Person").list();
        tx.commit();
        session.close();
        return personList;
    }

    public void deletePerson(Person person) {
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(person);
        tx.commit();
        session.close();
    }

    public Person findById(String id) {
        Session session = MySessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        Person person = session.find(Person.class, id);
        tx.commit();
        session.close();
        return person;
    }
}
