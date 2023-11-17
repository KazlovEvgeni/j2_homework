import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form_servlet")
public class Exercise10Servlet extends HttpServlet {
    Exercise10Logic logic = new Exercise10Logic();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        String email = req.getParameter("email");
        String result = logic.getRequest(name, number, email);
        var out = resp.getWriter();
        out.println(result);
    }
}
