package com.wizwolf.client.apps;

import com.wizwolf.client.Application;
import com.wizwolf.client.service.WindowService;
import com.wizwolf.client.swing.CFrame;
import com.wizwolf.client.util.Splash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.FocusManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Component
public final class AMenu extends CFrame implements ActionListener, PropertyChangeListener, ChangeListener {

    private int	m_WindowNo;
    //private Properties m_ctx = EnvSrv.getInstance().getCtx();
    private boolean	m_startingItem = false;
    private int m_AD_User_ID;
    private final WindowService win;

    @Autowired
    public AMenu(WindowService win) {
        super();
        this.win = win;
        //Splash splash = Splash.getInstance();
        m_WindowNo = this.win.createWindowNo(this);
        //initSystem (splash); //	login

    }

    private void initSystem (Splash splash) {
        this.setIconImage(Application.getInstance().getImage16());

        //  Focus Traversal
        FocusManager.getCurrentManager().setDefaultFocusTraversalPolicy(AFocusTraversalPolicy.get());
        KeyboardFocusManager.setCurrentKeyboardFocusManager(AKeyboardFocusManager.get());
        this.setFocusTraversalPolicy(AFocusTraversalPolicy.get());

        /**
         *	Show Login Screen - if not successful - exit
         */
        //ALogin login = new ALogin();
//        if (!login.initLogin())		//	no automatic login
//        {
//            //	Center the window
//            try
//            {
//                AEnv.showCenterScreen(login);	//	HTML load errors
//            }
//            catch (Exception ex)
//            {
//            }
//            if (!login.isConnected())
//                AEnv.exit(1);
//        }
//
//        //  Check DB	(AppsServer Version checked in Login)
//        boolean dbOK = DB.isDatabaseOK(m_ctx);
        //	if (!dbOK)
        //		AEnv.exit(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
