package com.example.hexarchdemo.config.swagger;

import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;

//Should go in a autoconfigurable library
@Component
public class SwaggerConfigUtils {

    private static ServletContext servletContext;

    private static SwaggerProperties swaggerProperties;

    public SwaggerConfigUtils(ServletContext servletContext, SwaggerProperties swaggerProperties){
        SwaggerConfigUtils.servletContext = servletContext;
        SwaggerConfigUtils.swaggerProperties = swaggerProperties;
    }

    static void setContextDocket(Docket docket){
        if(swaggerProperties.getEnable() && swaggerProperties.getChangeBasePath()){
            docket
                .host( swaggerProperties.getHost() )
                .pathProvider(
                    new RelativePathProvider( servletContext ){
                        @Override
                        public String getApplicationBasePath(){
                            return swaggerProperties.getBasePath();
                        }
                    }
                );
        }
    }
}
