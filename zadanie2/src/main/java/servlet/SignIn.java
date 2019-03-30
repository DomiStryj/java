package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/index")
public class SignIn  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String password = req.getParameter("password");
        if (user.equals("root") && password.equals("")) {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("<head>\r\n")
                    .append("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"ISO-8859-1\">\r\n")
                    .append("<title>lista</title>\r\n")
                    .append("</head>\r\n")
                    .append("<body>\r\n")
                    .append("<table>\r\n")
                    .append("<tr>\r\n")
                    .append("<th>id</th>\r\n")
                    .append("<th>user</th>\r\n")
                    .append("<th>password</th>\r\n")
                    .append("<th>email</th>\r\n")
                    .append("<th>asscces</th>\r\n")
                    .append("</tr>\r\n");

            String url = "jdbc:hsqldb:hsql://localhost/";

            try {
                Class.forName("org.hsqldb.jdbcDriver");
                Connection con = DriverManager.getConnection(url, "SA", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
                while (rs.next()) {

                    String a = rs.getString("id");
                    String b = rs.getString("username");
                    String c = rs.getString("password");
                    String d = rs.getString("email");
                    String f = rs.getString("access");
                    System.out.println("Rekord = " + a + " " + b + " " + c + " " + d + " " + f);

                    writer.append("<tr>\r\n")
                            .append("<td>" + a + "</td>\r\n")
                            .append("<td>" + b + "</td>\r\n")
                            .append("<td>" + c + "</td>\r\n")
                            .append("<td>" + d + "</td>\r\n")
                            .append("<td>" + f + "</td>\r\n")
                            .append("</tr>\r\n");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }


        }
        else if (user.equals("root*") && password.equals("")){
            resp.sendRedirect("/access.jsp");
        }
        else{
            DataBase check= new DataBase();
            try {
                if(check.searchData(user,password)){
                    resp.sendRedirect("/log.jsp");
                }
                else{
                    resp.sendRedirect("/error.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
