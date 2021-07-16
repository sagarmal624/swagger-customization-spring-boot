package com.sagarandcompany;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SwaggerController {
    @Autowired
    SwaggerUiService swaggerUiService;
    @Autowired
    SwaggerAppConfig swaggerAppConfig;

    @GetMapping("/swagger/ui")
    @ResponseBody
    public String ui() {
        Map<String, Map<String, String>> configMap = swaggerAppConfig.getApplication();

        Map<String, String> map = configMap.entrySet().stream().collect(Collectors.toMap(it -> it.getKey(), it -> it.getKey()));

        return swaggerUiService.getSwaggerUi(map);
    }

    @GetMapping("/get/domain/urls")
    @ResponseBody
    public Map<String, String> getUrls(@RequestParam("domain") String domain) {
        Map<String, Map<String, String>> configMap = swaggerAppConfig.getApplication();
        Map<String, String> config = configMap.entrySet().stream().filter(it -> it.getKey().equals(domain)).map(it -> it.getValue()).findFirst().orElse(null);
        return config;
    }

}
