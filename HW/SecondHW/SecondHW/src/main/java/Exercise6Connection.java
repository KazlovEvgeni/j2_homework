import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise6Connection {
    private static Exercise6Connection exercise6Connection;
    private String dbUrl = "jdbc:mysql://localhost:3306/second_hw";

    private Exercise6Connection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getExercise6Connection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, "user", "user");
        return connection;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (exercise6Connection == null) exercise6Connection = new Exercise6Connection();
        return exercise6Connection.getExercise6Connection();
    }
}
