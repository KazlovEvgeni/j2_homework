import java.sql.SQLException;

public class Exercise6Main {
    static Exercise6 exercise6 = new Exercise6();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        exercise6.printPayersWithExpenses();
        System.out.println("-----------");
        exercise6.printSumOfDay();
        System.out.println("-----------");
        exercise6.printMaxExpenses();
    }
}
