package com.wizwolf;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        ApplicationContext ctx = builder.headless(false).web(WebApplicationType.NONE).run(args);
        System.out.println( "Hello World!" );
    }
}
