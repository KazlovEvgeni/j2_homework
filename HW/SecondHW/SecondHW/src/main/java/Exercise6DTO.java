import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Exercise6DTO implements Exercise6DAO {
    @Override
    public Exercise6Payer getPayer(int num) throws SQLException, ClassNotFoundException {
        ResultSet payerResult = Exercise6Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM payer where idpayer=" + num + ";");
        int id = payerResult.getInt("idpayer");
        String name = payerResult.getString("name");
        return new Exercise6Payer(id, name);
    }

    @Override
    public ArrayList<Exercise6Payer> getPayers() throws SQLException, ClassNotFoundException {
        ResultSet payerResult = Exercise6Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM payer");
        ArrayList<Exercise6Payer> payersList = new ArrayList<>();
        while (payerResult.next()) {
            int id = payerResult.getInt("idpayer");
            String name = payerResult.getString("name");
            payersList.add(new Exercise6Payer(id, name));
        }
        return payersList;
    }

    @Override
    public Exercise6Expenses getExpenses(int num) throws SQLException, ClassNotFoundException {
        ResultSet expensesResult = Exercise6Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM expenses where idexpenses=" + num + ";");
        int id = expensesResult.getInt("idexpenses");
        Date date = expensesResult.getDate("date");
        int idPayer = expensesResult.getInt("idpayer");
        double sum = expensesResult.getDouble("sum");
        return new Exercise6Expenses(id, date, idPayer, sum);
    }

    @Override
    public ArrayList<Exercise6Expenses> getExpenses() throws SQLException, ClassNotFoundException {
        ResultSet expensesResult = Exercise6Connection
                .getConnection()
                .createStatement()
                .executeQuery("SELECT * FROM expenses");
        ArrayList<Exercise6Expenses> expensesList = new ArrayList<>();
        while (expensesResult.next()) {
            int idExpenses = expensesResult.getInt("idexpenses");
            Date date = expensesResult.getDate("date");
            int idPayer = expensesResult.getInt("idpayer");
            double sum = expensesResult.getDouble("sum");
            expensesList.add(new Exercise6Expenses(idExpenses, date, idPayer, sum));
        }
        return expensesList;
    }

    @Override
    public boolean addPayer(Exercise6Payer payers) throws SQLException, ClassNotFoundException {
        Exercise6Connection
                .getConnection()
                .prepareStatement("INSERT INTO payer VALUES (" +
                        payers.getIdPayer() + ",'" + payers.getName() + "');")
                .executeUpdate();
        return true;
    }

    @Override
    public boolean addExpense(Exercise6Expenses expense) throws SQLException, ClassNotFoundException {
        Exercise6Connection
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
