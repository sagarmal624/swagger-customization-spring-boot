package com.sagarandcompany;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Developer: Sagar Mal Shankhala
 * Email: Sagarmal624@gmail.com
 *
 *
 */
@Service
public class SwaggerUiServiceImpl implements SwaggerUiService {

    @Autowired
    TemplateGenerator templateGenaratorUtil;

    public String getSwaggerUi(Map<String, String> map) {

        return templateGenaratorUtil.getTemplate("index.ftl", map);
    }



}
