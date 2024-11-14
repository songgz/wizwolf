package com.wizwolf.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;


public class I18nUtil {
    private ConfigUtil config;
    private MessageSource messageSource;

    private I18nUtil() {
        this.config = ConfigUtil.getInstance();
        this.messageSource = messageSource();
    }

    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        String path = this.config.getStringValue("spring.messages.basename");
        messageSource.setBasenames(path.split(","));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    public String getString(String key) {
        return getMessage(key);
    }

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, String defaultMsg) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }


    private static I18nUtil instance = null;
    public static I18nUtil getInstance() {
        if (null == instance) {
            synchronized (ConfigUtil.class) {
                if (null == instance) {
                    instance = new I18nUtil();
                }
            }
        }
        return instance;
    }

}
