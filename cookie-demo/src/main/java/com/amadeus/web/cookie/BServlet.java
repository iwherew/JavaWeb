package com.amadeus.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Cookie

        // 1、获取Cookie数组
        Cookie[] cookies = request.getCookies();

        // 2、遍历数组
        for (Cookie cookie: cookies){
            // 3、获取数据
            String name = cookie.getName();
            if("username".equals(name)){
                String value = cookie.getValue();
                // URL解码
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name + ":" + value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
