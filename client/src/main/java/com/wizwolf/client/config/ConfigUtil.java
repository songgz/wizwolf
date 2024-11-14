package com.wizwolf.client.config;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.util.Properties;

public class ConfigUtil {
    private Properties properties;
    private ConfigUtil() {
        this.initProperties();
    }

    private void initProperties() {
        Resource app = new ClassPathResource("application.yml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(app);
        Properties properties = yamlPropertiesFactoryBean.getObject();
        String active = properties.getProperty("spring.profiles.active");
        if (StringUtils.hasText(active)) {
            Resource a = new ClassPathResource("application-" + active + ".yml");
            yamlPropertiesFactoryBean.setResources(app, a);
        }
        this.properties = yamlPropertiesFactoryBean.getObject();
    }

    public String getStringValue(String key) {
        return this.properties.getProperty(key);
    }

    public Integer getIntegerValue(String key) {
        return Integer.valueOf(this.properties.getProperty(key));
    }


    private static ConfigUtil instance = null;
    public static ConfigUtil getInstance() {
        if (null == instance) {
            synchronized (ConfigUtil.class) {
                if (null == instance) {
                    instance = new ConfigUtil();
                }
            }
        }
        return instance;
    }
}
