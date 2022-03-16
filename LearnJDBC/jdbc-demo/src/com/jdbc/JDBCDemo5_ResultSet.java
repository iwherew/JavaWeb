package com.jdbc;

import com.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo5_ResultSet {

    /**
     * 测试ResultSet
     * 执行DQL
     * */
    @Test
    public void testResultSet() throws Exception{
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
        String sql = "select * from account";

        // 4、获取statement
        Statement stmt = conn.createStatement();

        // 5、执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 6、处理结果，遍历rs中的所有数据
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while(rs.next()){
            // 6.2 获取数据 getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("--------------");
        }

        // 7、 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * 存储到ArrayList中
     * */
    @Test
    public void testResultSet2() throws Exception{
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
        String sql = "select * from account";

        // 4、获取statement
        Statement stmt = conn.createStatement();

        // 5、执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 创建集合
        List<Account> list = new ArrayList<>();

        // 6、处理结果，遍历rs中的所有数据
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while(rs.next()){
            Account account = new Account();

            // 6.2 获取数据 getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            // 赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            // 存入集合
            list.add(account);
        }

        System.out.println(list);

        // 7、 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
