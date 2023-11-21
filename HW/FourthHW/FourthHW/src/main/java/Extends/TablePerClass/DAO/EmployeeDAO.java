package Extends.TablePerClass.DAO;

import Extends.TablePerClass.POJO.Employee;

public interface EmployeeDAO {
    int createEmployee(Employee employee);
    Employee readEmployee(int id);
}
