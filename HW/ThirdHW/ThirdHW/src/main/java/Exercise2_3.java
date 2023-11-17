import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;

import java.sql.SQLException;
import java.util.Date;

public class Exercise2_3 {

    public void printPayersWithExpenses() throws SQLException, ClassNotFoundException {
        Exercise2_3DTO payerDTO = new Exercise2_3DTO();
        Exercise2_3DTO expensesDTO = new Exercise2_3DTO();
        for (Exercise2_3Payer payer : payerDTO.getPayers()) {
            for (Exercise2_3Expenses expenses : expensesDTO.getExpenses()) {
                if (expenses.getIdPayer() == payer.getIdPayer()) payer.addSum(expenses.getSum());
            }
            System.out.println(payer.getName() + " " + payer.getSum());
        }
    }

    public void printSumOfDay() throws SQLException, ClassNotFoundException {
        Exercise2_3DTO expensesDTO = new Exercise2_3DTO();
        double maxSum = 0.0;
        Date date = new Date();
        for (Exercise2_3Expenses expenses : expensesDTO.getExpenses()) {
            if (expenses.getSum() > maxSum) {
                maxSum = expenses.getSum();
                date = expenses.getDate();
            }
        }
        double resultSum = 0;
        for (Exercise2_3Expenses expenses : expensesDTO.getExpenses()) {
            if (expenses.getDate().equals(date)) resultSum += expenses.getSum();
        }
        System.out.println(date + " -- " + resultSum);
    }

    public void printMaxExpenses() {
    }
}
