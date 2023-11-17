import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Exercise5_6_7DAO {
    Exercise2_3Payer getPayer(int num) throws SQLException, ClassNotFoundException;

    ArrayList<Exercise2_3Payer> getPayers() throws SQLException, ClassNotFoundException;

    Exercise2_3Expenses getExpenses(int num) throws SQLException, ClassNotFoundException;

    ArrayList<Exercise2_3Expenses> getExpenses() throws SQLException, ClassNotFoundException;

    boolean addPayer(Exercise2_3Payer payers) throws SQLException, ClassNotFoundException;

    boolean addExpense(Exercise2_3Expenses expense) throws SQLException, ClassNotFoundException;
}
