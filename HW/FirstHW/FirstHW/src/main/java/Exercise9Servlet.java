import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request_quantity")
public class Exercise9Servlet extends HttpServlet {
    Exercise9Logic logic = new Exercise9Logic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var out = resp.getWriter();
        out.println("Request Quantity = " + logic.getReqQuantity());
    }
}
