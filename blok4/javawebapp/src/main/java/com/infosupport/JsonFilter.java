package com.infosupport;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("*")
public class JsonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // incoming ...
        // ...

        chain.doFilter(request, response);

        // outgoing
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Content-Type", "application/json;charset=UTF-8");
    }
}
