package com.registersignin.registersignin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String path = "file:///D:/codecool/JOBHUNT/register-and-sign-in-application/src/main/resources/static";
        registry.addResourceHandler("/can/signin")
                .addResourceLocations(path);
    }
}
