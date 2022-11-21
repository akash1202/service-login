package com.ibm.service.login.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {

    @Autowired
    private RestApiProperties restApiProperties;

    public Docket mainApi(){
        return getCommonDocketBuilder(restApiProperties.getTitle()).build().useDefaultResponseMessages(false);
        //default message adds 201 and other response to Swagger docs
    }

    private ApiSelectorBuilder getCommonDocketBuilder(String groupName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                .apis(withClassAnnotation(Api.class))           //only exposing those methods
                .apis(withMethodAnnotation(ApiOperation.class)) // those are explicitly annotated as API operation
                .paths(PathSelectors.any());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Registeration Rest API")
                .description("Rest Api which validate User Registeration Request by Valid Ip locaiton")
                .termsOfServiceUrl("thisisrestapi.com/service")
                .version("0.0.1")
                .contact(getContact())
                .build();
   }

   private Contact getContact(){
        return new Contact("Rest API Support","test.ibm.com/support","support@thisisrestapi.com");
   }
}
