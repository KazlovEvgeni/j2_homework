package Extends.SingleTable.Implementation;

import Extends.SingleTable.DAO.Employee1DAO;
import Extends.SingleTable.POJO.Employee1;
import org.hibernate.SessionFactory;

public class Employee1DaoImpl implements Employee1DAO {
    private SessionFactory sessionFactory;

    public Employee1DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createEmployee(Employee1 employee) {
        if(employee == null){
            System.out.println("Employee can not be null");
            return 0;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        int result = (int) session.save(employee);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Employee1 readEmployee(int id) {
        if(id < 0){
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Employee1 employee = session.get(Employee1.class, id);
        session.getTransaction().commit();
        session.close();
        return employee;
    }
}
