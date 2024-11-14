package com.wizwolf;

import com.formdev.flatlaf.FlatLightLaf;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableCaching
public class AppClient {


    public AppClient() {
        FlatLightLaf.setup();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(AppClient.class);
        ApplicationContext ctx = builder.headless(false).web(WebApplicationType.NONE).run(args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        System.out.println("bean总数:{}" + ctx.getBeanDefinitionCount());

        int i = 0;
        for (String str : beanNames) {
            System.out.println("{},beanName:{}" + (++i) + str);
        }

        WizClient wiz = ctx.getBean(WizClient.class);
        wiz.startup();

    }
}
