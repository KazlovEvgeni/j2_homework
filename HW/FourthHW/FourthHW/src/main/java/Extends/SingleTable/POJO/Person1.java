package Extends.SingleTable.POJO;

import javax.persistence.*;

@Entity
@Table(name = "person1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Person1 {
    @Id
    @Column(name = "id_person")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public Person1(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person1(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person1() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person: " + "\n" +
                "ID = " + id +
                ", Name = " + name +
                ", Surname = " + surname + "\n";
    }
}