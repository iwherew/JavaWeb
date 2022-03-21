package com.amadeus.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  重定向
 *  1、浏览器地址栏会发生变化
 *  2、可以重定向到任意位置资源（内部资源、外部资源）
 *  3、两次请求，不能在多个资源使用request共享数据
 * */

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1...");
        // 1、设置响应状态码 302
//        resp.setStatus(302);
        // 2、设置响应头 Location
//        resp.setHeader("Location","/request-demo/resp2");

        // 简化
        // 动态获取虚拟目录
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
