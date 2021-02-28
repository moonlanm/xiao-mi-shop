package edu.hubu.xiaomishop.config;

import edu.hubu.xiaomishop.interceptor.BackendInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author moonlan
 * date 2021/1/12 上午11:37
 */
@SuppressWarnings(value = "unused")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BackendInterceptor()).excludePathPatterns("/img/**", "/manager/login", "/manager/api/login", "/static/css/**", "/static/img/**", "/static/js/**", "/static/layui/**").addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        String property = System.getProperty("user.dir");
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + property + "/images/");
    }
}
