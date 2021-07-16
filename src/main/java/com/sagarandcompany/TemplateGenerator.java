package com.sagarandcompany;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateGenerator {
    public String getTemplate(String templatePath, Map<String, String> data) {
        Map<String, Object> map = new HashMap<>();
        map.put("appList", data);
        Configuration cfg = new Configuration(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        try (StringWriter out = new StringWriter()) {
            Template template = cfg.getTemplate(templatePath);
            template.process(map, out);
            String result = out.getBuffer().toString();
            out.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
