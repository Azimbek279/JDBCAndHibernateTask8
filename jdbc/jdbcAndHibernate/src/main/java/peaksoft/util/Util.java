package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
     private final static String url = "jdbc:postgresql://localhost:5432/jdbs001";
     private final static String username = "postgres";
     private final static String password = "1234";

     public static Connection getConnection(){
         Connection connection = null;
         try {
             connection = DriverManager.getConnection(url,username,password);
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
         return connection;
     }
}
