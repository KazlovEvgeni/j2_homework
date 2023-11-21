package Extends.SingleTable.Implementation;

import Extends.SingleTable.DAO.Student1DAO;
import Extends.SingleTable.POJO.Student1;
import org.hibernate.SessionFactory;

public class Student1DaoImp implements Student1DAO {
    private SessionFactory sessionFactory;

    public Student1DaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createStudent(Student1 student) {
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
    public Student1 readStudent(int id) {
        if(id < 0){
            System.out.println("ID can not be negative");
            return null;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Student1 student = session.get(Student1.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }
}
