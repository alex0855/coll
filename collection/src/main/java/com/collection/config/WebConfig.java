//package com.collection.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.List;
////
//@EnableWebMvc
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    PassportInterceptor passportInterceptor;
//
//    final String[] notLoginInterceptPaths ={"/favicon.ico","/user/login", "/user/loginPage",  "/user/register",
//        "/user/registerPage", "/user/forget/passwordPage",  "/user/forget/password", "/images/**","/static/**","/index"
//    ,"/alipay/pay","/alipay/notify","/alipay/return","/hello","/find","/back/paysuccess","/back/500"
//    };
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/collTemp/images/");
//        registry.addResourceHandler("/static/**").addResourceLocations("classPath:/static/");
//        registry.addResourceHandler("/favicon.ico/**").addResourceLocations("classPath:/static/");
//    }
//
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns("/**") 表示拦截所有的请求，
//        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//        registry.addInterceptor(passportInterceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
//    }
//
//
////    //消息格式转换
////
////    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        //1.需要定义一个convert转换消息的对象;
////        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
////        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
////        FastJsonConfig fastJsonConfig = new FastJsonConfig();
////        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
////                SerializerFeature.WriteMapNullValue,
////                SerializerFeature.WriteNullStringAsEmpty,
////                SerializerFeature.DisableCircularReferenceDetect,
////                SerializerFeature.WriteNullListAsEmpty,
////                SerializerFeature.WriteDateUseDateFormat);
////        //3处理中文乱码问题
////        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
////        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
////        //4.在convert中添加配置信息.
////        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
////        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
////        //5.将convert添加到converters当中.
////        converters.add(fastJsonHttpMessageConverter);
////    }
//}
