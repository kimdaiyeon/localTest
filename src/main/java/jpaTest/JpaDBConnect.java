package jpaTest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class JpaDBConnect {


    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        DBManager();
    }

    public static void DBManager(){

         final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
         final String DB_URL = "jdbc:mysql://218.39.65.151:3306/ediya2?useSSL=false"; //접속할 DB 서버

         final String USER_NAME = "ediya2"; //DB에 접속할 사용자 이름을 상수로 정의
         final String PASSWORD = "Ediyadb1!"; //사용자의 비밀번호를 상수로 정의

        Connection conn = null;
        Statement state = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("MYSQL connect");

            String sql;
            sql = "select * from tb_customer where cus_email='eodus835@gmail.com'";
            ResultSet rs = state.executeQuery(sql); //SQL문을
            System.out.println("SQL결과"+rs.getString("cus_barcode"));

            rs.close();
            state.close();
            conn.close();

        }catch (Exception e){

        }finally {
            try{
                if(state!=null)
                    state.close();
            }catch(SQLException ex1){
                //
            }

            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException ex1){
                //
            }

        }

        System.out.println("MYSQL close");
    }
}
