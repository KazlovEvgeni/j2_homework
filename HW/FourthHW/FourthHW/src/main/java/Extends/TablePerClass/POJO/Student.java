package Extends.TablePerClass.POJO;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
    private int idStud;
    private String faculty;
    private double mark;

    public Student(int id, String name, String surname, int idStud, String faculty, double mark) {
        super(id, name, surname);
        this.idStud = idStud;
        this.faculty = faculty;
        this.mark = mark;
    }

    public Student(int idStud, String faculty, double mark) {
        this.idStud = idStud;
        this.faculty = faculty;
        this.mark = mark;
    }

    public Student() {
    }

    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        this.idStud = idStud;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student: " + "\n" +
                "ID = " + idStud +
                ", Faculty = " + faculty +
                ", Mark = " + mark + "\n";
    }
}
