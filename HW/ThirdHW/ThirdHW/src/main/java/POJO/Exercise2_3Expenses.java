package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Exercise2_3Expenses {
    @Id
    @Column(name = "idexpenses")
    private int idExpenses;
    @Column(name = "date")
    private Date date;
    @Column(name = "idpayer")
    private int idPayer;
    @Column(name = "sum")
    private double sum;

    public Exercise2_3Expenses() {
    }

    public Exercise2_3Expenses(int idExpenses, Date date, int idPayer, double sum) {
        this.idExpenses = idExpenses;
        this.date = date;
        this.idPayer = idPayer;
        this.sum = sum;
    }

    public int getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(int idExpenses) {
        this.idExpenses = idExpenses;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdPayer() {
        return idPayer;
    }

    public void setIdPayer(int idPayer) {
        this.idPayer = idPayer;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Expenses: " + "\n" +
                "ID: " + idExpenses + "\n" +
                "Date: " + date + "\n" +
                "ID Payer: " + idPayer + "\n" +
                "Sum: " + sum + "\n";
    }
}
