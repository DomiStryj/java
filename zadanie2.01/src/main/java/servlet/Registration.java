package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confPassword");
        String mail = req.getParameter("email");
        Boolean samepassword = confirmPassword.equals(password);
        if (!samepassword || password.isEmpty() || confirmPassword.isEmpty() || user.isEmpty() || mail.isEmpty()) {
            resp.sendRedirect("/error.jsp");
        }
        else {

            try {
                DataBase person= new DataBase();
                person.addUser(user, password, mail);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/index.jsp");

        }
    }
}
