package Extends.TablePerClass.Implementation;

import Extends.TablePerClass.DAO.StudentDAO;
import Extends.TablePerClass.POJO.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class StudentDaoImp implements StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createStudent(Student student) {
        if(student == null){
            System.out.println("Student can not be null");
            return 0;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        int result = (int) session.save(student);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Student readStudent(int id) {
        if(id < 0){
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }
}
