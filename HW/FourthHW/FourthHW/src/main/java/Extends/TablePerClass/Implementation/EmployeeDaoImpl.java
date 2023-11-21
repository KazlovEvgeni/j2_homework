package Extends.TablePerClass.Implementation;

import Extends.TablePerClass.DAO.EmployeeDAO;
import Extends.TablePerClass.POJO.Employee;
import Extends.TablePerClass.POJO.Student;
import org.hibernate.SessionFactory;

public class EmployeeDaoImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createEmployee(Employee employee) {
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
    public Employee readEmployee(int id) {
        if(id < 0){
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        session.close();
        return employee;
    }
}
