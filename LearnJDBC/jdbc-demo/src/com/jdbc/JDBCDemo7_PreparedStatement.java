package com.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo7_PreparedStatement {

    /**
     * PreparedStatement
     * */

    @Test
    public void testPreparedStatement() throws Exception{
        // 2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名密码
        String name = "zhangsan";
        // sql注入
        String pwd = "' or '1' = '1";

        // 定义sql
        String sql = "select * from user where username = ? and password = ?";

        // 获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置 ? 的值, 索引从 1 开始
        pstmt.setString(1, name);
        pstmt.setString(2,pwd);

        // 执行 sql
        ResultSet rs = pstmt.executeQuery();

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        // 7、 释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }

    /**
     * PreparedStatement 原理
     * */

    @Test
    public void testPreparedStatement2() throws Exception{
        // 2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名密码
        String name = "zhangsan";
        // sql注入
        String pwd = "' or '1' = '1";

        // 定义sql
        String sql = "select * from user where username = ? and password = ?";

        // 获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置 ? 的值, 索引从 1 开始
        pstmt.setString(1, name);
        pstmt.setString(2,pwd);

        // 执行 sql
        ResultSet rs = pstmt.executeQuery();

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        // 7、 释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }

}
