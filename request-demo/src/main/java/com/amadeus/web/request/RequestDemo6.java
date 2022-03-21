package com.amadeus.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 *  1、浏览器地址栏不会变化
 *  2、只能转发到内部资源
 *  3、一次请求，可以在多个资源使用request共享数据
 * */

@WebServlet("/req6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo-6");
        // 获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);

        // 删除数据
        request.removeAttribute("msg");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
