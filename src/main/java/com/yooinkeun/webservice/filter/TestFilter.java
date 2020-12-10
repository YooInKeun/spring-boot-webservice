package com.yooinkeun.webservice.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TestFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse)res).setHeader("HelloHeader", "test");
        chain.doFilter(req, res);
        log.info("Filter > doFilter 실행");
    }

    @Override
    public void destroy() {
        log.info("Filter > destroy 실행");
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        log.info("Filter > init 실행");
    }
}
