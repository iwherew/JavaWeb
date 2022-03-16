package com.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 快速入门
 * */

public class JDBCDemo4_Statement {

    /**
     * 执行DML语句
     * */
    @Test
    public void testDML() throws Exception{
        // 1、注册驱动
        // MySQL 5之后的驱动包，可以省略注册驱动的步骤
        // 自动加载jar包中 META-INF/services/java.sql.Driver 文件中的驱动类
//        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取连接
        // 如果连接的是本机MySQL并且端口号是默认的3306，可以简化书写
//        String url = "jdbc:mysql:///db1?useSSL=false";
        // useSSL=false 禁用警告提示
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3、定义sql语句
        String sql = "update account set money = 4000 where id = 1";

        // 4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        // 5、执行sql
        int count = stmt.executeUpdate(sql); // 执行完DML语句，返回值是受影响的行数

        // 6、处理结果
//        System.out.println(count);
        if(count > 0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

        // 7、释放资源
        stmt.close();
        conn.close();
    }

    /**
     * 执行DDL语句
     * */
    @Test
    public void testDDL() throws Exception{
        // 1、注册驱动
        // MySQL 5之后的驱动包，可以省略注册驱动的步骤
        // 自动加载jar包中 META-INF/services/java.sql.Driver 文件中的驱动类
//        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取连接
        // 如果连接的是本机MySQL并且端口号是默认的3306，可以简化书写
//        String url = "jdbc:mysql:///db1?useSSL=false";
        // useSSL=false 禁用警告提示
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3、定义sql语句
        String sql = "create database db2";

        // 4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        // 5、执行sql
        stmt.executeUpdate(sql); // 执行完DDL语句，返回值成功可能是0

        // 6、处理结果，不出错误就是成功
        System.out.println("成功");

        // 7、释放资源
        stmt.close();
        conn.close();
    }
}
