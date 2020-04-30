package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;

//@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
//@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.collection.*")
@MapperScan("com.collection.dao")
public class CollApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CollApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CollApplication.class);
    }

//    @Bean
//    MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("/app/tmp");
//        return factory.createMultipartConfig();
//    }

}
