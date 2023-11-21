import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FourthConnection {
    private static FourthConnection fourthConnection;

    protected FourthConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getFourthConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fourth_hw",
                    "user", "user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) return connection;
            System.out.println("Problems with connection");
            return connection;
    }

    public static Connection getConnection() {
        if (fourthConnection == null) fourthConnection = new FourthConnection();
        return fourthConnection.getFourthConnection();
    }
}
