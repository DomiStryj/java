package servlet;

import java.sql.*;

public class DataBase {
    String url = "jdbc:hsqldb:hsql://localhost/";
    Connection con;
    public DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url, "SA", "");
        this.con=con;
    }
    public void addPremium(String join) throws  SQLException {

        PreparedStatement pdst = con.prepareStatement(
                "UPDATE users SET access='Premium' WHERE username='"+join+"';");
        pdst.executeUpdate();
        pdst.close();
    }
    public void deletePremium(String del) throws  SQLException {

        PreparedStatement pdst = con.prepareStatement(
                "UPDATE users SET access='' WHERE username='"+del+"';");
        pdst.executeUpdate();
        pdst.close();
    }

    public void addUser(String user, String password, String mail) throws SQLException {


        PreparedStatement pdst = con.prepareStatement(
                "insert into USERS (username, email,password, access) "
                        + "values (?, ?, ?, ?);");
        pdst.setString(1, user);
        pdst.setString(2,mail );
        pdst.setString(3, password);
        pdst.setString(4,"");
        pdst.executeUpdate();
        pdst.close();
    }
    public boolean searchData(String user, String password) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs =stmt.executeQuery("select username, password from users;");

        while (rs.next()) {


            String a= rs.getString("username");
            String b = rs.getString("password");
            boolean us =a.equals(user);
            boolean pw =b.equals(password);
            if(us==true && pw==true){

                return true;
            }
        }
        return false;
    }
}
