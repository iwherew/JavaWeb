package com.amadeus.web;

import com.amadeus.mapper.UserMapper;
import com.amadeus.pojo.User;
import com.amadeus.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2、调用Mybatis完成查询
        // 2.1 获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 2.4 调用方法
        User user = userMapper.select(username, password);

        // 2.5 释放资源
        sqlSession.close();

        // 获取字符输出流，并设置contentType
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 3、判断user是否为null
        if(user != null){
            // 登录成功
            writer.write("登录成功");
        }else{
            // 登录失败
            writer.write("登录失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
