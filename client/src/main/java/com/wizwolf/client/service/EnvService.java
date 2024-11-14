package com.wizwolf.client.service;


import com.wizwolf.client.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Properties;

@Service
public final class EnvService {
    private static final Logger logger = LoggerFactory.getLogger(EnvService.class);
    public static final String NL = System.getProperty("line.separator");
//    private static EnvSrv instance = null;

//    public static EnvSrv getInstance() {
//        if (null == instance) {
//            synchronized (EnvSrv.class) {
//                if (null == instance) { instance = new EnvSrv(); }
//            }
//        }
//        return instance;
//    }

    private Properties s_ctx;
    public final int WINDOW_FIND = 1110;
    public final int WINDOW_MLOOKUP = 1111;
    public final int WINDOW_CUSTOMIZE = 1112;
    public final int TAB_INFO = 77;
    public final String LANG = "#AD_Language";
    public final String LANGUAGE = "#AD_Language";

    private final LanguageService language;

    @Autowired
    public EnvService(LanguageService language) {
        this.language = language;
        this.s_ctx = new Properties();
        this.s_ctx.put(LANGUAGE, this.language.getBaseAD_Language());
    }

    public Properties getCtx()
    {
        return this.s_ctx;
    }

    public Language getLoginLanguage ()
    {
        return this.getLanguage(this.getCtx());
    }

    public Language getLanguage (Properties ctx) {
        if (ctx != null)
        {
            String lang = getAD_Language(ctx);
//            if (Util.isEmpty(lang))
//                lang = getPreference(ctx, 0, "Language", false);
//            if (!Util.isEmpty(lang))
                return this.language.getLanguage(lang);
        }
        return this.language.getBaseLanguage();
    }

    public String getAD_Language(Properties ctx) {
        if (ctx != null)
        {
            String lang = getContext(ctx, LANGUAGE);
            if (StringUtils.hasText(lang))
                return lang;
        }
        return this.language.getBaseAD_Language();
    }

    public String getContext(Properties ctx, String context) {
        if (ctx == null || context == null)
            throw new IllegalArgumentException ("Require Context");
        return ctx.getProperty(context, "");
    }

    /**
     *	Is Sales Order Trx
     *  @param ctx context
     *  @return true if SO (default)
     */
    public boolean isSOTrx (Properties ctx) {
        String s = getContext(ctx, "IsSOTrx");
        if (s != null && s.equals("N"))
            return false;
        return true;
    }

    /**
     *	Set Sales Order Trx
     *  @param ctx context
     *  @param isSOTrx Sales Order Context
     */
    public void setSOTrx(Properties ctx, boolean isSOTrx) {
        if (ctx == null)
            return;
        ctx.setProperty("IsSOTrx", convert(isSOTrx));
    }

    private String convert(boolean value) {
        return value ? "Y" : "N";
    }

    public boolean isBaseLanguage (Properties ctx, String tableName) {
        return language.isBaseLanguage (getAD_Language(ctx));
    }

    public boolean isBaseLanguage(String AD_Language, String tableName) {
        return language.isBaseLanguage(AD_Language);
    }

//    public boolean isBaseLanguage(Language language, String tableName) {
//        return language.isBaseLanguage();
//    }

}
