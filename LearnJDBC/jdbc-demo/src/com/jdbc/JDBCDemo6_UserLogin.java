package com.jdbc;

import com.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo6_UserLogin {

    /**
     * sql注入
     * */
    @Test
    public void testResultSet() throws Exception{
        // 2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户名密码
        String name = "zhangsan";
        // sql注入
        String pwd = "' or '1' = '1";

        String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        // 7、 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}
