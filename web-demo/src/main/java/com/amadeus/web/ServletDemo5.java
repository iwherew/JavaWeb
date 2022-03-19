package com.amadeus.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post");
    }
}
