package com.amadeus.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPatterns匹配规则，优先级从高到低
 *  *精确匹配 "/user/select"
 *  *目录匹配 "/user/*" 可匹配 /user/aaa、/user/bbb
 *  *扩展名匹配 "*.do" 可匹配 aaa.do、bbb.do，不能以/开头，会报错
 *  *任意匹配 "/"、"/*" 可匹配所有，/* 优先级高于 /
 * */

@WebServlet(urlPatterns = {"/user/select"})
public class ServletDemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post!");
    }
}
