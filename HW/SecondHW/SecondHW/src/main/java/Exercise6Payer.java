
public class Exercise6Payer {
    private int idPayer;
    private String name;
    private double sum;

    public Exercise6Payer(int idPayer, String name) {
        this.idPayer = idPayer;
        this.name = name;
    }

    public int getIdPayer() {
        return idPayer;
    }

    public String getName() {
        return name;
    }

    public void addSum(double sum) {
        this.sum += sum;
    }
    public double getSum(){
        return sum;
    }
}
