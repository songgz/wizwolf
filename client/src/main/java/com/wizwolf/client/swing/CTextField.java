/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package com.wizwolf.client.swing;

//import org.adempiere.exceptions.ValueChangeListener;
//import org.adempiere.plaf.AdempierePLAF;
//import org.compiere.model.GridField;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;

public class CTextField extends JTextField implements CInput, KeyListener {
	private static final long serialVersionUID = 460529728891168659L;
	private boolean m_required = false;
	private Object m_oldValue;

	public CTextField()	{
		super();
		init();
	}

	public CTextField(String text)	{
		super(text);
		init();
	}

	public CTextField(int columns) {
		super(columns);
		init();
	}

	public CTextField(String text, int columns)	{
		super(text, columns);
		init();
	}

	public CTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		init();
	}

	private void init()	{
		//setBackground(false);
		setOldValue();
	}

	public void setRequired(boolean required) {
		m_required = required;
		//setBackground(false);
	}

	@Override
	public boolean isRequired()	{
		return m_required;
	}

	public void setWritable(boolean rw)	{
		if (super.isEditable() != rw)
			super.setEditable (rw);
		//setBackground(false);
	}

	public boolean isWritable()	{
		return super.isEditable();
	}

	public void setBackground(boolean error) {
//		if (error)
//			setBackground(AdempierePLAF.getFieldBackground_Error());
//		else if (!isReadWrite())
//			setBackground(AdempierePLAF.getFieldBackground_Inactive());
//		else if (m_mandatory)
//			setBackground(AdempierePLAF.getFieldBackground_Mandatory());
//		else
//			setBackground(AdempierePLAF.getFieldBackground_Normal());
	}   //  setBackground

	/**
	 *  Set Background
	 *  @param bg background
	 */
	public void setBackground(Color bg)
	{
		if (bg.equals(getBackground()))
			return;
		super.setBackground(bg);
	}   //  setBackground

	/**
	 *	Set Editor to value
	 *  @param value value of the editor
	 */
	public void setValue(Object value) {
		if (value == null) {
			setText("");
		}else {
			setText(value.toString());
		}
	}

	/**
	 *	Return Editor value
	 *  @return current value
	 */
	public Object getValue() {
		return getText();
	}

	/**
	 *  Return Display Value
	 *  @return displayed String value
	 */
	public String getDisplay() {
		return getText();
	}


	/**
	 * 	key Pressed
	 *	@see KeyListener#keyPressed(KeyEvent)
	 *	@param e
	 */
	public void keyPressed(KeyEvent e)
	{
	}	//	keyPressed

	/**
	 * 	key Released
	 *	@see KeyListener#keyReleased(KeyEvent)
	 *	@param e
	 */
	public void keyReleased(KeyEvent e)
	{
	}	//	keyReleased

	/**
	 * 	key Typed
	 *	@see KeyListener#keyTyped(KeyEvent)
	 *	@param e
	 */
	public void keyTyped(KeyEvent e)
	{
	}	//	keyTyped

	/**
	 * Set the old value of the field.  For use in future comparisons.
	 * The old value must be explicitly set though this call.
	 * @param m_oldValue
	 */
	public void setOldValue() {
		this.m_oldValue = getValue();
	}

	/**
	 * Get the old value of the field explicitly set in the past
	 * @return
	 */
	public Object getOldValue() {
		return m_oldValue;
	}
	/**
	 * Has the field changed over time?
	 * @return true if the old value is different than the current.
	 */
	public boolean hasChanged() {
		// Both or either could be null
		if(getValue() != null)
			if(m_oldValue != null)
				return !m_oldValue.equals(getValue());
			else
				return true;
		else  // getValue() is null
			if(m_oldValue != null)
				return true;
			else
				return false;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void addValueChangeListener(ValueChangeListener listener) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public GridField getField() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}   //  CTextField
