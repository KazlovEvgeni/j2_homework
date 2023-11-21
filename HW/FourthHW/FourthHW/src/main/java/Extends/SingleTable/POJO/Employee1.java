package Extends.SingleTable.POJO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("employee")
public class Employee1 extends Person1 {
    private int idEmpl;
    private String company;
    private double salary;

    public Employee1(int id, String name, String surname, int idEmpl, String company, double salary) {
        super(id, name, surname);
        this.idEmpl = idEmpl;
        this.company = company;
        this.salary = salary;
    }

    public Employee1(String name, String surname, int idEmpl, String company, double salary) {
        super(name, surname);
        this.idEmpl = idEmpl;
        this.company = company;
        this.salary = salary;
    }

    public Employee1(int idEmpl, String company, double salary) {
        this.idEmpl = idEmpl;
        this.company = company;
        this.salary = salary;
    }

    public Employee1() {
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
