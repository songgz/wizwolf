package com.wizwolf.client.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.Preferences;

@Component
public final class Ini {
    public static final String COMPIERE_PROPERTY_FILE = "Compiere.properties";

    public static final String P_UID = "ApplicationUserID";
    //private static final String DEFAULT_UID = "System";
    public static final String P_PWD = "ApplicationPassword";
    //private static final String DEFAULT_PWD = "System";
    public static final String P_STORE_PWD = "StorePassword";
    //private static final boolean DEFAULT_STORE_PWD = true;
    public static final String P_DEBUGLEVEL = "DebugLevel";
    //private static final int DEFAULT_DEBUGLEVEL = 0;
    public static final String P_LANGUAGE = "Language";
    //private static final String DEFAULT_LANGUAGE = Language.getName(System.getProperty("user.language") + "_" + System.getProperty("user.country"));
    public static final String P_INI = "FileNameINI";
    //private static final String DEFAULT_INI = "";
    public static final String P_CONNECTION = "Connection";
    //private static final String DEFAULT_CONNECTION = "";
    public static final String P_CONTEXT = "DataSource";
    //private static final String DEFAULT_CONTEXT = "OracleDS";
    //public static final String P_OBJECTS = "ServerObjects";
    //private static final boolean DEFAULT_OBJECTS = true;
    public static final String P_UI_LOOK = "UILookFeel";
    //private static final String DEFAULT_UI_LOOK = "Compiere";
    public static final String P_UI_THEME = "UITheme";
    //private static final String DEFAULT_UI_THEME = "Compiere Theme";
    public static final String P_A_COMMIT = "AutoCommit";
    //private static final boolean DEFAULT_A_COMMIT = true;
    public static final String P_A_LOGIN = "AutoLogin";
    //private static final boolean DEFAULT_A_LOGIN = false;
    public static final String P_COMPIERESYS = "CompiereSys";
    //private static final boolean DEFAULT_COMPIERESYS = false;
    public static final String P_SHOW_ACCT = "ShowAcct";
    //private static final boolean DEFAULT_SHOW_ACCT = false;
    public static final String P_SHOW_TRL = "ShowTrl";
    //private static final boolean DEFAULT_SHOW_TRL = false;
    public static final String P_TEMP_DIR = "TempDir";
    //private static final String DEFAULT_TEMP_DIR = "";
    public static final String P_ROLE = "Role";
    //private static final String DEFAULT_ROLE = "";
    public static final String P_CLIENT = "Client";
    //private static final String DEFAULT_CLIENT = "";
    public static final String P_ORG = "Organization";
    //private static final String DEFAULT_ORG = "";
    public static final String P_PRINTER = "Printer";
    //private static final String DEFAULT_PRINTER = "";
    public static final String P_WAREHOUSE = "Warehouse";
    //private static final String DEFAULT_WAREHOUSE = "";
    public static final String P_TODAY = "Today";
    //private static final Timestamp DEFAULT_TODAY = new Timestamp(System.currentTimeMillis());
    public static final String P_PRINTPREVIEW = "PrintPreview";
    //private static final boolean DEFAULT_PRINTPREVIEW = false;
    private static final String P_WARNING = "Warning";
    //private static final String DEFAULT_WARNING = "Do_not_change_any_of_the_data_as_they_will_have_undocumented_side_effects.";
    //private static final String P_WARNING_de = "WarningD";
    //private static final String DEFAULT_WARNING_de = "Einstellungen_nicht_aendern,_da_diese_undokumentierte_Nebenwirkungen_haben.";
    private static final String[] PROPERTIES = new String[]{"ApplicationUserID", "ApplicationPassword", "DebugLevel", "Language", "FileNameINI", "Connection", "ServerObjects", "StorePassword", "UILookFeel", "UITheme", "AutoCommit", "AutoLogin", "CompiereSys", "ShowAcct", "ShowTrl", "DataSource", "TempDir", "Role", "Client", "Organization", "Printer", "Warehouse", "Today", "PrintPreview", "Warning", "WarningD"};
    //private static final String[] VALUES;
    private static Properties s_prop;
    public static final String ENV_PREFIX = "env.";
    public static final String COMPIERE_HOME = "COMPIERE_HOME";
    private static boolean s_client = true;
    private static boolean s_loaded = false;

    private final Map<String, Object> default_values = new HashMap<>();
    Preferences prefs = Preferences.userNodeForPackage(Ini.class);

    public Ini() {
        default_values.put(P_UID, "System");
        default_values.put(P_PWD, "System");
        default_values.put(P_STORE_PWD, "Y");
        default_values.put(P_DEBUGLEVEL, 0);
        //default_values.put(P_LANGUAGE, Language.getName(System.getProperty("user.language") + "_" + System.getProperty("user.country")));
        default_values.put(P_INI, "FileNameINI");
        default_values.put(P_CONNECTION, "");
        default_values.put(P_CONTEXT, "java:adempiereDB");
        default_values.put(P_UI_LOOK, "Adempiere");
        default_values.put(P_UI_THEME, "Adempiere Theme");
        default_values.put(P_A_COMMIT, true);
        default_values.put(P_A_LOGIN, false);
        default_values.put(P_COMPIERESYS, false);
        default_values.put(P_SHOW_ACCT, false);
        default_values.put(P_SHOW_TRL, "ShowTrl");
        default_values.put(P_TEMP_DIR, "");
        default_values.put(P_ROLE, "");
        default_values.put(P_CLIENT, "");
        default_values.put(P_ORG, "");
        default_values.put(P_PRINTER, "");
        default_values.put(P_WAREHOUSE, "");
        default_values.put(P_TODAY, new Timestamp(System.currentTimeMillis()).toString());
        default_values.put(P_PRINTPREVIEW, false);
        default_values.put(P_WARNING, "Do_not_change_any_of_the_data_as_they_will_have_undocumented_side_effects.");

    }

    public String getString(String key) {
        return prefs.get(key, default_values.get(key).toString());
    }

    public void putString(String key, String value) {
        prefs.put(key, value);
        save();
    }

    public int getInt(String key) {
        return prefs.getInt(key, (Integer) default_values.get(key));
    }

    public void putInt(String key, int value) {
        prefs.putInt(key, value);
        save();
    }

    public boolean getBoolean(String key) {
        return prefs.getBoolean(key, (Boolean) default_values.get(key));
    }

    public void putBoolean(String key, boolean value) {
        prefs.putBoolean(key, value);
        save();
    }

    private void save() {
        try {
            prefs.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(String key) {
        prefs.remove(key);
        save();
    }

    public void clear() {
        try {
            prefs.clear();
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void saveProperties(boolean tryUserHome) {
        // 确保保存
        try {
            prefs.flush(); // 确保设置被保存
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("Ini.saveProperties - Cannot save Properties to - " + e.toString());
        }

//        String fileName = getFileName(tryUserHome);
//        FileOutputStream fos = null;
//
//        try {
//            File f = new File(fileName);
//            fos = new FileOutputStream(f);
//            s_prop.store(fos, "Compiere");
//            fos.flush();
//            fos.close();
//        } catch (Exception var5) {
//            System.err.println("Ini.saveProperties - Cannot save Properties to " + fileName + " - " + var5.toString());
//        } catch (Throwable var6) {
//            System.err.println("Ini.saveProperties - Cannot save Properties to " + fileName + " - " + var6.toString());
//        }
    }

//    public static void loadProperties(boolean reload) {
//        if (reload || s_prop.size() == 0) {
//            loadProperties(getFileName(s_client));
//        }
//
//    }

//    public static boolean loadProperties(String filename) {
//        System.out.println("Ini.loadProperties: " + filename);
//        boolean loadOK = true;
//        boolean firstTime = false;
//        s_prop = new Properties();
//        FileInputStream fis = null;
//
//        try {
//            fis = new FileInputStream(filename);
//            s_prop.load(fis);
//            fis.close();
//        } catch (FileNotFoundException var7) {
//            System.err.println("Ini.loadProperties " + filename + " not found");
//            loadOK = false;
//        } catch (Exception var8) {
//            System.err.println("Ini.loadProperties " + filename + " - " + var8.toString());
//            loadOK = false;
//        } catch (Throwable var9) {
//            System.err.println("Ini.loadProperties " + filename + " - " + var9.toString());
//            loadOK = false;
//        }
//
//        if (!loadOK) {
//            firstTime = true;
////            if (!IniDialog.accept()) {
////                System.exit(-1);
////            }
//        }
//
//        for(int i = 0; i < PROPERTIES.length; ++i) {
//            if (VALUES[i].length() > 0) {
//                checkProperty(PROPERTIES[i], VALUES[i]);
//            }
//        }
//
//        String tempDir = System.getProperty("java.io.tmpdir");
//        if (tempDir == null || tempDir.length() == 1) {
//            tempDir = getCompiereHome();
//        }
//
//        if (tempDir == null) {
//            tempDir = "";
//        }
//
//        checkProperty("TempDir", tempDir);
//        if (!loadOK) {
//            saveProperties(true);
//        }
//
//        s_loaded = true;
//        return firstTime;
//    }

    private String checkProperty(String key, String defaultValue) {
        String result = null;
        if (!key.equals("Warning") && !key.equals("WarningD")) {
            if (!isClient()) {
                result = s_prop.getProperty(key, "xyz" + defaultValue);
            } else {
                result = s_prop.getProperty(key, Secure.encrypt(defaultValue));
            }
        } else {
            result = defaultValue;
        }

        s_prop.setProperty(key, result);
        return result;
    }

//    private static String getFileName(boolean tryUserHome) {
//        if (System.getProperty("PropertyFile") != null) {
//            return System.getProperty("PropertyFile");
//        } else {
//            String base = null;
//            if (tryUserHome && s_client) {
//                base = System.getProperty("user.home");
//            }
//
//            if (!s_client || base == null || base.length() == 0) {
//                String home = getCompiereHome();
//                if (home != null) {
//                    base = home;
//                }
//            }
//
//            if (base != null && !base.endsWith(File.separator)) {
//                base = base + File.separator;
//            }
//
//            if (base == null) {
//                base = "";
//            }
//
//            return base + "Compiere.properties";
//        }
//    }

    public static void setProperty(String key, String value) {
        if (s_prop == null) {
            s_prop = new Properties();
        }

        if (!key.equals("Warning") && !key.equals("WarningD")) {
            if (!isClient()) {
                s_prop.setProperty(key, "xyz" + value);
            } else {
                s_prop.setProperty(key, Secure.encrypt(value));
            }
        } else {
            s_prop.setProperty(key, value);
        }

    }

    public static void setProperty(String key, boolean value) {
        setProperty(key, value ? "Y" : "N");
    }

    public static void setProperty(String key, int value) {
        setProperty(key, String.valueOf(value));
    }

    public static String getProperty(String key) {
        if (key == null) {
            return "";
        } else {
            String retStr = s_prop.getProperty(key, "");
            return retStr != null && retStr.length() != 0 ? Secure.decrypt(retStr) : "";
        }
    }

    public static boolean getPropertyBool(String key) {
        return getProperty(key).equals("Y");
    }

    public static Properties getProperties() {
        return s_prop;
    }

    public static String getAsString() {
        StringBuffer buf = new StringBuffer("Ini - ");
        Enumeration e = s_prop.keys();

        while(e.hasMoreElements()) {
            String key = (String)e.nextElement();
            buf.append(key).append("=");
            buf.append(getProperty(key)).append("; ");
        }

        return buf.toString();
    }

    public static boolean isClient() {
        return s_client;
    }

    public static void setClient(boolean client) {
        s_client = client;
    }

    public static boolean isLoaded() {
        return s_loaded;
    }

    public static String getCompiereHome() {
        String env = System.getProperty("env.COMPIERE_HOME");
        if (env == null) {
            env = System.getProperty("COMPIERE_HOME");
        }

        return env;
    }

    public static void setCompiereHome(String CompiereHome) {
        if (CompiereHome != null && CompiereHome.length() > 0) {
            System.setProperty("COMPIERE_HOME", CompiereHome);
        }

    }

//    static {
//        VALUES = new String[]{"System", "System", String.valueOf(0), DEFAULT_LANGUAGE, "", "", "Y", "Y", "Compiere", "Compiere Theme", "Y", "N", "N", "N", "N", "OracleDS", "", "", "", "", "", "", DEFAULT_TODAY.toString(), "N", "Do_not_change_any_of_the_data_as_they_will_have_undocumented_side_effects.", "Einstellungen_nicht_aendern,_da_diese_undokumentierte_Nebenwirkungen_haben."};
//        s_prop = new Properties();
//        s_client = true;
//        s_loaded = false;
//    }
}

