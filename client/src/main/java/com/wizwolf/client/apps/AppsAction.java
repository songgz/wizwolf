package com.wizwolf.client.apps;

import com.wizwolf.client.swing.CButton;
import com.wizwolf.client.swing.CCheckBoxMenuItem;
import com.wizwolf.client.swing.CMenuItem;
import com.wizwolf.client.swing.CToggleButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class AppsAction extends AbstractAction
{
    /**
     *
     */
    private static final long serialVersionUID = 8522301377339185496L;

    /**
     *  Application Action
     *
     *  @param   action base action command - used as AD_Message for Text and Icon name
     *  @param   accelerator optional keystroke for accelerator
     *  @param   toggle is toggle action (maintains state)
     */
    public AppsAction (String action, KeyStroke accelerator, boolean toggle)
    {
        this (action, accelerator, null, toggle);
    }
    /**
     *  Application Action
     *
     *  @param   action base action command - used as AD_Message for Text and Icon name
     *  @param   accelerator optional keystroke for accelerator
     *  @param   text text, if null defered from action
     */
    public AppsAction (String action, KeyStroke accelerator, String text)
    {
        this (action, accelerator, text, false);
    }	//	AppsAction

    /**
     *  Application Action
     *
     *  @param   action base action command - used as AD_Message for Text and Icon name
     *  @param   accelerator optional keystroke for accelerator
     *  @param   toolTipText text, if null defered from action
     *  @param   toggle is toggle action (maintains state)
     */
    public AppsAction (String action, KeyStroke accelerator, String toolTipText, boolean toggle)
    {
        super();
        m_action = action;
        m_accelerator = accelerator;
        m_toggle = toggle;

        //	Data
//        if (toolTipText == null)
//            toolTipText = Msg.getMsg(Env.getCtx(), action);
        int pos = toolTipText.indexOf('&');
        if (pos != -1  && toolTipText.length() > pos)	//	We have a nemonic - creates ALT-_
        {
            Character ch = new Character(toolTipText.toUpperCase().charAt(pos+1));
            if (ch != ' ')
            {
                toolTipText = toolTipText.substring(0, pos) + toolTipText.substring(pos+1);
                putValue(Action.MNEMONIC_KEY, Integer.valueOf(ch.hashCode()));
            }
        }
        //
        Icon small = getIcon(action, true);
        Icon large = getIcon(action, false);
        Icon largePressed = null;

        //  ToggleIcons have the pressed name with X
        if (m_toggle)
        {
            m_smallPressed = getIcon(action+"X", true);
            if (m_smallPressed == null)
                m_smallPressed = small;
            largePressed = getIcon(action+"X", false);
            if (largePressed == null)
                largePressed = large;
        }

        //	Attributes
        putValue(Action.NAME, toolTipText);					//	Display
        putValue(Action.SMALL_ICON, small);                 //  Icon
        putValue(Action.SHORT_DESCRIPTION, toolTipText);	//	Tooltip
        putValue(Action.ACTION_COMMAND_KEY, m_action);      //  ActionCammand
        putValue(Action.ACCELERATOR_KEY, accelerator);      //  KeyStroke
        //	putValue(Action.MNEMONIC_KEY, Integer.valueOf(0));      //  Mnemonic
        //	putValue(Action.DEFAULT, text);						//	Not Used

        //	Create Button
        if (toggle)
        {
            m_button = new CToggleButton(this);
            m_button.setSelectedIcon(largePressed);
        }
        else
            m_button = new CButton(this);
        m_button.setName(action);
        //	Correcting Action items
        if (large != null)
        {
            m_button.setIcon(large);
            m_button.setText(null);
        }
        m_button.setActionCommand(m_action);
        m_button.setMargin(BUTTON_INSETS);
        m_button.setSize(BUTTON_SIZE);
        //
        if (accelerator != null)
        {
            m_button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(accelerator, action);
            m_button.getActionMap().put(action, this);
        }
    }	//	Action

    /** Button Size     			*/
    public static final Dimension BUTTON_SIZE = new Dimension(28,28);
    /** Button Insets   			*/
    public static final Insets		BUTTON_INSETS = new Insets(0, 0, 0, 0);
    /** CButton or CToggelButton	*/
    private AbstractButton 	m_button;
    /**	Menu						*/
    private JMenuItem		m_menu;

    private String			m_action = null;
    private KeyStroke		m_accelerator = null;
    private Icon 			m_smallPressed = null;
    private ActionListener m_delegate = null;
    private boolean 		m_toggle = false;
    private boolean			m_pressed = false;

    /**
     *	Get Icon with name action
     *  @param name name
     *  @param small small
     *  @return Icon
     */
    private ImageIcon getIcon(String name, boolean small)
    {
        String fullName = name + (small ? "16" : "24");
        return null; //Env.getImageIcon2(fullName);
    }	//	getIcon

    /**
     *	Get Name/ActionCommand
     *  @return ActionName
     */
    public String getName()
    {
        return m_action;
    }	//	getName

    /**
     *	Return Button
     *  @return Button
     */
    public AbstractButton getButton()
    {
        return m_button;
    }	//	getButton

    /**
     *	Return MenuItem
     *  @return MenuItem
     */
    public JMenuItem getMenuItem()
    {
        if (m_menu == null)
        {
            if (m_toggle)
            {
                m_menu = new CCheckBoxMenuItem(this);
                m_menu.setSelectedIcon(m_smallPressed);
            }
            else
                m_menu = new CMenuItem(this);
            m_menu.setAccelerator(m_accelerator);
            m_menu.setActionCommand(m_action);
        }
        return m_menu;
    }	//	getMenuItem

    /**
     *	Set Delegate to receive the actionPerformed calls
     *  @param al listener
     */
    public void setDelegate(ActionListener al)
    {
        m_delegate = al;
    }	//	setDelegate

    /**
     *	Toggle
     *  @param pressed pressed
     */
    public void setPressed (boolean pressed)
    {
        if (!m_toggle)
            return;
        m_pressed = pressed;

        //	Set Button
        if (m_button != null)
            m_button.setSelected(pressed);

        //	Set Menu
        if (m_menu != null)
            m_menu.setSelected(pressed);
    }	//	setPressed

    /**
     *	IsPressed
     *  @return true if pressed
     */
    public boolean isPressed()
    {
        return m_pressed;
    }	//	isPressed

    /**
     * 	Get Mnemonic character
     *	@return character
     */
    public Character getMnemonic()
    {
        Object oo = getValue(Action.MNEMONIC_KEY);
        if (oo instanceof Integer)
            return (char)((Integer)oo).intValue();
        return null;
    }	//	getMnemonic

    /**
     *	ActionListener
     *  @param e Event
     */
    public void actionPerformed(ActionEvent e)
    {
        //	log.info( "AppsAction.actionPerformed", e.getActionCommand());
        //	Toggle Items
        if (m_toggle)
            setPressed(!m_pressed);
        //	Inform
        if (m_delegate != null)
            m_delegate.actionPerformed(e);
    }

    /**
     *	Dispose
     */
    public void dispose()
    {
        m_button = null;
        m_menu = null;
    }	//	dispose

    /**
     *  String Info
     *  @return String Representation
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer("AppsAction[");
        sb.append(m_action);
        Object oo = getValue(Action.ACCELERATOR_KEY);
        if (oo != null)
            sb.append(",Accelerator=").append(oo);
        oo = getMnemonic();
        if (oo != null)
            sb.append(",MnemonicKey=").append(oo);
        sb.append("]");
        return sb.toString();
    }   //  toString

}
