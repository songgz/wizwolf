package com.wizwolf.client.service;

import com.wizwolf.client.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class LanguageService {
//    private static LanguageSrv instance = null;
//
//    public static LanguageSrv getInstance() {
//        if (null == instance) {
//            synchronized (LanguageSrv.class) {
//                if (null == instance) {
//                    instance = new LanguageSrv();
//                }
//            }
//        }
//        return instance;
//    }


    private final String AD_Language_en_US = "en_US";
    private final String AD_Language_ar_TN = "ar_TN";
    private final String AD_Language_bg_BG = "bg_BG";
    private final String AD_Language_ca_ES = "ca_ES";
    private final String AD_Language_da_DK = "da_DK";
    private final String AD_Language_de_DE = "de_DE";
    private final String AD_Language_el_GR = "el_GR";
    private final String AD_Language_en_AU = "en_AU";
    private final String AD_Language_en_CA = "en_CA";
    private final String AD_Language_en_GB = "en_GB";
    private final String AD_Language_es_CL = "es_CL";
    private final String AD_Language_es_CO = "es_CO";
    private final String AD_Language_es_DO = "es_DO";
    private final String AD_Language_es_ES = "es_ES";
    private final String AD_Language_es_MX = "es_MX";
    private final String AD_Language_es_PA = "es_PA";
    private final String AD_Language_es_SV = "es_SV";
    private final String AD_Language_es_VE = "es_VE";
    private final String AD_Language_fa_IR = "fa_IR";
    private final String AD_Language_fi_FI = "fi_FI";
    private final String AD_Language_fr_CA = "fr_CA";
    private final String AD_Language_fr_FR = "fr_FR";
    private final String AD_Language_hr_HR = "hr_HR";
    private final String AD_Language_hu_HU = "hu_HU";
    private final String AD_Language_in_ID = "in_ID";
    private final String AD_Language_it_IT = "it_IT";
    private final String AD_Language_ja_JP = "ja_JP";
    private final String AD_Language_ms_MY = "ms_MY";
    private final String AD_Language_nl_NL = "nl_NL";
    private final String AD_Language_no_NO = "no_NO";
    private final String AD_Language_pl_PL = "pl_PL";
    private final String AD_Language_pt_BR = "pt_BR";
    private final String AD_Language_ro_RO = "ro_RO";
    private final String AD_Language_ru_RU = "ru_RU";
    private final String AD_Language_sl_SI = "sl_SI";
    private final String AD_Language_sr_RS = "sr_RS";
    private final String AD_Language_sv_SE = "sv_SE";
    private final String AD_Language_th_TH = "th_TH";
    private final String AD_Language_vi_VN = "vi_VN";
    private final String AD_Language_zh_CN = "zh_CN";
    private final String AD_Language_zh_TW = "zh_TW";

    private ArrayList<Language> languages ;
    private Language defaultLanguage;
    private Language loginLanguage ;
    //private Logger log = LoggerFactory.getLogger(LanguageService.class);

    private LanguageService() {
        this.languages = new ArrayList<>(20);
        this.init();
        this.loginLanguage = this.languages.get(0);
        this.defaultLanguage = this.languages.get(0);
    }

    private void init() {
        //this.languages = new Language[]{new Language("English", "en_US", Locale.US, (Boolean)null, (String)null, MediaSize.NA.LETTER), new Language("Български (BG)", "bg_BG", new Locale("bg", "BG"), new Boolean(false), "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Català", "ca_ES", new Locale("ca", "ES"), (Boolean)null, "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Deutsch", "de_DE", Locale.GERMANY, (Boolean)null, (String)null, MediaSize.ISO.A4), new Language("English (UK)", "en_GB", Locale.UK, (Boolean)null, (String)null, MediaSize.ISO.A4), new Language("Español", "es_ES", new Locale("es", "ES"), new Boolean(false), "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Français", "fr_FR", Locale.FRANCE, (Boolean)null, (String)null, MediaSize.ISO.A4), new Language("Italiano", "it_IT", Locale.ITALY, (Boolean)null, (String)null, MediaSize.ISO.A4), new Language("Nederlands", "nl_NL", new Locale("nl", "NL"), new Boolean(false), "dd-MM-yyyy", MediaSize.ISO.A4), new Language("Norsk", "np_NO", new Locale("no", "NO"), new Boolean(false), "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Polski", "pl_PL", new Locale("pl", "PL"), new Boolean(false), "dd-MM-yyyy", MediaSize.ISO.A4), new Language("Portuguese (BR)", "pt_BR", new Locale("pt", "BR"), new Boolean(false), "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Русский (Russian)", "ru_RU", new Locale("ru", "RU"), new Boolean(false), "dd-MM-yyyy", MediaSize.ISO.A4), new Language("Svenska", "sv_SE", new Locale("sv", "SE"), new Boolean(false), "dd.MM.yyyy", MediaSize.ISO.A4), new Language("ไทย (TH)", "th_TH", new Locale("th", "TH"), new Boolean(false), "dd/MM/yyyy", MediaSize.ISO.A4), new Language("Việt Nam", "vi_VN", new Locale("vi", "VN"), new Boolean(false), "dd-MM-yyyy", MediaSize.ISO.A4), new Language("简体中文 (CN)", "zh_CN", Locale.CHINA, (Boolean)null, "yyyy-MM-dd", MediaSize.ISO.A4), new Language("繁體中文 (TW)", "zh_TW", Locale.TAIWAN, (Boolean)null, (String)null, MediaSize.ISO.A4)};

        this.languages.add(new Language("English", AD_Language_en_US, Locale.US, null, null, MediaSize.NA.LETTER));
        this.languages.add(new Language("ﺔﻴﺑﺮﻌﻟﺍ (AR)", AD_Language_ar_TN, new Locale("ar", "TN"), Boolean.TRUE, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Български (BG)", AD_Language_bg_BG, new Locale("bg", "BG"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Català", AD_Language_ca_ES, new Locale("ca", "ES"), null, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Deutsch", AD_Language_de_DE, Locale.GERMANY, Boolean.TRUE, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Dansk", AD_Language_da_DK, new Locale("da", "DK"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("English (AU)", AD_Language_en_AU, new Locale("en", "AU"), null, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("English (UK)", AD_Language_en_GB, Locale.UK, null, null, MediaSize.ISO.A4));
        this.languages.add(new Language("English (CA)", AD_Language_en_CA, new Locale("en", "CA"), null, "MM/dd/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español", AD_Language_es_ES, new Locale("es", "ES"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Español (SV)", AD_Language_es_SV, new Locale("es", "SV"), Boolean.TRUE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (MX)", AD_Language_es_MX, new Locale("es", "MX"), Boolean.TRUE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (CL)", AD_Language_es_CL, new Locale("es", "CL"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (CO)", AD_Language_es_CO, new Locale("es", "ES"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (VE)", AD_Language_es_VE, new Locale("es", "VE"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (PA)", AD_Language_es_PA, new Locale("es", "PA"), Boolean.TRUE, "dd/MM/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Español (EC)", AD_Language_es_ES, new Locale("es", "ES"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Español (DO)", AD_Language_es_DO, new Locale("es", "DO"), Boolean.TRUE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Ελληνικά (GR)", AD_Language_el_GR, new Locale("el", "GR"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Farsi", AD_Language_fa_IR, new Locale("fa", "IR"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Finnish", AD_Language_fi_FI, new Locale("fi", "FI"), Boolean.TRUE, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Français", AD_Language_fr_FR, Locale.FRANCE, Boolean.TRUE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Français (CA)", AD_Language_fr_CA, new Locale("fr", "CA"), Boolean.FALSE, "MM/dd/yyyy", MediaSize.NA.LETTER));
        this.languages.add(new Language("Hrvatski", AD_Language_hr_HR, new Locale("hr", "HR"), null, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Indonesia Bahasa", AD_Language_in_ID, new Locale("in", "ID"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Italiano", AD_Language_it_IT, Locale.ITALY, Boolean.TRUE, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("日本語 (JP)", AD_Language_ja_JP, Locale.JAPAN, null, null, MediaSize.ISO.A4));
        this.languages.add(new Language("Malaysian", AD_Language_ms_MY, new Locale("ms", "MY"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Magyar (HU)", AD_Language_hu_HU, new Locale("hu", "HU"), Boolean.FALSE, "yyyy.MM.dd", MediaSize.ISO.A4));
        this.languages.add(new Language("Nederlands", AD_Language_nl_NL, new Locale("nl", "NL"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Norsk", AD_Language_no_NO, new Locale("no", "NO"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Polski", AD_Language_pl_PL, new Locale("pl", "PL"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Portuguese (BR)", AD_Language_pt_BR, new Locale("pt", "BR"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Română", AD_Language_ro_RO, new Locale("ro", "RO"), Boolean.FALSE, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Русский (Russian)", AD_Language_ru_RU, new Locale("ru", "RU"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Slovenski", AD_Language_sl_SI, new Locale("sl", "SI"), null, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Српски (RS)", AD_Language_sr_RS, new Locale("sr", "RS"), null, "dd.MM.yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Svenska", AD_Language_sv_SE, new Locale("sv", "SE"), Boolean.FALSE, "yyyy-MM-dd", MediaSize.ISO.A4));
        this.languages.add(new Language("ไทย (TH)", AD_Language_th_TH, new Locale("th", "TH"), Boolean.FALSE, "dd/MM/yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("Việt Nam", AD_Language_vi_VN, new Locale("vi", "VN"), Boolean.FALSE, "dd-MM-yyyy", MediaSize.ISO.A4));
        this.languages.add(new Language("简体中文 (CN)", AD_Language_zh_CN, Locale.CHINA, null, "yyyy-MM-dd", MediaSize.ISO.A4));
        this.languages.add(new Language("繁體中文 (TW)", AD_Language_zh_TW, Locale.TAIWAN, null, null, MediaSize.ISO.A4));
    }



    public int getLanguageCount() {
        return this.languages.size();
    }

    public Language getLanguage() {
        return defaultLanguage;
    }

    public void setLanguage(Language language) {
        if (language != null) {
            this.defaultLanguage = language;
            System.out.println(this.defaultLanguage);
        }
    }

    public Language getLanguage(int index) {
        if (index < 0 || index >= this.languages.size()) { return this.loginLanguage; }
        return this.languages.get(index);
    }

    public void addLanguage(Language language) {
        if (language == null) { return; }
        this.languages.add(language);
    }

    public Language getLanguage(String langInfo) {
        String lang = langInfo;
        if (lang == null || lang.length() == 0)
            lang = System.getProperty("user.language", "");

        //	Search existing Languages
        for (Language language : languages) {
            if (lang.equals(language.getName())
                    || lang.equals(language.getLanguageCode())
                    || lang.equals(language.getAD_Language())) {
                return language;
            }
        }

        //	Create Language on the fly
        if (lang.length() == 5)		//	standard format <language>_<Country>
        {
            String language = lang.substring(0,2);
            String country = lang.substring(3);
            Locale locale = new Locale(language, country);
            //log.info ("Adding Language=" + language + ", Country=" + country + ", Locale=" + locale);
            Language ll = new Language (lang, lang, locale);
            languages.add(ll);
            return ll;
        }

        return loginLanguage;
    }

    public String getBaseAD_Language() {
        return this.languages.get(0).getAD_Language();
    }

    public String[] getNames() {
        String[] retValue = new String[this.languages.size()];
        for (int i = 0; i < this.languages.size(); i++)
            retValue[i] = this.languages.get(i).getName();
        return retValue;
    }



    public Language getBaseLanguage() {
        return languages.get(0);
    }

    public Locale getLocale(String langInfo) {
        return getLanguage(langInfo).getLocale();
    }

    public boolean isBaseLanguage(String langInfo) {
        return langInfo == null || langInfo.length() == 0 || langInfo.equals(languages.get(0).getName()) || langInfo.equals(languages.get(0).getLanguageCode()) || langInfo.equals(languages.get(0).getAD_Language());
    }

    public boolean isBaseLanguage()
    {
        return this.equals(getBaseLanguage());
    }

    /**
     *  Get Language Name
     *  @param langInfo either language (en) or locale (en-US) or display name
     *  @return Language Name (e.g. English)
     */
    public String getName (String langInfo) {
        return getLanguage(langInfo).getName();
    }




}
