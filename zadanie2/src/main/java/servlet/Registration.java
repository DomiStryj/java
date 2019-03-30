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
        String user = req.getParameter("username");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        String mail = req.getParameter("email");
        Boolean samepassword = confPassword.equals(password);
        if (!samepassword || password=="" || confPassword=="" || user=="" || mail=="") {
            resp.sendRedirect("/bad.jsp");
        }
        else {
            DataBase person= new DataBase();
            try {
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
