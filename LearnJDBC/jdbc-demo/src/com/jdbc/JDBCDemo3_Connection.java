package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {

    public static void main(String[] args) throws Exception{
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
        String sql1 = "update account set money = 2000 where id = 1";
        String sql2 = "update account set money = 2000 where id = 2";

        // 4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();


        try {
            // 开启事务
            conn.setAutoCommit(false);

            // 5、执行sql
            int count1 = stmt.executeUpdate(sql1);
            int count2 = stmt.executeUpdate(sql2);

            // 6、处理结果
            System.out.println(count1);
            System.out.println(count2);

            // 异常
            int i = 3/0;

            // 提交事务
            conn.commit();

        } catch (SQLException throwables) {
            // 回滚事务
            conn.rollback();

            throwables.printStackTrace();
        }

        // 7、释放资源
        stmt.close();
        conn.close();
    }
}
