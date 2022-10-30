package com.sdau.interceptor;

import com.sdau.util.SYS;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {

    /*在执行Handler之前执行*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(SYS.LOGINSTAFF);
//        System.out.println(obj+"==================");
        boolean hasLogin = (obj!=null);
        if (!hasLogin){
            response.setContentType(SYS.UTF8);
            response.getWriter().write(SYS.NOLOGIN);
            /*跳转登录界面*/
            response.sendRedirect("../login.html");
            return false;
        }
        return true;
    }



    /*正常运行完成后执行*/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }
    /*解析完成后试图执行此方法*/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }


}
