package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/dostep")
public class Admin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String join = req.getParameter("add");
        String del = req.getParameter("delete");
        if(!join.isEmpty()){

            try {
                DataBase add = new DataBase();
                add.addPremium(join);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(!del.isEmpty()){

            try {
                DataBase delete = new DataBase();
                delete.deletePremium(del);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/dostep.jsp");
    }

}
