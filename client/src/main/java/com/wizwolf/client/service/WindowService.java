package com.wizwolf.client.service;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Service
public class WindowService {
    //private static WindowService instance = null;
    private ArrayList windows;

    private WindowService() {
        this.windows = new ArrayList(20);
    }

//    public static WindowManager getInstance() {
//        if (instance == null) {
//            instance = new WindowManager();
//        }
//        return instance;
//    }


    public int createWindowNo(Container win) {
        int retValue = windows.size();
        windows.add(win);
        return retValue;
    }

    public int getWindowNo(Container container) {
        if (container == null) {
            return 0;
        } else {
            JFrame winFrame = getFrame(container);
            if (winFrame == null) {
                return 0;
            } else {
                for(int i = 0; i < windows.size(); ++i) {
                    Container cmp = (Container) windows.get(i);
                    if (cmp != null) {
                        JFrame cmpFrame = getFrame(cmp);
                        if (winFrame.equals(cmpFrame)) {
                            return i;
                        }
                    }
                }

                return 0;
            }
        }
    }

    public JFrame getWindow(int WindowNo) {
        JFrame retValue = null;

        try {
            retValue = getFrame((Container) windows.get(WindowNo));
        } catch (Exception var3) {
            System.err.println("Env.getWindow - " + var3);
        }

        return retValue;
    }

    private void removeWindow(int WindowNo) {
        if (WindowNo <= windows.size()) {
            windows.set(WindowNo, (Object)null);
        }

    }

//    public static void clearWinContext(int WindowNo) {
//        clearWinContext(s_ctx, WindowNo);
//    }

//    public static void clearContext() {
//        s_ctx.clear();
//    }

    public JFrame getFrame(Container container) {
        for(Container element = container; element != null; element = element.getParent()) {
            if (element instanceof JFrame) {
                return (JFrame)element;
            }
        }

        return null;
    }

    public Graphics getGraphics(Container container) {
        for(Container element = container; element != null; element = element.getParent()) {
            Graphics g = element.getGraphics();
            if (g != null) {
                return g;
            }
        }

        return null;
    }

    public Window getParent(Container container) {
        for(Container element = container; element != null; element = element.getParent()) {
            if (element instanceof JDialog || element instanceof JFrame) {
                return (Window)element;
            }
        }

        return null;
    }

//    public Image getImage(String fileNameInImageDir) {
//        URL url = (class$org$compiere$Compiere == null ? (class$org$compiere$Compiere = class$("org.compiere.Compiere")) : class$org$compiere$Compiere).getResource("images/" + fileNameInImageDir);
//        if (url == null) {
//            return null;
//        } else {
//            Toolkit tk = Toolkit.getDefaultToolkit();
//            return tk.getImage(url);
//        }
//    }

//    public ImageIcon getImageIcon(String fileNameInImageDir) {
//        URL url = (class$org$compiere$Compiere == null ? (class$org$compiere$Compiere = class$("org.compiere.Compiere")) : class$org$compiere$Compiere).getResource("images/" + fileNameInImageDir);
//        return url == null ? null : new ImageIcon(url);
//    }
}
