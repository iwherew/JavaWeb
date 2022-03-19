package com.amadeus.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    private ServletConfig config;

    /**
     * 初始化方法：
     * 1、调用时机：默认情况下：Servlet被第一次访问的时候调用
     *      * loadOnStartup
     *          * 负整数：默认值 -1,第一次被访问时创建Servlet
     *          * 0或正整数：服务器启动时创建Servlet,数字越小优先级越高
     * 2、调用次数：1次
     * */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
        this.config = servletConfig;
    }

    /**
     * 提供服务
     * 1、调用时机：每一次Servlet被访问时调用
     * 2、调用次数：每一次
     * */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }

    /**
     * 销毁方法
     * 1、调用时机：内存释放或服务器关闭的时候，Servlet对象会被销毁
     * 2、调用次数：1次
     * */
    public void destroy() {
        System.out.println("destroy....");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public String getServletInfo() {
        return null;
    }
}
