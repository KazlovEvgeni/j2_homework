import java.util.Date;

public class Exercise6Expenses {
    private int idExpenses;
    private Date date;
    private int idPayer;
    private double sum;

    public Exercise6Expenses(int idExpenses, Date date, int idPayer, double sum) {
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
}
