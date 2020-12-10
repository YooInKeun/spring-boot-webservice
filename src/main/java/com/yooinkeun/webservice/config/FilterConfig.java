package com.yooinkeun.webservice.config;

import com.yooinkeun.webservice.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new TestFilter());
         registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
