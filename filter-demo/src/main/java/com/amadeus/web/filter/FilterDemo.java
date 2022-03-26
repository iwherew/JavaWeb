package com.amadeus.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行前，拦截request,对request处理
        System.out.println("1.before");

        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 放行后，访问资源后执行放行后的逻辑，对response处理
        System.out.println("3.after");
    }

    public void destroy() {

    }
}
