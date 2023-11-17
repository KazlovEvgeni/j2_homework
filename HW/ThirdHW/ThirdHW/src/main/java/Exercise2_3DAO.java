import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;

import java.sql.SQLException;

public interface Exercise2_3DAO {
    void saveNewPayer(Exercise2_3Payer payer) throws SQLException, ClassNotFoundException;

    boolean deletePayerById(int id);

    Exercise2_3Payer readPayerByIdWithGet(int id);

    Exercise2_3Payer readPayerByIdWithLoad(int id);

    void saveNewExpenses(Exercise2_3Expenses expenses);

    boolean deleteExpensesById(int id);

    Exercise2_3Expenses readExpensesById(int id);

    boolean equalizeExpensesWithExpense(Exercise2_3Expenses expenses);

    boolean equalizePayersWithPayer(Exercise2_3Payer payer);
}
