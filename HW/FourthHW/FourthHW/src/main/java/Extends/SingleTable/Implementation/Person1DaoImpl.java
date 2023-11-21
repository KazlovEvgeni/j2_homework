package Extends.SingleTable.Implementation;

import Extends.SingleTable.DAO.Person1DAO;
import Extends.SingleTable.POJO.Person1;
import org.hibernate.SessionFactory;

public class Person1DaoImpl implements Person1DAO {
    private SessionFactory sessionFactory;

    public Person1DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createPerson(Person1 person) {
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
    public Person1 readPerson(int id) {
        if (id < 0) {
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Person1 person = session.get(Person1.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }
}