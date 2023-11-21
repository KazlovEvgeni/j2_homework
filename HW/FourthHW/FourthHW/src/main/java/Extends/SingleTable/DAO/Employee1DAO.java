package Extends.SingleTable.DAO;

import Extends.SingleTable.POJO.Employee1;

public interface Employee1DAO {
    int createEmployee(Employee1 employee);
    Employee1 readEmployee(int id);
}
