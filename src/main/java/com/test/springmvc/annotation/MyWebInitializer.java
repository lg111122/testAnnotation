package com.test.springmvc.annotation;

import com.test.springmvc.annotation.controller.TesetController;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
       //1.创建web  spring容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //2.注册需要添加到容器中的内容
        context.register(AppConfig.class);
        //3.创建servlet 并将web spring容器 交给dispatcherservlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        //4.将dispatcherservlet 交给 servletcontext
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("app", servlet);
        //设置加载优先级
        dynamic.setLoadOnStartup(1);
        //设置请求映射
        dynamic.addMapping("/*");

        TesetController bean = context.getBean(TesetController.class);
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>.."+bean);

    }
}
