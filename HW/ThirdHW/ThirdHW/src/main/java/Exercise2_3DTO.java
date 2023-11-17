import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Exercise2_3DTO implements Exercise5_6_7DAO {
    @Override
    public Exercise2_3Payer getPayer(int num) throws SQLException, ClassNotFoundException {
        ResultSet payerResult = Exercise2_3Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM payer where idpayer=" + num + ";");
        int id = payerResult.getInt("idpayer");
        String name = payerResult.getString("name");
        return new Exercise2_3Payer(id, name);
    }

    @Override
    public ArrayList<Exercise2_3Payer> getPayers() throws SQLException, ClassNotFoundException {
        ResultSet payerResult = Exercise2_3Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM payer");
        ArrayList<Exercise2_3Payer> payersList = new ArrayList<>();
        while (payerResult.next()) {
            int id = payerResult.getInt("idpayer");
            String name = payerResult.getString("name");
            payersList.add(new Exercise2_3Payer(id, name));
        }
        return payersList;
    }

    @Override
    public Exercise2_3Expenses getExpenses(int num) throws SQLException, ClassNotFoundException {
        ResultSet expensesResult = Exercise2_3Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM expenses where idexpenses=" + num + ";");
        int id = expensesResult.getInt("idexpenses");
        Date date = expensesResult.getDate("date");
        int idPayer = expensesResult.getInt("idpayer");
        double sum = expensesResult.getDouble("sum");
        return new Exercise2_3Expenses(id, date, idPayer, sum);
    }

    @Override
    public ArrayList<Exercise2_3Expenses> getExpenses() throws SQLException, ClassNotFoundException {
        ResultSet expensesResult = Exercise2_3Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM expenses");
        ArrayList<Exercise2_3Expenses> expensesList = new ArrayList<>();
        while (expensesResult.next()) {
            int idExpenses = expensesResult.getInt("idexpenses");
            Date date = expensesResult.getDate("date");
            int idPayer = expensesResult.getInt("idpayer");
            double sum = expensesResult.getDouble("sum");
            expensesList.add(new Exercise2_3Expenses(idExpenses, date, idPayer, sum));
        }
        return expensesList;
    }

    @Override
    public boolean addPayer(Exercise2_3Payer payers) throws SQLException, ClassNotFoundException {
        Exercise2_3Connection
                .getConnection()
                .prepareStatement("INSERT INTO payer VALUES (" +
                        payers.getIdPayer() + ",'" + payers.getName() + "');")
                .executeUpdate();
        return true;
    }

    @Override
    public boolean addExpense(Exercise2_3Expenses expense) throws SQLException, ClassNotFoundException {
        Exercise2_3Connection
                .getConnection()
                .prepareStatement("INSERT INTO expenses VALUES (" +
                        expense.getIdExpenses() + "," +
                        "'" + expense.getDate() + "'," +
                        expense.getIdExpenses() + "," +
                        expense.getSum() + ");")
                .executeUpdate();
        return true;
    }
}
