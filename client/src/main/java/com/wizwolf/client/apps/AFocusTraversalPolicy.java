package com.wizwolf.client.apps;

import javax.swing.*;
import java.awt.*;

public class AFocusTraversalPolicy extends LayoutFocusTraversalPolicy {
    private static AFocusTraversalPolicy s_policy = new AFocusTraversalPolicy();

    boolean m_default = false;

    public AFocusTraversalPolicy()
    {
        super();
    }

    public static AFocusTraversalPolicy get() {
        if (s_policy == null)
            s_policy = new AFocusTraversalPolicy();
        return s_policy;
    }

    public Component getDefaultComponent(Container aContainer) {
        m_default = true;
        Component c = super.getDefaultComponent(aContainer);
        m_default = false;
        return c;
    }

    protected boolean accept(Component aComponent)
    {
        if (!super.accept(aComponent))
            return false;

        //  TabbedPane
        if (aComponent instanceof JTabbedPane)
            return false;
        //  R/O Editors
//        if (aComponent instanceof CEditor)
//        {
//            CEditor ed = (CEditor)aComponent;
//            if (!ed.isReadWrite())
//                return false;
//            if (m_default	//	get Default Focus
//                    && ("AD_Client_ID".equals(aComponent.getName()) || "AD_Org_ID".equals(aComponent.getName()) ))
//                return false;
//        }
        //  Toolbar Buttons
        if (aComponent.getParent() instanceof JToolBar)
            return false;
        //
        return true;
    }
}
