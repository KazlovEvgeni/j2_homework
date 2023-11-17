import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test_Exercise2_3Connection {
    private static Test_Exercise2_3Connection testConnection;
    private String dbUrl = "jdbc:mysql://localhost:3306/third_hw_test";

    private Test_Exercise2_3Connection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getTestConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, "user", "user");
        return connection;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (testConnection == null) testConnection = new Test_Exercise2_3Connection();
        return testConnection.getTestConnection();
    }
}
