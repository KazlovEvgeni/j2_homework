import Extends.TablePerClass.DAO.EmployeeDAO;
import Extends.TablePerClass.DAO.PersonDAO;
import Extends.TablePerClass.DAO.StudentDAO;
import Extends.TablePerClass.Implementation.EmployeeDaoImpl;
import Extends.TablePerClass.Implementation.PersonDaoImpl;
import Extends.TablePerClass.Implementation.StudentDaoImp;
import Extends.TablePerClass.POJO.Employee;
import Extends.TablePerClass.POJO.Person;
import Extends.TablePerClass.POJO.Student;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestTPCInheritance {
    private static PersonDAO daoPerson;
    private static EmployeeDAO daoEmployee;
    private static StudentDAO daoStud;
    private static Connection connection;

    @Before
    public void setUp() throws SQLException {
        daoPerson = new PersonDaoImpl(TestFourthSessionFactory.getSessionFactory());
        daoStud = new StudentDaoImp(TestFourthSessionFactory.getSessionFactory());
        daoEmployee = new EmployeeDaoImpl(TestFourthSessionFactory.getSessionFactory());
        connection = TestFourthConnection.getConnection();
        connection.createStatement().executeUpdate("delete from STUDENT");
        connection.createStatement().executeUpdate("delete from EMPLOYEE");
        connection.createStatement().executeUpdate("delete from PERSON");
    }

    @After
    public void tearDown() throws SQLException {
        daoPerson = null;
        daoStud = null;
        daoEmployee = null;
        connection.createStatement().executeUpdate("delete from STUDENT");
        connection.createStatement().executeUpdate("delete from EMPLOYEE");
        connection.createStatement().executeUpdate("delete from PERSON");
        connection = null;
    }

    @org.junit.Test
    public void testCretePerson() throws SQLException {
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        daoPerson.createPerson(person);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from PERSON where NAME='Jon' and SURNAME='Snow'");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testCreateStudent() throws SQLException {
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        session.beginTransaction();
        var student = new Student(idPerson, person.getName(), person.getSurname(), 1, "Math", 7.75);
        daoStud.createStudent(student);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from STUDENT where NAME='Jon' and SURNAME='Snow' and " +
                        "IDSTUD=1 and FACULTY='Math' and MARK=7.75");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testCreateEmployee() throws SQLException {
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        session.beginTransaction();
        var employee = new Employee(idPerson, person.getName(), person.getSurname(), 1, "IT", 222.22);
        daoEmployee.createEmployee(employee);
        ResultSet resultSet = connection.createStatement()
                .executeQuery("select count(*) from EMPLOYEE where NAME='Jon' and SURNAME='Snow' and " +
                        "IDEMPL=1 and COMPANY='IT' and SALARY=222.22");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testReadPerson(){
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        session.beginTransaction();
        Person result = daoPerson.readPerson(idPerson);
        System.out.println(person);
        session.getTransaction().commit();
        session.close();
    }

    @org.junit.Test
    public void testReadStudent(){
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        var student = new Student(idPerson, person.getName(), person.getSurname(), 1, "Math", 7.75);
        session.beginTransaction();
        int idStudent = daoStud.createStudent(student);
        session.getTransaction().commit();
        session.beginTransaction();
        Student result = daoStud.readStudent(idStudent);
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
    }

    @org.junit.Test
    public void testReadEmployee(){
        var person = new Person("Jon", "Snow");
        var session = TestFourthSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int idPerson = daoPerson.createPerson(person);
        session.getTransaction().commit();
        session.beginTransaction();
        var employee = new Employee(idPerson, person.getName(), person.getSurname(), 1, "IT", 222.22);
        int idEmployee = daoEmployee.createEmployee(employee);
        session.getTransaction().commit();
        session.beginTransaction();
        Employee result = daoEmployee.readEmployee(idEmployee);
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
    }
}