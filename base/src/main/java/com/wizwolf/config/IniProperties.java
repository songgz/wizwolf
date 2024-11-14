package com.wizwolf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ini")
public class IniProperties {
    private String value1;
    private String value2;

    // Getter 和 Setter
    public String getValue1() { return value1; }
    public void setValue1(String value1) { this.value1 = value1; }

    public String getValue2() { return value2; }
    public void setValue2(String value2) { this.value2 = value2; }
}
