package com.amadeus.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 * */

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置为html，字符集utf-8
        resp.setContentType("text/html;charset=utf-8");
        //  1、获取字符输出流
        PrintWriter writer = resp.getWriter();

        // contentType
//        resp.setHeader("content-type","text/html");

        // 2、写数据
        writer.write("你好");
        writer.write("<h1>bbb</h1>");

        // 细节：流不需要关闭，随着writer销毁会关闭流

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
