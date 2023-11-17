import POJO.Exercise2_3Expenses;
import POJO.Exercise2_3Payer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class Exercise2_3DAOImpl implements Exercise2_3DAO {

    private final SessionFactory sessionFactory;

    public Exercise2_3DAOImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("Session Factor cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveNewPayer(Exercise2_3Payer payer) throws SQLException, ClassNotFoundException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean deletePayerById(int id) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Exercise2_3Payer payer = session.get(Exercise2_3Payer.class, id);
        if(payer == null) return false;
        session.delete(payer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Exercise2_3Payer readPayerByIdWithGet(int id) {
        var session = sessionFactory.openSession();
        Exercise2_3Payer payer;
        session.beginTransaction();
        payer = session.get(Exercise2_3Payer.class, id);
        session.getTransaction().commit();
        session.close();
        return payer;
    }

    @Override
    public Exercise2_3Payer readPayerByIdWithLoad(int id) {
        var session = sessionFactory.openSession();
        Exercise2_3Payer payer;
        session.beginTransaction();
        payer = session.load(Exercise2_3Payer.class, id);
        session.getTransaction().commit();
        session.close();
        return payer;
    }

    @Override
    public void saveNewExpenses(Exercise2_3Expenses expenses) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(expenses);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean deleteExpensesById(int id) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Exercise2_3Expenses expenses = session.get(Exercise2_3Expenses.class, id);
        if(expenses == null) return false;
        session.delete(expenses);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Exercise2_3Expenses readExpensesById(int id) {
        var session = sessionFactory.openSession();
        Exercise2_3Expenses expenses;
        session.beginTransaction();
        expenses = session.get(Exercise2_3Expenses.class, id);
        session.getTransaction().commit();
        session.close();
        return expenses;
    }

    @Override
    public boolean equalizeExpensesWithExpense(Exercise2_3Expenses expenses) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Exercise2_3Expenses dbExpenses = session.get(Exercise2_3Expenses.class, expenses.getIdExpenses());
        if(dbExpenses != null){
            dbExpenses.setDate(expenses.getDate());
            dbExpenses.setIdPayer(expenses.getIdPayer());
            dbExpenses.setSum(expenses.getSum());
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean equalizePayersWithPayer(Exercise2_3Payer payer) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Exercise2_3Payer dbPayer = session.get(Exercise2_3Payer.class, payer.getIdPayer());
        if(dbPayer != null){
            dbPayer.setName(payer.getName());
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }
}
