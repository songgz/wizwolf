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
//import org.compiere.model.GridField;

import java.beans.PropertyChangeListener;

/**
 *  Adempiere Editor interface
 *
 *  @author     Jorg Janke
 *  @version    $Id: CEditor.java,v 1.2 2006/07/30 00:52:24 jjanke Exp $
 */
public interface CInput extends PropertyChangeListener
{
	/**
	 *	Enable Editor
	 *  @param rw true, if you can enter/select data
	 */
	public void setWritable(boolean rw);

	/**
	 *	Is it possible to edit
	 *  @return true, if editable
	 */
	public boolean isWritable();

	/**
	 *	Set Editor Mandatory
	 *  @param mandatory true, if you have to enter data
	 */
	public void setRequired(boolean required);

	/**
	 *	Is Field mandatory
	 *  @return true, if mandatory
	 */
	public boolean isRequired();

	/**
	 *  Set Background based on editable / mandatory / error
	 *  @param error if true, set background to error color, otherwise mandatory/editable
	 */
	public void setBackground (boolean error);

	/**
	 *  Set Visible
	 *  @param visible true if field is to be shown
	 */
	public void setVisible (boolean visible);

	/**
	 *	Set Editor to value
	 *  @param value value of the editor
	 */
	public void setValue (Object value);

	/**
	 *	Return Editor value
	 *  @return current value
	 */
	public Object getValue();

	/**
	 *  Return Display Value
	 *  @return displayed String value
	 */
	public String getDisplay();

//	public void addVetoableChangeListener(VetoableChangeListener listener);
//
//	public void addValueChangeListener(ValueChangeListener listener);
//
//	public GridField getField();

}   //  CEditor
