package com.wizwolf.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class Application {
    private static Application instance = null;

    public static Application getInstance() {
        if (null == instance) {
            synchronized (Application.class) {
                if (null == instance) {
                    instance = new Application();
                }
            }
        }
        return instance;
    }

    public final String	NAME = "Wizwolf®";
    public String MAIN_VERSION = "Release 0.1.4";
    public String DATE_VERSION = "2023-01-24";
    public final String	SUB_TITLE = "Smart Suite ERP,CRM and SCM";
    public final String	COPYRIGHT = "© 2023-2024 Wizwolf®";
    public final String	HOST = "www.adempiere.io";
    private String s_ImplementationVersion = null;
    private String s_ImplementationVendor = null;
    private Image s_image16;
    private ImageIcon s_imageIconLogo;


    private Logger log;

    private Application() {
        log = LoggerFactory.getLogger(Application.class);
    }

    public synchronized boolean startup (boolean isClient) {
        log.info(getSummaryAscii());

        return true;
    }

    public String getSummaryAscii() {
        String retValue = getSummary();
        //  Registered Trademark
        retValue = StringUtils.replace(retValue, "\u00AE", "(r)");
        //  Trademark
        retValue = StringUtils.replace(retValue, "\u2122", "(tm)");
        //  Copyright
        retValue = StringUtils.replace(retValue, "\u00A9", "(c)");
        //  Cr
        //retValue = StringUtils.replace(retValue, Env.NL, " ");
        retValue = StringUtils.replace(retValue, "\n", " ");
        return retValue;
    }

    public String getSummary() {
        StringBuffer sb = new StringBuffer();
        sb.append(NAME).append(" ")
                .append(MAIN_VERSION).append("_").append(DATE_VERSION)
                .append(" - ").append(SUB_TITLE)
                .append(" - ").append(COPYRIGHT)
                .append(" Implementation: ").append(getImplementationVersion())
                .append(" - ").append(getImplementationVendor());
        return sb.toString();
    }

    public String getImplementationVersion() {
        if (s_ImplementationVersion == null) {
            s_ImplementationVersion = Application.class.getPackage().getImplementationVersion();
        }
        if (s_ImplementationVersion == null) {
            s_ImplementationVersion = "WizWolf";
        }
        return s_ImplementationVersion;
    }

    public String getImplementationVendor() {
        if (s_ImplementationVendor == null) {
            s_ImplementationVendor = Application.class.getPackage().getImplementationVendor();
        }
        if (s_ImplementationVendor == null) {
            s_ImplementationVendor = "Supported by WizWolf community";
        }
        return s_ImplementationVendor;
    }

    public Image getImage16() {
        if (this.s_image16 == null) {
            try {
                URL path = ResourceUtils.getURL("classpath:static/images/AD16.png");
                Toolkit tk = Toolkit.getDefaultToolkit();
                s_image16 = tk.getImage(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String getURL() {
        return "http://" + HOST;
    }

    public ImageIcon getImageIconLogo() {
        if (s_imageIconLogo == null) {
            try {
                URL url = ResourceUtils.getURL("classpath:static/images/AD10030.png");
                s_imageIconLogo = new ImageIcon(url);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return s_imageIconLogo;
    }

    public String getSubtitle() {
        return SUB_TITLE;
    }

    /**
     *  Get default (Home) directory
     *  @return Home directory
     */
    public static String getAdempiereHome()
    {
        //  Try Environment
        String retValue = "Ini.getAdempiereHome()";
        //	Look in current Directory
        if (retValue == null && System.getProperty("user.dir").indexOf("Adempiere") != -1)
        {
            retValue = System.getProperty("user.dir");
            int pos = retValue.indexOf("Adempiere");
            retValue = retValue.substring(pos+9);
        }
        if (retValue == null)
            retValue = File.separator + "Adempiere";
        return retValue;
    }   //  getHome
}
