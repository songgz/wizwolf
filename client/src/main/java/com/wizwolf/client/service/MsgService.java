package com.wizwolf.client.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.wizwolf.client.Application;
import com.wizwolf.client.util.Language;
import com.wizwolf.dao.ADMessageRepository;
import com.wizwolf.dao.ADMessageTrlRepository;
import com.wizwolf.entity.ADMessage;
import com.wizwolf.entity.ADMessageTrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public final class MsgService {
    private static final Logger log = LoggerFactory.getLogger(MsgService.class);
    private static final int MAP_SIZE = 1500;
    /**  Separator between Msg and optional Tip     */
    private  final String SEPARATOR = EnvService.NL + EnvService.NL;
    protected static final char MSG_TOKEN = '@';

    Cache<String, Object> m_languages;
    private final EnvService envSrv;
    private final LanguageService langSrv;
    private final ADMessageRepository messageRepo;
    private final ADMessageTrlRepository messageTrlRepo;

    @Autowired
    private MsgService(EnvService envSrv, LanguageService langSrv, ADMessageRepository messageRepo, ADMessageTrlRepository messageTrlRepo) {
        this.envSrv = envSrv;
        this.langSrv = langSrv;
        this.messageRepo = messageRepo;
        this.messageTrlRepo = messageTrlRepo;
        this.m_languages = Caffeine.newBuilder().maximumSize(MAP_SIZE).build();
    }

    /**  The Map                    */
    //private CCache<String,CCache<String,String>> m_languages = new CCache<String,CCache<String,String>>("msg_lang", 2, 0);

    /**
     *  Get Language specific Message Map
     *  @param //ad_language Language Key
     *  @return HashMap of Language
     */
//    private CCache<String,String> getMsgMap (String ad_language)
//    {
//        String AD_Language = ad_language;
//        if (AD_Language == null || AD_Language.length() == 0)
//            AD_Language = Language.getBaseAD_Language();
//        //  Do we have the language ?
//        CCache<String,String> retValue = (CCache<String,String>)m_languages.get(AD_Language);
//        if (retValue != null && retValue.size() > 0)
//            return retValue;
//
//        //  Load Language
//        retValue = initMsg(AD_Language);
//        if (retValue != null)
//        {
//            m_languages.put(AD_Language, retValue);
//            return retValue;
//        }
//        return retValue;
//    }   //  getMsgMap

    private void loadMsg() {
        List<ADMessage> messages = messageRepo.findAll();
        for (ADMessage message : messages) {
            StringBuffer value = new StringBuffer();
            value.append(message.getMsgtext());
            if (message.getMsgtip() != null) {
                value.append(" ").append(SEPARATOR).append(message.getMsgtip());
            }
            m_languages.put(message.getValue(), value.toString());
        }
    }

    private void loadMsg(String AD_Language) {
        List<ADMessageTrl> messageTrls = messageTrlRepo.findByLanguage(AD_Language);
        for (ADMessageTrl messageTrl : messageTrls) {
            StringBuffer value = new StringBuffer();
            value.append(messageTrl.getMsgtext());
            if (messageTrl.getMsgtip() != null) {
                value.append(" ").append(SEPARATOR).append(messageTrl.getMsgtip());
            }
            String key = String.format("%s*%s", AD_Language, messageTrl.getMessage().getValue());
            m_languages.put(key, value.toString());
        }
    }
    /**
     *	Init message HashMap.
     *	The initial call is from ALogin (ConfirmPanel init).
     *	The second from Env.verifyLanguage.
     *  @param AD_Language Language
     *  @return Cache HashMap
     */
//    private CCache<String,String> initMsg (String AD_Language)
//    {
//        //	Trace.printStack();
//        CCache<String,String> msg = new CCache<String,String>("AD_Message", MAP_SIZE, 0);
//        //
//        if (!DB.isConnected())
//        {
//            s_log.log(Level.SEVERE, "No DB Connection");
//            return null;
//        }
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try
//        {
//            if (AD_Language == null || AD_Language.length() == 0 || Env.isBaseLanguage(AD_Language, "AD_Language"))
//                pstmt = DB.prepareStatement("SELECT Value, MsgText, MsgTip FROM AD_Message",  null);
//            else
//            {
//                pstmt = DB.prepareStatement("SELECT m.Value, t.MsgText, t.MsgTip "
//                        + "FROM AD_Message_Trl t, AD_Message m "
//                        + "WHERE m.AD_Message_ID=t.AD_Message_ID"
//                        + " AND t.AD_Language=?", null);
//                pstmt.setString(1, AD_Language);
//            }
//            rs = pstmt.executeQuery();
//
//            //	get values
//            while (rs.next())
//            {
//                String AD_Message = rs.getString(1);
//                StringBuffer MsgText = new StringBuffer();
//                MsgText.append(rs.getString(2));
//                String MsgTip = rs.getString(3);
//                //
//                if (MsgTip != null)			//	messageTip on next line, if exists
//                    MsgText.append(" ").append(SEPARATOR).append(MsgTip);
//                msg.put(AD_Message, MsgText.toString());
//            }
//        }
//        catch (SQLException e)
//        {
//            s_log.log(Level.SEVERE, "initMsg", e);
//            return null;
//        }
//        finally
//        {
//            DB.close(rs, pstmt);
//            rs = null; pstmt = null;
//        }
//        //
//        if (msg.size() < 100)
//        {
//            s_log.log(Level.SEVERE, "Too few (" + msg.size() + ") Records found for " + AD_Language);
//            return null;
//        }
//        s_log.info("Records=" + msg.size() + " - " + AD_Language);
//        return msg;
//    }	//	initMsg

    /**
     *  Reset Message cache
     */
//    public void reset()
//    {
//        if (m_languages == null)
//            return;
//
//        //  clear all languages
//        Iterator<CCache<String, String>> iterator = m_languages.values().iterator();
//        while (iterator.hasNext())
//        {
//            CCache<String, String> hm = iterator.next();
//            hm.reset();
//        }
//        m_languages.clear();
//    }   //  reset

    /**
     *  Return an array of the installed Languages
     *  @return Array of loaded Languages or null
     */
//    public String[] getLanguages()
//    {
//        if (m_languages == null)
//            return null;
//        String[] retValue = new String[m_languages.size()];
//        m_languages.keySet().toArray(retValue);
//        return retValue;
//    }   //  getLanguages

    /**
     *  Check if Language is loaded
     *  @param language Language code
     *  @return true, if language is loaded
     */
//    public boolean isLoaded (String language)
//    {
//        if (m_languages == null)
//            return false;
//        return m_languages.containsKey(language);
//    }   //  isLoaded

    /**
     *  Lookup term
     *  @param AD_Language language
     *  @param text text
     *  @return translated term or null
     */
    private String lookup(String AD_Language, String text) {
        if (text == null) {
            return null;
        }
        if (AD_Language == null || AD_Language.isBlank()) {
            return text;
        }

        // Using a Map to handle hardcoded text mappings for better readability
        Map<String, String> specialCases = new HashMap<>();
        specialCases.put("/", File.separator);
        specialCases.put("\\", File.separator);
        specialCases.put(";", File.pathSeparator);
        specialCases.put(":", File.pathSeparator);
        specialCases.put("ADEMPIERE_HOME", Application.getInstance().getAdempiereHome());

        // Check the OS for script type
        String osName = System.getProperty("os.name");
        if ("Win".equalsIgnoreCase(osName)) {
            specialCases.put("bat", "bat");
        } else {
            specialCases.put("sh", "sh");
        }

        //specialCases.put("CopyRight", Adempiere.COPYRIGHT);

        // Check if text is in the special cases Map
        String result = specialCases.get(text);
        if (result != null) {
            return result;
        }

        // Get the language-specific messages
        //CCache<String, String> langMap = getMsgMap(AD_Language);
//        if (langMap == null) {
//            return null;
//        }

        //return langMap.get(text);
        return null;
    }

//    private String lookup(String AD_Language, String text) {
//        if (text == null)
//            return null;
//        if (AD_Language == null || AD_Language.length() == 0)
//            return text;
//        //  hardcoded trl
//        if (text.equals("/") || text.equals("\\"))
//            return File.separator;
//        if (text.equals(";") || text.equals(":"))
//            return File.pathSeparator;
//        if (text.equals("ADEMPIERE_HOME"))
//            return Adempiere.getAdempiereHome();
//        if (text.equals("bat") || text.equals("sh"))
//        {
//            if (System.getProperty("os.name").startsWith("Win"))
//                return "bat";
//            return "sh";
//        }
//        if (text.equals("CopyRight"))
//            return Adempiere.COPYRIGHT;
//        //
//        CCache<String, String> langMap = getMsgMap(AD_Language);
//        if (langMap == null)
//            return null;
//        return (String)langMap.get(text);
//    }   //  lookup


    /**************************************************************************
     *	Get translated text for AD_Message
     *  @param  AD_Language - Language
     *  @param	AD_Message - Message Key
     *  @return translated text
     */
    public String getMsg(String AD_Language, String AD_Message) {
        if (AD_Message == null || AD_Message.length() == 0)
            return "";

        if (AD_Language == null || AD_Language.length() == 0)
            AD_Language = langSrv.getBaseAD_Language();

        String retStr = lookup(AD_Language, AD_Message);

        if (retStr == null || retStr.length() == 0)
        {
            log.warn("NOT found: " + AD_Message);
            return AD_Message;
        }

        return retStr;
    }	//	getMsg

    /**
     *  Get translated text message for AD_Message
     *  @param  ctx Context to retrieve language
     *  @param	AD_Message - Message Key
     *  @return translated text
     */
    public String getMsg(Properties ctx, String AD_Message) {
        return getMsg (envSrv.getAD_Language(ctx), AD_Message);
    }

    /**
     *  Get translated text message for AD_Message
     *  @param  language Language
     *  @param	AD_Message - Message Key
     *  @return translated text
     */
    public String getMsg(Language language, String AD_Message) {
        return getMsg(language.getAD_Language(), AD_Message);
    }

    /**
     *  Get translated text message for AD_Message
     *  @param  ad_language - Language
     *  @param	AD_Message - Message Key
     *  @param  getText if true only return Text, if false only return Tip
     *  @return translated text
     */
    public String getMsg(String ad_language, String AD_Message, boolean getText) {
        String retStr = getMsg(ad_language, AD_Message);
        int pos = retStr.indexOf(SEPARATOR);

        if (pos == -1) {
            if (getText)
                return retStr;
            else
                return "";
        } else {
            if (getText)
                retStr = retStr.substring (0, pos);
            else
            {
                int start = pos + SEPARATOR.length();
                //	int end = retStr.length();
                retStr = retStr.substring (start);
            }
        }
        return retStr;
    }

    /**
     *  Get translated text message for AD_Message
     *  @param  ctx Context to retrieve language
     *  @param	AD_Message  Message Key
     *  @param  getText if true only return Text, if false only return Tip
     *  @return translated text
     */
    public String getMsg(Properties ctx, String AD_Message, boolean getText) {
        return getMsg(envSrv.getAD_Language(ctx), AD_Message, getText);
    }

    /**
     *  Get translated text message for AD_Message
     *  @param  language Language
     *  @param	AD_Message  Message Key
     *  @param  getText if true only return Text, if false only return Tip
     *  @return translated text
     */
    public String getMsg(Language language, String AD_Message, boolean getText) {
        return getMsg(language.getAD_Language(), AD_Message, getText);
    }

    /**
     *	Get clear text for AD_Message with parameters
     *  @param  ctx Context to retrieve language
     *  @param AD_Message   Message key
     *  @param args         MessageFormat arguments
     *  @return translated text
     *  @see java.text.MessageFormat for formatting options
     */
    public String getMsg(Properties ctx, String AD_Message, Object[] args) {
        return getMsg (envSrv.getAD_Language(ctx), AD_Message, args);
    }

    /**
     *	Get clear text for AD_Message with parameters
     *  @param  language Language
     *  @param AD_Message   Message key
     *  @param args         MessageFormat arguments
     *  @return translated text
     *  @see java.text.MessageFormat for formatting options
     */
    public String getMsg(Language language, String AD_Message, Object[] args) {
        return getMsg(language.getAD_Language(), AD_Message, args);
    }

    /**
     *	Get clear text for AD_Message with parameters
     *  @param ad_language  Language
     *  @param AD_Message   Message key
     *  @param args         MessageFormat arguments
     *  @return translated text
     *  @see java.text.MessageFormat for formatting options
     */
    public String getMsg (String ad_language, String AD_Message, Object[] args) {
        String msg = getMsg(ad_language, AD_Message);
        String retStr = msg;
        try
        {
            retStr = MessageFormat.format(msg, args);	//	format string
        }
        catch (Exception e)
        {
            log.info(msg);
        }
        return retStr;
    }


    /**************************************************************************
     * 	Get Amount in Words
     * 	@param language language
     * 	@param amount numeric amount (352.80)
     * 	@return amount in words (three*five*two 80/100)
     */
//    public String getAmtInWords(Language language, String amount)
//    {
//        if (amount == null || language == null)
//            return amount;
//        //	Try to find Class
//        String className = "org.compiere.util.AmtInWords_";
//        try
//        {
//            className += language.getLanguageCode().toUpperCase();
//            Class<?> clazz = Class.forName(className);
//            AmtInWords aiw = (AmtInWords)clazz.newInstance();
//            return aiw.getAmtInWords(amount);
//        }
//        catch (ClassNotFoundException e)
//        {
//            logger.error("Class not found: " + className);
//        }
//        catch (Exception e)
//        {
//            logger.error(className, e);
//        }
//
//        //	Fallback
//        StringBuffer sb = new StringBuffer();
//        int pos = amount.lastIndexOf('.');
//        int pos2 = amount.lastIndexOf(',');
//        if (pos2 > pos)
//            pos = pos2;
//        for (int i = 0; i < amount.length(); i++)
//        {
//            if (pos == i)	//	we are done
//            {
//                String cents = amount.substring(i+1);
//                sb.append(' ').append(cents).append("/100");
//                break;
//            }
//            else
//            {
//                char c = amount.charAt(i);
//                if (c == ',' || c == '.')	//	skip thousand separator
//                    continue;
//                if (sb.length() > 0)
//                    sb.append("*");
//                sb.append(getMsg(language, String.valueOf(c)));
//            }
//        }
//        return sb.toString();
//    }	//	getAmtInWords


    /**************************************************************************
     *  Get Translation for Element
     *  @param ad_language language
     *  @param ColumnName column name
     *  @param isSOTrx if false PO terminology is used (if exists)
     *  @return Name of the Column or "" if not found
     */
    public String getElement(String ad_language, String ColumnName, boolean isSOTrx)
    {
        if (ColumnName == null || ColumnName.equals(""))
            return "";
        String AD_Language = ad_language;
        if (AD_Language == null || AD_Language.length() == 0)
            AD_Language = langSrv.getBaseAD_Language();

        //	Check AD_Element
        String retStr = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
//        try
//        {
//            try
//            {
//                if (AD_Language == null || AD_Language.length() == 0 || envSrv.isBaseLanguage(AD_Language, "AD_Element"))
//                    pstmt = DB.prepareStatement("SELECT Name, PO_Name FROM AD_Element WHERE UPPER(ColumnName)=?", null);
//                else
//                {
//                    pstmt = DB.prepareStatement("SELECT t.Name, t.PO_Name FROM AD_Element_Trl t, AD_Element e "
//                            + "WHERE t.AD_Element_ID=e.AD_Element_ID AND UPPER(e.ColumnName)=? "
//                            + "AND t.AD_Language=?", null);
//                    pstmt.setString(2, AD_Language);
//                }
//            }
//            catch (Exception e)
//            {
//                return ColumnName;
//            }
//            finally {
//                DB.close(rs);
//                rs = null;
//            }
//            pstmt.setString(1, ColumnName.toUpperCase());
//            rs = pstmt.executeQuery();
//            if (rs.next())
//            {
//                retStr = rs.getString(1);
//                if (!isSOTrx)
//                {
//                    String temp = rs.getString(2);
//                    if (temp != null && temp.length() > 0)
//                        retStr = temp;
//                }
//            }
//        }
//        catch (SQLException e)
//        {
//            s_log.log(Level.SEVERE, "getElement", e);
//            return "";
//        }
//        finally
//        {
//            DB.close(rs, pstmt);
//            rs = null; pstmt = null;
//        }
        if (retStr != null)
            return retStr.trim();
        return retStr;
    }   //  getElement

    /**
     *  Get Translation for Element using Sales terminology
     *  @param ctx context
     *  @param ColumnName column name
     *  @return Name of the Column or "" if not found
     */
    public String getElement(Properties ctx, String ColumnName) {
        return getElement(envSrv.getAD_Language(ctx), ColumnName, true);
    }

    /**
     *  Get Translation for Element
     *  @param ctx context
     *  @param ColumnName column name
     *  @param isSOTrx sales transaction
     *  @return Name of the Column or "" if not found
     */
    public String getElement (Properties ctx, String ColumnName, boolean isSOTrx) {
        return getElement (envSrv.getAD_Language(ctx), ColumnName, isSOTrx);
    }


    /**************************************************************************
     *	"Translate" text.
     *  <pre>
     *		- Check AD_Message.AD_Message 	->	MsgText
     *		- Check AD_Element.ColumnName	->	Name
     *  </pre>
     *  If checking AD_Element, the SO terminology is used.
     *  @param ad_language  Language
     *  @param isSOTrx sales order context
     *  @param text	Text - MsgText or Element Name
     *  @return translated text or original text if not found
     */
    public String translate(String ad_language, boolean isSOTrx, String text)
    {
        if (text == null || text.equals(""))
            return "";
        String AD_Language = ad_language;
        if (AD_Language == null || AD_Language.length() == 0)
            AD_Language = langSrv.getBaseAD_Language();

        //	Check AD_Message
        String retStr = lookup (AD_Language, text);
        if (retStr != null)
            return retStr;

        //	Check AD_Element
        retStr = getElement(AD_Language, text, isSOTrx);
        if (!retStr.equals(""))
            return retStr.trim();

        //	Nothing found
        if (!text.startsWith("*"))
            log.warn("NOT found: " + text);
        return text;
    }	//	translate

    /***
     *	"Translate" text (SO Context).
     *  <pre>
     *		- Check AD_Message.AD_Message 	->	MsgText
     *		- Check AD_Element.ColumnName	->	Name
     *  </pre>
     *  If checking AD_Element, the SO terminology is used.
     *  @param ad_language  Language
     *  @param text	Text - MsgText or Element Name
     *  @return translated text or original text if not found
     */
    public String translate(String ad_language, String text)
    {
        return translate(ad_language, true, text);
    }	//	translate

    /**
     *	"Translate" text.
     *  <pre>
     *		- Check AD_Message.AD_Message 	->	MsgText
     *		- Check AD_Element.ColumnName	->	Name
     *  </pre>
     *  @param ctx  Context
     *  @param text	Text - MsgText or Element Name
     *  @return translated text or original text if not found
     */
    public String translate(Properties ctx, String text)
    {
        if (text == null || text.length() == 0)
            return text;
        String s = (String)ctx.getProperty(text);
        if (s != null && s.length() > 0)
            return s;
        return translate (envSrv.getAD_Language(ctx), envSrv.isSOTrx(ctx), text);
    }

    /**
     *	"Translate" text.
     *  <pre>
     *		- Check AD_Message.AD_Message 	->	MsgText
     *		- Check AD_Element.ColumnName	->	Name
     *  </pre>
     *  @param language Language
     *  @param text     Text
     *  @return translated text or original text if not found
     */
    public String translate(Language language, String text) {
        return translate(language.getAD_Language(), false, text);
    }

    /**
     *	Translate elements enclosed in MSG_TOKEN (at sign)
     *  @param ctx      Context
     *  @param text     Text
     *  @return translated text or original text if not found
     */
    public String parseTranslation(Properties ctx, String text) {
        if (text == null || text.length() == 0)
            return text;

        String inStr = text;
        String msgKey;
        StringBuilder outStr = new StringBuilder();

        int i = inStr.indexOf(MSG_TOKEN);
        while (i != -1)
        {
            outStr.append(inStr.substring(0, i));			// up to MSG_TOKEN
            inStr = inStr.substring(i+1, inStr.length());	// from first MSG_TOKEN

            int j = inStr.indexOf(MSG_TOKEN);				// next MSG_TOKEN
            if (j < 0)										// no second tag
            {
                inStr = MSG_TOKEN + inStr;
                break;
            }

            msgKey = inStr.substring(0, j);
            outStr.append(translate(ctx, msgKey));			// replace context

            inStr = inStr.substring(j+1, inStr.length());	// from second MSG_TOKEN
            i = inStr.indexOf(MSG_TOKEN);
        }

        outStr.append(inStr);           					//	add remainder
        return outStr.toString();
    }   //  parseTranslation


    /**
     * Wrap a message value with tokens so it can be parsed for translation.
     * @param messageValue - the message value or key used to identify
     * the message
     * @return The wrapped message in the form <token><value><token>
     */
    public String wrapMsg(String messageValue) {
        return MSG_TOKEN + messageValue + MSG_TOKEN;
    }

}

