package kr.or.bit.shoppingMall.Utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHelper {
    public static Connection getConnection(String dsn) { //oracle, mysql
        Connection conn = null;
        try {
            if(dsn.equals("oracle")) {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            }else if(dsn.equals("mysql")) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopmall","system","oracle");
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }

    public static Connection getConnection(String dsn , String id , String pwd) { //oracle, mysql
        Connection conn = null;
        try {
            if(dsn.equals("oracle")) {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
            }else if(dsn.equals("mysql")) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopmall",id,pwd);
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
}
