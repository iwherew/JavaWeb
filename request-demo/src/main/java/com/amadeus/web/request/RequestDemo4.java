package com.amadeus.web.request;

import javax.net.ssl.StandardConstants;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码问题的解决方案
 * */

@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、POST解决乱码
        // POST解决方式
        request.setCharacterEncoding("UTF-8");

        // 2、获取username
        String username = request.getParameter("username");
        System.out.println(username);

        // 3、GET解决乱码
        // 乱码原因：tomcat进行URL解码，默认的字符集ISO-8859-1
        // 3.1 先对乱码数据进行编码：转为字节数组
//        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 3.2 字节数组解码
//        username = new String(bytes, StandardCharsets.UTF_8);

        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        System.out.println("解决乱码后："+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
