import java.sql.*;

public class Exercise4_5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Date date = Date.valueOf(args[0]);
        double sum = Double.parseDouble(args[1]);
        String dbUrl = "jdbc:mysql://localhost:3306/second_hw";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl, "user", "user");
        Statement statement = connection.createStatement();
        String insertQuery = "INSERT INTO exercise4_5_expenses (date, sum) VALUES ('"
                + date + "', " + sum + ")";

          //Uncomment to check Exercise5
//        String template = "INSERT INTO exercise4_5_expenses (date, sum) VALUES (?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(template);
//        preparedStatement.setDate(1, date);
//        preparedStatement.setDouble(2, sum);
//        preparedStatement.executeUpdate();

        statement.executeUpdate(insertQuery); //Comment out to check Exercise5

        String printQuery = "SELECT * FROM exercise4_5_expenses";
        ResultSet result = statement.executeQuery(printQuery);
        while (result.next()) {
            System.out.println(result.getString(1)
                    + " " + result.getString(2)
                    + " " + result.getString(3));
        }
    }
}