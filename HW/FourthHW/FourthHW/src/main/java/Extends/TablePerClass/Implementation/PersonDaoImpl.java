package Extends.TablePerClass.Implementation;

import Extends.TablePerClass.DAO.PersonDAO;
import Extends.TablePerClass.POJO.Person;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class PersonDaoImpl implements PersonDAO {
    private SessionFactory sessionFactory;

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createPerson(Person person) {
        if(person == null){
            System.out.println("Person can not be null");
            return 0;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        int result = (int) session.save(person);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Person readPerson(int id) {
        if (id < 0) {
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }
}
