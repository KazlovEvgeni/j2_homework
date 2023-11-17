import java.sql.SQLException;
import java.util.*;

public class Exercise6 {

    public void printPayersWithExpenses() throws SQLException, ClassNotFoundException {
        Exercise6DTO payerDTO = new Exercise6DTO();
        Exercise6DTO expensesDTO = new Exercise6DTO();
        for (Exercise6Payer payer : payerDTO.getPayers()) {
            for (Exercise6Expenses expenses : expensesDTO.getExpenses()) {
                if (expenses.getIdPayer() == payer.getIdPayer()) payer.addSum(expenses.getSum());
            }
            System.out.println(payer.getName() + " " + payer.getSum());
        }
    }

    public void printSumOfDay() throws SQLException, ClassNotFoundException {
        Exercise6DTO expensesDTO = new Exercise6DTO();
        double maxSum = 0.0;
        Date date = new Date();
        for (Exercise6Expenses expenses : expensesDTO.getExpenses()) {
            if (expenses.getSum() > maxSum) {
                maxSum = expenses.getSum();
                date = expenses.getDate();
            }
        }
        double resultSum = 0;
        for (Exercise6Expenses expenses : expensesDTO.getExpenses()) {
            if (expenses.getDate().equals(date)) resultSum += expenses.getSum();
        }
        System.out.println(date + " -- " + resultSum);
    }

    public void printMaxExpenses(){}
}
