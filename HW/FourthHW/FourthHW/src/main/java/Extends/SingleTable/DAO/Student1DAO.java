package Extends.SingleTable.DAO;

import Extends.SingleTable.POJO.Student1;

public interface Student1DAO {
    int createStudent(Student1 student);
    Student1 readStudent(int id);
}
