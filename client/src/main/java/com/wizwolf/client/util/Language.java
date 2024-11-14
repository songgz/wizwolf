package com.wizwolf.client.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.print.attribute.standard.MediaSize;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Language {


    private String name;
    private String language;  //Language (key)
    private Locale locale;
    private Boolean decimalPoint;
    private Boolean m_leftToRight;
    private SimpleDateFormat m_dateFormat;
    private MediaSize m_mediaSize = MediaSize.ISO.A4;
    private Logger log = LoggerFactory.getLogger(Language.class);

    public Language(String name, String AD_Language, Locale locale, Boolean decimalPoint, String javaDatePattern, MediaSize mediaSize) {

        if (!StringUtils.hasText(name) || !StringUtils.hasText(AD_Language) || ObjectUtils.isEmpty(locale)) {
            throw new IllegalArgumentException ("Language - parameter is null");
        }

        this.name = name;
        this.language = AD_Language;
        this.locale = locale;
        this.decimalPoint = decimalPoint;
        this.setDateFormat(javaDatePattern);
        this.setMediaSize(mediaSize);
    }

    public Language(String name, String AD_Language, Locale locale)
    {
        this(name, AD_Language, locale, null, null, null);
    }

    public String getName() {
        return name;
    }



    public void setDateFormat(String javaDatePattern) {
        if (javaDatePattern == null) { return; }

        this.m_dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale);
        try
        {
            this.m_dateFormat.applyPattern(javaDatePattern);
        }catch(Exception e) {
            log.error(javaDatePattern + " - " + e);
            this.m_dateFormat = null;
        }
    }

    public void setMediaSize(MediaSize size) {
        if (size != null) { m_mediaSize = size; }
    }

    public String getLanguageCode() {
        return locale.getLanguage();
    }

    public String getAD_Language() {
        return language;
    }

    public Locale getLocale() {
        return locale;
    }



}
