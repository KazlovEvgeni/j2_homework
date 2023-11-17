import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise9Logic {
    private final String path = "D:\\Java\\HW\\Exercise8_9_10_11\\FirstHW\\src\\main\\resources\\request_quantity.txt";

    public String getReqQuantity() {
        String quantity = "";
        try {
            var scanner = new Scanner(new FileInputStream(path));
            int i;
            while (scanner.hasNext()) {
                i = scanner.nextInt();
                quantity = quantity + i;
            }
            i = Integer.parseInt(quantity) + 1;
            quantity = String.valueOf(i);
            var writer = new FileWriter(path, false);
            writer.write(quantity);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quantity;
    }
}
