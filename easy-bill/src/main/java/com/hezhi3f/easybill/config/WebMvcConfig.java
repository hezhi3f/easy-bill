package com.hezhi3f.easybill.config;

import com.hezhi3f.easybill.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor)
                .excludePathPatterns("/auth/**", "/checkcode")
                .addPathPatterns("/user/**","/record/**");
    }

    @Autowired
    private void setAuthorityInterceptor(AuthorityInterceptor authorityInterceptor) {
        this.authorityInterceptor = authorityInterceptor;
    }
}
