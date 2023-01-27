package com.example.hexarchdemo.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//Should go in a autoconfigurable library
@Configuration
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    public static final String GENERIC_ERROR_DEF = "Generic error when internal server error by our app";
    public static final String BAD_REQUEST_DEF = "Controled error because of the logic of the compoenet";

    private String title = "Untitle";
    private String description = "No description";
    private Boolean enable = false;
    private Boolean changeBasePath = false;
    private String host = null;
    private Boolean enableTokenButton = true;
    private String basePath = null;
    private String pathSelector = "/**";
}
