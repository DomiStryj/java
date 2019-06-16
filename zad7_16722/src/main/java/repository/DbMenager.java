
package repository;

import domain.Gender;
import domain.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DbMenager {
    
    private Connection con = null;
    
    public DbMenager() throws ClassNotFoundException, SQLException {

            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");

    }
    
    public List<Person> getData() {
        List<Person> list = new ArrayList<Person>();

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String q = "Select * from PEOPLE ";
            ResultSet result = stmt.executeQuery(q);
            while (result.next()) {
                Person p = new Person();
                p.setId(result.getInt("ID"));
                p.setFirstName(result.getString("firstName"));
                p.setLastName(result.getString("lastName"));
                String str = result.getString("GENDER");
                if (str.equals("MALE")) {
                    p.setGender(Gender.Male);
                } else {
                    p.setGender(Gender.Female);
                }
                p.setEmail(result.getString("EMAIL"));
                java.sql.Date sqlDate = result.getDate("BIRTHDAY");
                p.setBirthday(new Date(sqlDate.getTime()));
                p.setAge(result.getInt("AGE"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
    
        public void addPerson(Person p)  {

            Statement stmt = null;
            try {
                stmt = con.createStatement();
                String q = "INSERT INTO PEOPLE (FIRSTNAME, LASTNAME, GENDER, EMAIL, BIRTHDAY, AGE) VALUES " +
                        "(" + "'" + p.getFirstName()+ "', '" + p.getLastName() +"', '" + p.getGender()+ "' ,'"
                        + p.getEmail()+"'" +" ," + "'" + new SimpleDateFormat("yyyy/MM/dd").format(p.getBirthday())
                        + "' ," + p.getAge() +")";
                int result = stmt.executeUpdate(q);
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
        
    public void update(Person p)  {

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String q = "UPDATE PEOPLE SET FIRSTNAME='"+ p.getFirstName()+"'"+ "," + "LASTNAME='"
                    + p.getLastName()+"'" + "," + "GENDER='" + p.getGender()+"'" + "," + "Email='"
                    + p.getEmail()+"'" +"," + "BIRTHDAY='" + new SimpleDateFormat("yyyy/MM/dd").format(p.getBirthday())
                    + "'," + "AGE=" + p.getAge() + " where ID=" + p.getId();
            int result = stmt.executeUpdate(q);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void delete(int id)  {

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String q = "Delete from People where ID=" + id;
            int result = stmt.executeUpdate(q);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
