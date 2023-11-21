package Extends.TablePerClass.POJO;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {
    private int idEmpl;
    private String company;
    private double salary;

    public Employee(int id, String name, String surname, int idEmpl, String company, double salary) {
        super(id, name, surname);
        this.idEmpl = idEmpl;
        this.company = company;
        this.salary = salary;
    }

    public Employee(int idEmpl, String company, double salary) {
        this.idEmpl = idEmpl;
        this.company = company;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(int idEmpl) {
        this.idEmpl = idEmpl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + "\n" +
                "ID = " + idEmpl +
                ", Company = " + company +
                ", Salary = " + salary + "\n";
    }
}
