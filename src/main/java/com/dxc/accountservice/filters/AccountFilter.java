package com.dxc.accountservice.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AccountFilter implements Filter {


    private List<String> ips;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        ips = List.of("127.0.0.1", "0.0.0.0", "192.168.0.1","192.168.240.48");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip_ = servletRequest.getLocalAddr();
        boolean isOk = ips.stream().filter(ip -> ip_.equals(ip)).findFirst().isPresent();
        if (!isOk) {
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
