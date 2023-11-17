import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise2_3Connection {
    private static Exercise2_3Connection exercise6Connection;
    private String dbUrl = "jdbc:mysql://localhost:3306/third_hw";

    private Exercise2_3Connection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getExercise6Connection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, "user", "user");
        return connection;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (exercise6Connection == null) exercise6Connection = new Exercise2_3Connection();
        return exercise6Connection.getExercise6Connection();
    }
}
