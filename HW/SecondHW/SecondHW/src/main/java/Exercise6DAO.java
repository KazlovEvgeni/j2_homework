import java.sql.SQLException;
import java.util.ArrayList;

public interface Exercise6DAO {
    Exercise6Payer getPayer (int num) throws SQLException, ClassNotFoundException;
    ArrayList<Exercise6Payer> getPayers() throws SQLException, ClassNotFoundException;
    Exercise6Expenses getExpenses(int num) throws SQLException, ClassNotFoundException;
    ArrayList<Exercise6Expenses> getExpenses() throws SQLException, ClassNotFoundException;
    boolean addPayer (Exercise6Payer payers) throws SQLException, ClassNotFoundException;
    boolean addExpense (Exercise6Expenses expense) throws SQLException, ClassNotFoundException;
}
