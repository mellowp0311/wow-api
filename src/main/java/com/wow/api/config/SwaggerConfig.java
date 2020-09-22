package com.wow.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        String host = getMyIp().contains("192.168") ? "localhost:8080" : "dragonfly14.synology.me:7071";
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wow.api"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private String getMyIp(){
        String localIp;
        try {
            InetAddress local = InetAddress.getLocalHost();
            localIp = local.getHostAddress();
        } catch (UnknownHostException e1) {
            localIp = "UnknownHostException";
        }
        return localIp;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "wow-api","아 할것도 없고 재미도 없고 심심해서 만드는 대장군타우렌 길드 레이드 일정표", "v1.0.0","",
            new Contact("엔트&우취", "",""),"License of API", "API license URL", Collections.emptyList());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}