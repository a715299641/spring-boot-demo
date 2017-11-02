package com.example.ceshi.ceshi01.config;



import com.example.ceshi.ceshi01.filter.CeshiFilter;
import com.example.ceshi.ceshi01.intercepter.CeshiIntecepter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.Filter;

/**
 * Created by Johm on 2017/3/19.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean("teacherPermissionInterceptor")
    CeshiIntecepter getCeshiInterceptor() {
        return new CeshiIntecepter();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCeshiInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**")
                .excludePathPatterns("/crm/**")
                .excludePathPatterns("/static/**", "/webjars/**", "/favicon.ico", "/error")
                .excludePathPatterns("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs/**");


    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/favicon.ico");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(ceshiFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        //registration.setOrder(Integer.MAX_VALUE - 1) 设置过滤器的执行顺序  从小到大执行
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean("sessionFilter")
    public Filter ceshiFilter() {
        return new CeshiFilter();
    }

}
