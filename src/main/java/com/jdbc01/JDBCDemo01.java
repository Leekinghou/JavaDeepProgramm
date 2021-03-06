package com.jdbc01;

import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //使用什么驱动连接数据库

            String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&&useSSL=false";

            con = DriverManager.getConnection(url,"root","MySwan0716");

            stmt = con.createStatement();

            //stmt.executeQuery(sql);
            rs = stmt.executeQuery("select * from user");

            while(rs.next()){
                System.out.println(rs.getInt(1) + ","+ rs.getString(2) + "," + rs.getString(3));
                //System.out.println(rs.getInt("id") + ","+ rs.getString("username") + "," + rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
}
