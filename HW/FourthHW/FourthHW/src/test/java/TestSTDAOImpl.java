import Extends.SingleTable.DAO.Employee1DAO;
import Extends.SingleTable.DAO.Person1DAO;
import Extends.SingleTable.DAO.Student1DAO;
import Extends.SingleTable.Implementation.Employee1DaoImpl;
import Extends.SingleTable.Implementation.Person1DaoImpl;
import Extends.SingleTable.Implementation.Student1DaoImp;
import Extends.SingleTable.POJO.Employee1;
import Extends.SingleTable.POJO.Person1;
import Extends.SingleTable.POJO.Student1;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestSTDAOImpl {
    private static Person1DAO daoPerson;
    private static Employee1DAO daoEmployee;
    private static Student1DAO daoStud;
    private static Connection connection;

    @Before
    public void setUp() throws SQLException {
        daoPerson = new Person1DaoImpl(TestFourthSessionFactory.getSessionFactory());
        daoStud = new Student1DaoImp(TestFourthSessionFactory.getSessionFactory());
        daoEmployee = new Employee1DaoImpl(TestFourthSessionFactory.getSessionFactory());
        connection = TestFourthConnection.getConnection();
        connection.createStatement().executeUpdate("delete from PERSON1");
    }

    @After
    public void tearDown() throws SQLException {
        daoPerson = null;
        daoStud = null;
        daoEmployee = null;
        connection.createStatement().executeUpdate("delete from PERSON1");
        connection = null;
    }

    @org.junit.Test
    public void testCretePerson() throws SQLException {
        var person = new Person1("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        daoPerson.createPerson(person);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PERSON1 where NAME='Jon' and SURNAME='Snow'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testCreateStudent() throws SQLException {
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        var student = new Student1("Jon", "Snow", 1, "Math", 7.75);
        daoStud.createStudent(student);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PERSON1 where NAME='Jon' and SURNAME='Snow' and " +
                        "IDSTUD=1 and FACULTY='Math' and MARK=7.75");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testCreateEmployee() throws SQLException {
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        var employee = new Employee1("Jon", "Snow", 1, "IT", 222.22);
        daoEmployee.createEmployee(employee);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PERSON1 where NAME='Jon' and SURNAME='Snow' and " +
                        "IDEMPL=1 and COMPANY='IT' and SALARY=222.22");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testReadPerson(){
        var person = new Person1("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        session.beginTransaction();
        Person1 result = daoPerson.readPerson(idPerson);
        System.out.println(person);
        session.getTransaction().commit();
        session.close();
    }

    @org.junit.Test
    public void testReadStudent(){
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        var student = new Student1("Jon", "Snow", 1, "Math", 7.75);
        int idStudent = daoStud.createStudent(student);
        session.getTransaction().commit();
        session.beginTransaction();
        Student1 result = daoStud.readStudent(idStudent);
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
    }

    @org.junit.Test
    public void testReadEmployee(){
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        var employee = new Employee1("Jon", "Snow", 1, "IT", 222.22);
        int idEmployee = daoEmployee.createEmployee(employee);
        session.getTransaction().commit();
        session.beginTransaction();
        Employee1 result = daoEmployee.readEmployee(idEmployee);
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
    }
}
