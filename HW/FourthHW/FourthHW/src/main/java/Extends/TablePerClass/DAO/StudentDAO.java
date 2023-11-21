package Extends.TablePerClass.DAO;

import Extends.TablePerClass.POJO.Student;

public interface StudentDAO {
    int createStudent(Student student);
    Student readStudent(int id);
}
