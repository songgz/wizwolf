package com.wizwolf.client.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DialogAction extends AbstractAction {
    protected static String	ACTION_DISPOSE = "CDialogDispose";

    DialogAction (String actionName) {
        super(actionName);
        this.putValue(AbstractAction.ACTION_COMMAND_KEY, actionName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ACTION_DISPOSE.equals(e.getActionCommand()))
        {
            Object source = e.getSource();
            while (source != null)
            {
                if (source instanceof Window)
                {
                    ((Window)source).dispose();
                    return;
                }
                if (source instanceof Container)
                    source = ((Container)source).getParent();
                else
                    source = null;
            }
        }else{
            System.out.println("Action: " + e);
        }
    }
}
