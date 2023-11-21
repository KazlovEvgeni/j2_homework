import DAO.UserDAO;
import Embaddeble.UserInfo;
import POJO.User;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestUserDAOImpl {
    private static UserDAO userDAO;
    private static Connection connection;

    @Before
    public void setUp() throws SQLException {
        userDAO = new UserDAOImpl(TestFourthSessionFactory.getSessionFactory());
        connection = TestFourthConnection.getConnection();
        connection.createStatement().executeUpdate("delete from USER");
    }

    @After
    public void tearDown() throws SQLException {
        userDAO = null;
        connection.createStatement().executeUpdate("delete from USER");
        connection = null;
    }

    @org.junit.Test
    public void testCreateUser() throws SQLException {
        User testsUser = new User("Jon", "Snow", new UserInfo());
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        userDAO.createUser(testsUser);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from USER where NAME='Jon' and SURNAME='Snow'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testExercise6() throws SQLException {
        User testsUser = new User("Jon", "Snow", new UserInfo());
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        userDAO.exercise6(testsUser);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from USER where NAME='Jon' and SURNAME='Snow'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }
}
