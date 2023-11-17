import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_Exercise2_3SessionFactory {
    private static SessionFactory testSessionFactory;

    public static SessionFactory getTestSessionFactory() {
        if (testSessionFactory == null) {
            testSessionFactory = new Configuration()
                    .configure("test.hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return testSessionFactory;
    }
}
