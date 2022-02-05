package com.mycompany.redirectionwebcontext.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "RedirectionFilterSimple", urlPatterns = {"/*"})
public class RedirectionFilterSimple implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.getLogger(RedirectionFilterSimple.class.getName()).log(Level.INFO, "RedirectionFilterSimple init methoduna girdi ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        
        /*Burada istedigimiz url e redirect edebiliriz;*/
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect("https://www.google.com/");
//        httpResponse.sendRedirect(servletRequest.getServletContext().getContextPath() + "/index2.xhtml");
//        httpResponse.sendRedirect("/index2.xhtml");

        // pass the request along the filter chain
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Logger.getLogger(RedirectionFilterSimple.class.getName()).log(Level.INFO, "RedirectionFilterSimple destroy methoduna girdi ");
    }

}
