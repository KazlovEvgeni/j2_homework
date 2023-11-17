package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payer")
public class Exercise2_3Payer {
    @Id
    @Column(name = "idpayer")
    private int idPayer;
    @Column(name = "name")
    private String name;
    private double sum;

    public Exercise2_3Payer() {
    }

    public Exercise2_3Payer(int idPayer, String name) {
        this.idPayer = idPayer;
        this.name = name;
    }

    public int getIdPayer() {
        return idPayer;
    }

    public void setIdPayer(int idPayer) {
        this.idPayer = idPayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void addSum(double sum) {
        this.sum += sum;
    }

    @Override
    public String toString() {
        return "Payer: " + "\n" +
                "ID: " + idPayer + "\n" +
                "Name: " + name;
    }
}

