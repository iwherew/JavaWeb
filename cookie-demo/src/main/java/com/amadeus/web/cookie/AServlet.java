package com.amadeus.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送Cookie

        // 中文转码
        String value = "张三";
        value = URLEncoder.encode(value, "UTF-8");

        // 1、创建Cookie对象
        Cookie cookie = new Cookie("username",value);

        // 设置存活时间，单位：秒，存在硬盘上
        // 正数：将Cookie写入浏览器所在的电脑硬盘中，持久化存储，到时间删除
        // 负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭时，Cookie自动销毁
        // 零：删除对应Cookie
        cookie.setMaxAge(7*24*60*60); // 7天

        // 2、发送Cookie, response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
