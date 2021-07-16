package com.sagarandcompany;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "swagger")

public class SwaggerAppConfig {
    private Map<String, Map<String,String>> application;

    public Map<String, Map<String, String>> getApplication() {
        return application;
    }

    public void setApplication(Map<String, Map<String, String>> application) {
        this.application = application;
    }
}
