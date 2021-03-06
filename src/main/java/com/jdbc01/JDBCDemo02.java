package com.jdbc01;

import java.sql.*;

public class JDBCDemo02 {
    public static void main(String[] args) {
        //selectAll();
        //System.out.println(selectByUsernamePassword(username,password));
        //System.out.println(selectByUsernamePassword("jack","ab123"));
        //sql注入
        //System.out.println(selectByUsernamePassword("test","test ' or '1' = '1"));
        //System.out.println(selectByUP2("test","test ' or '1' = '1"));
        //selectAll();
        //insert("James","abc123");
        //delete(13);
        Update(13,"abcd1234");
    }
    public static void selectAll(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            con = JDBCUtils.getConnection();

            String sql = "select * from user ";

            stmt = con.createStatement();

            rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt(1) + ","+ rs.getString(2) + "," + rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.Close(rs,stmt,con);
        }
    }

    public static boolean selectByUsernamePassword(String username,String password){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&&useSSL=false";

            con = DriverManager.getConnection(url,"root","MySwan0716");

            stmt = con.createStatement();

            String sql = " select * from user where username = ' " + username +"' and password = '" + password + "'";
            rs = stmt.executeQuery(sql);

            if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            //Todo Auto-generated catch block
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
        return false;
    }

    //安全写法
    public static boolean selectByUP2(String username,String password){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&&useSSL=false";

            con = DriverManager.getConnection(url,"root","MySwan0716");

            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs = pstmt.executeQuery();
            if(rs.next())
                return true;
            else return false;

        }catch (Exception e){
            //Todo Auto-generated catch block
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
        return false;
    }

    //分页查询
    public static void selectUserByPage(int pageNumber,int pageCount){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/web01?useUnicode=true&characterEncoding=UTF8&&useSSL=false";

            con = DriverManager.getConnection(url,"root","MySwan0716");

            String sql = "select * from user limit ? , ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1,(pageNumber - 1)*pageCount);
            pstmt.setInt(2,pageCount);

            rs = pstmt.executeQuery();


        }catch (Exception e){
            //Todo Auto-generated catch block
            e.printStackTrace();
        }finally {
            try{
                if(rs != null)
                    rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(pstmt != null)
                    pstmt.close();
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


    public static void insert(String username,String password){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = JDBCUtils.getConnection();

            String sql = "insert into user(username,password) values(?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            int result = pstmt.executeUpdate();//返回值代表收到影响的行数 result = 0表示插入不成功
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.Close(rs,pstmt,con);
        }
    }

    public static void delete(int id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = JDBCUtils.getConnection();

            String sql = "delete from user where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            int result = pstmt.executeUpdate();//返回值代表收到影响的行数 result = 1表示删除成功
            if(result > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.Close(rs,pstmt,con);
        }
    }

    public static void Update(int id,String newPassword){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = JDBCUtils.getConnection();
            String sql = "update user set password = ? where id = ? ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,newPassword);
            pstmt.setInt(2,id);
            int result = pstmt.executeUpdate();//返回值代表收到影响的行数 result = 1表示修改成功
            if(result > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            //con.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.Close(rs,pstmt,con);
        }

    }
}
