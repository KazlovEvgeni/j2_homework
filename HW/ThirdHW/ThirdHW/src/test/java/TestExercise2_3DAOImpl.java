import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;
import org.hibernate.Session;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class TestExercise2_3DAOImpl {
    Exercise2_3DAO dao;

    @org.junit.Before
    public void setUp() throws SQLException, ClassNotFoundException {
        dao = new Exercise2_3DAOImpl(Test_Exercise2_3SessionFactory.getTestSessionFactory());
    }

    @org.junit.After
    public void terDown() {
        dao = null;
    }

    @org.junit.Test
    public void testSaveNewPayer() throws SQLException, ClassNotFoundException {
        Exercise2_3Payer payer = new Exercise2_3Payer(10, "Wall-e");
        Connection connection = Test_Exercise2_3Connection.getConnection();
        dao.saveNewPayer(payer);
        ResultSet resultSet = connection
                .createStatement()
                .executeQuery("select count(*) from PAYER where IDPAYER=10 and NAME='Wall-e';");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        connection.createStatement().executeUpdate("delete from PAYER where IDPAYER=10 and NAME='Wall-e';");
        connection.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testDeletePayerById() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into PAYER (idpayer, name, sum) values (11, 'Wall-e', 0);");
        connection.close();
        boolean result = dao.deletePayerById(11);
        assertTrue(result);
        connection = Test_Exercise2_3Connection.getConnection();
        ResultSet resultSet = connection
                .createStatement()
                .executeQuery("select count(*) from PAYER where IDPAYER=11 and NAME='Wall-e';");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        connection.createStatement().executeUpdate("delete from PAYER where IDPAYER=11 and NAME='Wall-e';");
        connection.close();
        assertEquals(0, actualCount);
    }

    @org.junit.Test
    public void testReadPayerById() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into PAYER (idpayer, name, sum) values (10, 'Wall-e', 0);");
        connection.close();
        Exercise2_3Payer payer = dao.readPayerByIdWithGet(10);
        connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement().executeUpdate("delete from PAYER where IDPAYER=10 and NAME='Wall-e';");
        connection.close();
        assertNotNull(payer);
        assertEquals(10, payer.getIdPayer());
        assertEquals("Wall-e", payer.getName());
    }

    @org.junit.Test
    public void testSaveNewExpenses() throws SQLException, ClassNotFoundException {
        Exercise2_3Expenses expenses =
                new Exercise2_3Expenses(20, new Date(2020 - 1900, 10,10), 1, 222.22);
        Connection connection = Test_Exercise2_3Connection.getConnection();
        dao.saveNewExpenses(expenses);
        ResultSet resultSet = connection
                .createStatement()
                .executeQuery("select count(*) from EXPENSES where IDEXPENSES=20;");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        connection.createStatement()
                .executeUpdate("delete from EXPENSES where IDEXPENSES=20;");
        connection.close();
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void testDeleteExpensesById() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into EXPENSES (idexpenses, date, idpayer, sum) values (20, '2020-10-10', 1, 222.22);");
        connection.close();
        boolean result = dao.deleteExpensesById(20);
        assertTrue(result);
        connection = Test_Exercise2_3Connection.getConnection();
        ResultSet resultSet = connection
                .createStatement()
                .executeQuery("select count(*) from EXPENSES where IDEXPENSES=20 and DATE='2020-10-10'and IDPAYER=1 and SUM=222.22;");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        connection.createStatement().executeUpdate("delete from EXPENSES where IDEXPENSES=20 and DATE='2020-10-10'and IDPAYER=1 and SUM=222.22;");
        connection.close();
        assertEquals(0, actualCount);
    }

    @org.junit.Test
    public void testReadExpensesById() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into EXPENSES (idexpenses, date, idpayer, sum) values (20, '2020-10-10', 1, 222.22);");
        connection.close();
        Exercise2_3Expenses expenses = dao.readExpensesById(20);
        connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement().executeUpdate("delete from EXPENSES where IDEXPENSES=20 and DATE='2020-10-10'and IDPAYER=1 and SUM=222.22;");
        connection.close();
        assertNotNull(expenses);
        assertEquals(20, expenses.getIdExpenses());
        assertEquals(1, expenses.getIdPayer());
    }

    @org.junit.Test
    public void testEqualizeExpensesWithExpense() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into EXPENSES (idexpenses, date, idpayer, sum) values (20, '2020-10-10', 1, 222.22);");
        connection.close();
        Exercise2_3Expenses expenses = new Exercise2_3Expenses(20, new Date(2020 - 1900, 10, 10), 1, 333.33);
        boolean result = dao.equalizeExpensesWithExpense(expenses);
        connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                        .executeUpdate("delete from EXPENSES where IDEXPENSES=20;");
        connection.close();
        assertTrue(result);
    }

    @org.junit.Test
    public void testEqualizePayersWithPayer() throws SQLException, ClassNotFoundException {
        Connection connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("insert into PAYER (idpayer, name, sum) values (10, 'Wall-e', 0);");
        connection.close();
        Exercise2_3Payer payer = new Exercise2_3Payer(10, "R2-D2");
        boolean result = dao.equalizePayersWithPayer(payer);
        connection = Test_Exercise2_3Connection.getConnection();
        connection.createStatement()
                .executeUpdate("delete from PAYER where IDPAYER=10;");
        connection.close();
        assertTrue(result);
    }
}