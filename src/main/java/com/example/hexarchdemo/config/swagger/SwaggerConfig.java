package com.example.hexarchdemo.config.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//Should go in a autoconfigurable library
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {

    private static SwaggerProperties swaggerProperties;

    @Autowired
    public SwaggerConfig(SwaggerProperties swaggerProperties){
        SwaggerConfig.swaggerProperties = swaggerProperties;
    }

    @Bean
    public Docket api() {
        Docket docket = new Docket( DocumentationType.SWAGGER_2 );
        SwaggerConfigUtils.setContextDocket( docket );
        docket
                .directModelSubstitute( LocalDate.class, Date.class)
                .directModelSubstitute( LocalDateTime.class, Date.class)
                .useDefaultResponseMessages( false )
                .select()
                .apis( RequestHandlerSelectors.withClassAnnotation( RestController.class ) )
                .paths(PathSelectors.ant(swaggerProperties.getPathSelector()))
                .build()
                .apiInfo(apiInfo());
        if(swaggerProperties.getEnableTokenButton()){
            docket
                .securitySchemes( Lists.newArrayList(apiKey()) )
                .securityContexts( Lists.newArrayList(securityContext()) );
        }

        return docket;
    }

    // --------------------------------------- private  ------------------------------------

    private ApiKey apiKey(){
        return new ApiKey( "JWT token", HttpHeaders.AUTHORIZATION,"header" );
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
            .securityReferences( defautlAuth() )
            .forPaths( PathSelectors.regex( "/.*" ))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title( swaggerProperties.getTitle() )
            .description( swaggerProperties.getDescription() )
            .contact( new Contact( "Markus Ripple","",null ) )
            .license( "Allianz" )
            .version( "version TODO" )
            .build();
    }

    private List<SecurityReference> defautlAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope( "global","accessEveruthing" );
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference( "JWT token" ,authorizationScopes));
    }
}
