package servlet;

import java.sql.*;

public class DataBase {
    String url = "jdbc:hsqldb:hsql://localhost/";
    public DataBase() {

    }
    public void addAccess(String addToUser) throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url, "SA", "");
        PreparedStatement pdst = con.prepareStatement(
                "UPDATE users SET access='Premium' WHERE username='"+addToUser+"';");
        pdst.executeUpdate();
        pdst.close();
    }
    public void deleteAccess(String deleteFromUser) throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url, "SA", "");
        PreparedStatement pdst = con.prepareStatement(
                "UPDATE users SET access='' WHERE username='"+deleteFromUser+"';");
        pdst.executeUpdate();
        pdst.close();
    }

    public void addUser(String user, String password, String mail) throws SQLException, ClassNotFoundException {

        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url, "SA", "");
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
    public boolean searchData(String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url, "SA", "");
        Statement stmt = con.createStatement();
        ResultSet rs =stmt.executeQuery("select username, password from users;");

        while (rs.next()) {


            String a= rs.getString("username");
            String b = rs.getString("password");
            boolean us =a.equals(user);
            boolean pw =b.equals(password);
            if(us==true && pw==true){
                System.out.println("Rekord = " + a + " " + b );
                return true;
            }
        }
        return false;
    }
}
