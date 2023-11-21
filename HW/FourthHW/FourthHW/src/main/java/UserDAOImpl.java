import DAO.UserDAO;
import POJO.User;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(User user) {
        if (user == null) {
            System.out.println("User can not be null");
            return;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void exercise6(User user) {
        if (user == null) {
            System.out.println("User can not be null");
            return;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(user);
        session.getTransaction().commit();
        session.close();
        var session1 = sessionFactory.openSession();
        session1.beginTransaction();
        var userResult = session1.get(User.class, save);
        System.out.println("Persistent User ID: " + userResult.getUserID());
        session1.getTransaction().commit();
        session1.close();
    }
}
