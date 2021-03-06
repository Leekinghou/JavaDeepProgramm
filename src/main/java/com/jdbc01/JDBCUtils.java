package com.jdbc01;

import java.sql.*;

public class JDBCUtils {
    private static final String connectionURL = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&&useSSL=false";

    private static final String username = "root";

    private static final String password = "MySwan0716";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //使用什么驱动连接数据库

            return DriverManager.getConnection(connectionURL, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void Close(ResultSet rs, Statement stmt, Connection con){
        try{
            if(rs != null)
                rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(stmt != null)
                stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(con != null)
                con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
