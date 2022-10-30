package com.sdau.filter;

import com.sdau.util.SYS;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/staff/*"})
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute(SYS.LOGINSTAFF);

        if (obj!=null){
            /*通过过滤器检查，继续执行下一步（下一个过滤器或资源）*/
            chain.doFilter(request,response);
        }else {
            response.getWriter().write(SYS.NOLOGIN);
        }


    }
}
