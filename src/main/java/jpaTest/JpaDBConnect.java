package jpaTest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class JpaDBConnect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        try {
            String dbUrl = "jdbc:mysql://218.39.65.151:3306/ediya2?useSSL=false";
            con = DriverManager.getConnection(dbUrl, "ediya2", "Ediyadb1!");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT cus_barcode FROM tb_customer where cus_email='eodus835@naver.com'");

            while(rs.next()) {
                System.out.println(rs.getString("cus_barcode"));
            }
        } catch (SQLException e) {

        } finally {

            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("MYSQL close");
    }
}
