import DAO.PetDAO;
import Embaddeble.PetInfo;
import POJO.Pet;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestPetDAOImpl {
    private static PetDAO petDAO;
    private static Connection connection;

    @Before
    public void setUp() throws SQLException {
        petDAO = new PetDAOImpl(TestFourthSessionFactory.getSessionFactory());
        connection = TestFourthConnection.getConnection();
        connection.createStatement().executeUpdate("delete from PET");
    }

    @After
    public void tearDown() throws SQLException {
        petDAO = null;
        connection.createStatement().executeUpdate("delete from PET");
        connection = null;
    }

    @org.junit.Test
    public void testCreatePet() throws SQLException {
        Pet testsPet = new Pet("Chewbacca", new PetInfo());
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        petDAO.createPet(testsPet);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PET where NAME='Chewbacca'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testExercise6() throws SQLException {
        Pet testsPet = new Pet("Chewbacca", new PetInfo());
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        petDAO.exercise6(testsPet);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PET where NAME='Chewbacca'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }
}
