package com.leonardo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Class responsible for automatically
 * creating endpoint documentation.
 * @author lemoraes
 * @since 05/10/2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(apis())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());
    }

    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("com.leonardo.controller");
    }

    private ApiInfo apiInfo() {
    	 
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Restaurants Search")
                .description ("API responsible for searching for restaurants that most closely match customer preference.")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .termsOfServiceUrl("/service.html")
                .version("1.0.0")
                .contact(new Contact("Leonardo Silva Moraes", "https://www.kickresume.com/cv/leo/", "leonardofoz@gmail.com"))
                .build();
 
        return apiInfo;
    }
}
