import POJO.Exercise2_3Payer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBSynchronize {
    public void synchronizeDbWithPayer(Exercise2_3Payer payer) throws SQLException, ClassNotFoundException {
        var connection = Exercise2_3Connection.getConnection();
        var sessionFactory = Exercise2_3SessionFactory.getSessionFactory();
        var session = sessionFactory.openSession();
        session.beginTransaction();
        if(session.isDirty()){
            session.flush();
        }


    }
}
