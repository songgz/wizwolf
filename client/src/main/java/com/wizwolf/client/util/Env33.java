package com.wizwolf.client.util;

import com.wizwolf.model.MLookupCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Properties;


public final class Env33 {
	private static final Logger logger = LoggerFactory.getLogger(Env33.class);
	private static Properties s_ctx = new Properties();
	public static final int WINDOW_FIND = 1110;
	public static final int WINDOW_MLOOKUP = 1111;
	public static final int WINDOW_CUSTOMIZE = 1112;
	public static final int TAB_INFO = 77;
	public static final String LANG = "#AD_Language";

	public static final BigDecimal ZERO = new BigDecimal(0.0D);
	public static final String NL = System.getProperty("line.separator");

	public Env33() {
	}




	public static final Properties getCtx() {
		return s_ctx;
	}

	public static void setCtx(Properties ctx) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.setCtx - require Context");
		} else {
			s_ctx.clear();
			s_ctx = ctx;
		}
	}

	public static void setContext(Properties ctx, String context, String value) {
		if (ctx != null && context != null) {
			logger.trace("Context " + context + "==" + value);
			if (value != null && value.length() != 0) {
				ctx.setProperty(context, value);
			} else {
				ctx.remove(context);
			}

		}
	}

	public static void setContext(Properties ctx, String context, int value) {
		if (ctx != null && context != null) {
			logger.trace("Context " + context + "==" + value);
			ctx.setProperty(context, String.valueOf(value));
		}
	}

	public static void setContext(Properties ctx, String context, boolean value) {
		setContext(ctx, context, value ? "Y" : "N");
	}

	public static void setContext(Properties ctx, int WindowNo, String context, String value) {
		if (ctx != null && context != null) {
			if (WindowNo != 1110 && WindowNo != 1111) {
				logger.trace("Context(" + WindowNo + ") " + context + "==" + value);
			}

			if (value != null && !value.equals("")) {
				ctx.setProperty(WindowNo + "|" + context, value);
			} else {
				ctx.remove(WindowNo + "|" + context);
			}

		}
	}

	public static void setContext(Properties ctx, int WindowNo, String context, int value) {
		if (ctx != null && context != null) {
			if (WindowNo != 1110 && WindowNo != 1111) {
				logger.trace("Context(" + WindowNo + ") " + context + "==" + value);
			}

			ctx.setProperty(WindowNo + "|" + context, String.valueOf(value));
		}
	}

	public static void setContext(Properties ctx, int WindowNo, String context, boolean value) {
		setContext(ctx, WindowNo, context, value ? "Y" : "N");
	}

	public static void setContext(Properties ctx, int WindowNo, int TabNo, String context, String value) {
		if (ctx != null && context != null) {
			if (WindowNo != 1110 && WindowNo != 1111) {
				logger.trace("Context(" + WindowNo + "," + TabNo + ") " + context + "==" + value);
			}

			if (value != null && !value.equals("")) {
				ctx.setProperty(WindowNo + "|" + TabNo + "|" + context, value);
			} else {
				ctx.remove(WindowNo + "|" + TabNo + "|" + context);
			}

		}
	}

	public static void setAutoCommit(Properties ctx, boolean autoCommit) {
		if (ctx != null) {
			ctx.setProperty("AutoCommit", autoCommit ? "Y" : "N");
		}
	}

	public static void setAutoCommit(Properties ctx, int WindowNo, boolean autoCommit) {
		if (ctx != null) {
			ctx.setProperty(WindowNo + "|AutoCommit", autoCommit ? "Y" : "N");
		}
	}

	public static String getContext(Properties ctx, String context) {
		if (ctx != null && context != null) {
			return ctx.getProperty(context, "");
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static String getContext(Properties ctx, int WindowNo, String context, boolean onlyWindow) {
		if (ctx != null && context != null) {
			String s = ctx.getProperty(WindowNo + "|" + context);
			if (s == null) {
				if (onlyWindow) {
					return "";
				} else {
					return !context.startsWith("#") && !context.startsWith("$") ? getContext(ctx, "#" + context) : getContext(ctx, context);
				}
			} else {
				return s;
			}
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static String getContext(Properties ctx, int WindowNo, String context) {
		return getContext(ctx, WindowNo, context, false);
	}

	public static String getContext(Properties ctx, int WindowNo, int TabNo, String context) {
		if (ctx != null && context != null) {
			String s = ctx.getProperty(WindowNo + "|" + TabNo + "|" + context);
			return s == null ? getContext(ctx, WindowNo, context, false) : s;
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static int getContextAsInt(Properties ctx, String context) {
		if (ctx != null && context != null) {
			String s = getContext(ctx, context);
			if (s.length() == 0) {
				return 0;
			} else {
				try {
					return Integer.parseInt(s);
				} catch (NumberFormatException var4) {
					logger.error("Env.getContextAsInt (" + context + ") = " + s, var4);
					return 0;
				}
			}
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static int getContextAsInt(Properties ctx, int WindowNo, String context) {
		if (ctx != null && context != null) {
			String s = getContext(ctx, WindowNo, context, false);
			if (s.length() == 0) {
				return 0;
			} else {
				try {
					return Integer.parseInt(s);
				} catch (NumberFormatException var5) {
					logger.error("Env.getContextAsInt (" + context + ") = " + s, var5);
					return 0;
				}
			}
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static boolean isAutoCommit(Properties ctx) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.getContext - require Context");
		} else {
			String s = getContext(ctx, "AutoCommit");
			return s != null && s.equals("Y");
		}
	}

	public static boolean isAutoCommit(Properties ctx, int WindowNo) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.getContext - require Context");
		} else {
			String s = getContext(ctx, WindowNo, "AutoCommit", false);
			if (s != null) {
				return s.equals("Y");
			} else {
				return isAutoCommit(ctx);
			}
		}
	}

	public static Timestamp getContextAsDate(Properties ctx, String context) {
		if (ctx != null && context != null) {
			String s = getContext(ctx, context);
			if (s != null && !s.equals("")) {
				if (s.trim().length() == 10) {
					s = s.trim() + " 00:00:00.0";
				}

				return Timestamp.valueOf(s);
			} else {
				logger.error("Env.getContextAsDate - No value for: " + context);
				return new Timestamp(System.currentTimeMillis());
			}
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static Timestamp getContextAsDate(Properties ctx, int WindowNo, String context) {
		if (ctx != null && context != null) {
			String s = getContext(ctx, WindowNo, context, false);
			if (s != null && !s.equals("")) {
				if (s.trim().length() == 10) {
					s = s.trim() + " 00:00:00.0";
				}

				return Timestamp.valueOf(s);
			} else {
				logger.error("Env.getContextAsDate - No value for: " + context);
				return new Timestamp(System.currentTimeMillis());
			}
		} else {
			throw new IllegalArgumentException("Env.getContext - require Context");
		}
	}

	public static String getPreference(Properties ctx, int AD_Window_ID, String context, boolean system) {
		if (ctx != null && context != null) {
			String retValue = null;
			if (!system) {
				retValue = ctx.getProperty("P" + AD_Window_ID + "|" + context);
				if (retValue == null) {
					retValue = ctx.getProperty("P|" + context);
				}
			} else {
				retValue = ctx.getProperty("#" + context);
				if (retValue == null) {
					retValue = ctx.getProperty("$" + context);
				}
			}

			return retValue == null ? "" : retValue;
		} else {
			throw new IllegalArgumentException("Env.getPreference - require Context");
		}
	}

//	public static boolean isBaseLanguage(Properties ctx, String TableName) {
//		if (!TableName.startsWith("AD") && !TableName.equals("C_UOM")) {
//			if (!isMultiLingualDocument(ctx)) {
//				return true;
//			}
//		} else {
//			LanguageSrv.getInstance().isBaseLanguage(getAD_Language(ctx));
//		}
//
//		return LanguageSrv.getInstance().isBaseLanguage(getAD_Language(ctx));
//	}

//	public static boolean isBaseLanguage(String AD_Language, String TableName) {
//		if (!TableName.startsWith("AD") && !TableName.equals("C_UOM")) {
//			if (!isMultiLingualDocument(s_ctx)) {
//				return true;
//			}
//		} else {
//			LanguageSrv.getInstance().isBaseLanguage(AD_Language);
//		}
//
//		return LanguageSrv.getInstance().isBaseLanguage(AD_Language);
//	}

//	public static boolean isBaseLanguage(Language language, String TableName) {
//		if (!TableName.startsWith("AD") && !TableName.equals("C_UOM")) {
//			if (!isMultiLingualDocument(s_ctx)) {
//				return true;
//			}
//		} else {
//			language.isBaseLanguage();
//		}
//
//		return language.isBaseLanguage();
//	}

	public static boolean isMultiLingualDocument(Properties ctx) {
		return "Y".equals(getContext(ctx, "#IsMultiLingualDocument"));
	}

//	public static String getAD_Language(Properties ctx) {
//		if (ctx != null) {
//			String lang = getContext(ctx, "#AD_Language");
//			if (lang != null || lang.length() > 0) {
//				return lang;
//			}
//		}
//
//		return LanguageSrv.getInstance().getBaseAD_Language();
//	}

//	public static Language getLanguage(Properties ctx) {
//		if (ctx != null) {
//			String lang = getContext(ctx, "#AD_Language");
//			if (lang != null || lang.length() > 0) {
//				return LanguageSrv.getInstance().getLanguage(lang);
//			}
//		}
//
//		return LanguageSrv.getInstance().getLanguage();
//	}

	public static void verifyLanguage(Properties ctx, Language language) {
//		ArrayList sysLang = new ArrayList();
//		String sql = "SELECT AD_Language FROM AD_Language ORDER BY IsBaseLanguage DESC";
//
//		try {
//			PreparedStatement pstmt = DB.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//
//			while(rs.next()) {
//				sysLang.add(rs.getString(1));
//			}
//
//			rs.close();
//			pstmt.close();
//		} catch (SQLException var8) {
//			logger.error("ALogin.verifyLanguage", var8);
//		}
//
//		String selectedLanguage = language.getAD_Language();
//
//		for(int i = 0; i < sysLang.size(); ++i) {
//			if (selectedLanguage.equals(sysLang.get(i))) {
//				return;
//			}
//		}
//
//		selectedLanguage = selectedLanguage.substring(0, 2);
//
//		for(int i = 0; i < sysLang.size(); ++i) {
//			String comp = sysLang.get(i).toString().substring(0, 2);
//			if (selectedLanguage.equals(comp)) {
//				language.setAD_Language(sysLang.get(i).toString());
//				setContext(ctx, "#AD_Language", language.getAD_Language());
//				return;
//			}
//		}
//
//		language.setAD_Language(sysLang.get(0).toString());
//		setContext(ctx, "#AD_Language", language.getAD_Language());
	}

	public static String[] getEntireContext(Properties ctx) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.getEntireContext - require Context");
		} else {
			Iterator keyIterator = ctx.keySet().iterator();
			String[] sList = new String[ctx.size()];

			Object key;
			for(int var3 = 0; keyIterator.hasNext(); sList[var3++] = key.toString() + " == " + ctx.get(key).toString()) {
				key = keyIterator.next();
			}

			return sList;
		}
	}

	public static String getHeader(Properties ctx, int WindowNo) {
		StringBuffer sb = new StringBuffer();
		if (WindowNo > 0) {
			sb.append(getContext(ctx, WindowNo, "WindowName", false)).append("  ");
		}

		//sb.append(getContext(ctx, "#AD_User_Name")).append("@").append(getContext(ctx, "#AD_Client_Name")).append(".").append(getContext(ctx, "#AD_Org_Name")).append(" [").append(CConnection.get().toString()).append("]");
		return sb.toString();
	}

	public static void clearWinContext(Properties ctx, int WindowNo) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.clearWinContext - require Context");
		} else {
			Object[] keys = ctx.keySet().toArray();

			for(int i = 0; i < keys.length; ++i) {
				String tag = keys[i].toString();
				if (tag.startsWith(WindowNo + "|")) {
					ctx.remove(keys[i]);
				}
			}

			MLookupCache.cacheReset(WindowNo);
			//removeWindow(WindowNo);
		}
	}

	public static void clearContext(Properties ctx) {
		if (ctx == null) {
			throw new IllegalArgumentException("Env.clearContext - require Context");
		} else {
			ctx.clear();
		}
	}

	public static String parseContext(Properties ctx, int WindowNo, String value, boolean onlyWindow, boolean ignoreUnparsable) {
		if (value == null) {
			return "";
		} else {
			String inStr = new String(value);
			StringBuffer outStr = new StringBuffer();

			for(int i = inStr.indexOf("@"); i != -1; i = inStr.indexOf("@")) {
				outStr.append(inStr.substring(0, i));
				inStr = inStr.substring(i + 1, inStr.length());
				int j = inStr.indexOf("@");
				if (j < 0) {
					logger.error("Env.parseContext - no second tag: " + inStr);
					return "";
				}

				String token = inStr.substring(0, j);
				String ctxInfo = getContext(ctx, WindowNo, token, onlyWindow);
				if (ctxInfo.length() == 0 && (token.startsWith("#") || token.startsWith("$"))) {
					ctxInfo = getContext(ctx, token);
				}

				if (ctxInfo.length() == 0) {
					logger.trace("Env.parseContext - no context (" + WindowNo + ") for: " + token);
					if (!ignoreUnparsable) {
						return "";
					}
				} else {
					outStr.append(ctxInfo);
				}

				inStr = inStr.substring(j + 1, inStr.length());
			}

			outStr.append(inStr);
			return outStr.toString();
		}
	}

	public static String parseContext(Properties ctx, int WindowNo, String value, boolean onlyWindow) {
		return parseContext(ctx, WindowNo, value, onlyWindow, false);
	}

//	public static int createWindowNo(Container win) {
//		int retValue = s_windows.size();
//		s_windows.add(win);
//		return retValue;
//	}
//
//	public static int getWindowNo(Container container) {
//		if (container == null) {
//			return 0;
//		} else {
//			JFrame winFrame = getFrame(container);
//			if (winFrame == null) {
//				return 0;
//			} else {
//				for(int i = 0; i < s_windows.size(); ++i) {
//					Container cmp = (Container)s_windows.get(i);
//					if (cmp != null) {
//						JFrame cmpFrame = getFrame(cmp);
//						if (winFrame.equals(cmpFrame)) {
//							return i;
//						}
//					}
//				}
//
//				return 0;
//			}
//		}
//	}
//
//	public static JFrame getWindow(int WindowNo) {
//		JFrame retValue = null;
//
//		try {
//			retValue = getFrame((Container)s_windows.get(WindowNo));
//		} catch (Exception var3) {
//			System.err.println("Env.getWindow - " + var3);
//		}
//
//		return retValue;
//	}
//
//	private static void removeWindow(int WindowNo) {
//		if (WindowNo <= s_windows.size()) {
//			s_windows.set(WindowNo, (Object)null);
//		}
//
//	}
//
//	public static void clearWinContext(int WindowNo) {
//		clearWinContext(s_ctx, WindowNo);
//	}
//
//	public static void clearContext() {
//		s_ctx.clear();
//	}
//
//	public static JFrame getFrame(Container container) {
//		for(Container element = container; element != null; element = element.getParent()) {
//			if (element instanceof JFrame) {
//				return (JFrame)element;
//			}
//		}
//
//		return null;
//	}
//
//	public static Graphics getGraphics(Container container) {
//		for(Container element = container; element != null; element = element.getParent()) {
//			Graphics g = element.getGraphics();
//			if (g != null) {
//				return g;
//			}
//		}
//
//		return null;
//	}
//
//	public static Window getParent(Container container) {
//		for(Container element = container; element != null; element = element.getParent()) {
//			if (element instanceof JDialog || element instanceof JFrame) {
//				return (Window)element;
//			}
//		}
//
//		return null;
//	}
//
//	public static Image getImage(String fileNameInImageDir) {
//		URL url = (class$org$compiere$Compiere == null ? (class$org$compiere$Compiere = class$("org.compiere.Compiere")) : class$org$compiere$Compiere).getResource("images/" + fileNameInImageDir);
//		if (url == null) {
//			return null;
//		} else {
//			Toolkit tk = Toolkit.getDefaultToolkit();
//			return tk.getImage(url);
//		}
//	}
//
//	public static ImageIcon getImageIcon(String fileNameInImageDir) {
//		URL url = (class$org$compiere$Compiere == null ? (class$org$compiere$Compiere = class$("org.compiere.Compiere")) : class$org$compiere$Compiere).getResource("images/" + fileNameInImageDir);
//		return url == null ? null : new ImageIcon(url);
//	}

	public static void startBrowser(String url) {
		logger.trace("Env.startBrowser", url);
		String cmd = "explorer ";
		if (!System.getProperty("os.name").startsWith("Win")) {
			cmd = "netscape ";
		}

		String execute = cmd + url;

		try {
			Runtime.getRuntime().exec(execute);
		} catch (Exception var4) {
			System.err.println("Env.startBrowser - " + execute + " - " + var4);
		}

	}

//	static {
//		s_ctx.put("#AD_Language", Language.getBaseAD_Language());
//	}
}
