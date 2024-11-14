package com.wizwolf.client.apps;

import java.awt.*;

public class AKeyboardFocusManager extends DefaultKeyboardFocusManager {
    private static AKeyboardFocusManager s_kfm = new AKeyboardFocusManager();
    public static AKeyboardFocusManager get() {
        if (s_kfm == null) {
            s_kfm = new AKeyboardFocusManager();
        }
        return s_kfm;
    }

    public AKeyboardFocusManager() {
        super ();
        setDefaultFocusTraversalPolicy(AFocusTraversalPolicy.get());
    }

}
