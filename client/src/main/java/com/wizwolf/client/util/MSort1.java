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
package com.wizwolf.client.util;

import com.wizwolf.util.NamePair;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;

public final class MSort1 implements Comparator, Serializable {
	public int index;
	public Object data;
	private int m_multiplier = 1;

	public MSort1(int new_index, Object new_data) {
		this.index = new_index;
		this.data = new_data;
	}

	public void setSortAsc(boolean ascending) {
		if (ascending) {
			this.m_multiplier = 1;
		} else {
			this.m_multiplier = -1;
		}

	}

	public int compare(Object o1, Object o2) {
		Object cmp1 = null;
		if (o1 instanceof MSort1) {
			cmp1 = ((MSort1)o1).data;
		}

		if (cmp1 instanceof NamePair) {
			cmp1 = ((NamePair)cmp1).getName();
		}

		Object cmp2 = o2;
		if (o2 instanceof MSort1) {
			cmp2 = ((MSort1)o2).data;
		}

		if (cmp2 instanceof NamePair) {
			cmp2 = ((NamePair)cmp2).getName();
		}

		if (cmp1 == null) {
			cmp1 = new String("");
		}

		if (cmp2 == null) {
			cmp2 = new String("");
		}

		if (cmp1 instanceof Timestamp) {
			Timestamp t = (Timestamp)cmp1;
			return t.compareTo((Timestamp) cmp2) * this.m_multiplier;
		} else if (cmp1 instanceof BigDecimal) {
			BigDecimal d = (BigDecimal)cmp1;
			return d.compareTo((BigDecimal) cmp2) * this.m_multiplier;
		} else if (cmp1 instanceof Integer) {
			Integer d = (Integer)cmp1;
			return d.compareTo((Integer) cmp2) * this.m_multiplier;
		} else {
			String s;
			if (cmp1 instanceof String) {
				s = (String)cmp1;
				return s.compareTo(cmp2.toString()) * this.m_multiplier;
			} else {
				s = cmp1.toString();
				return s.compareTo(cmp2.toString()) * this.m_multiplier;
			}
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof MSort1) {
			MSort1 ms = (MSort1)obj;
			if (this.data == ms.data) {
				return true;
			}
		}

		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("MSort[");
		sb.append("Index=").append(this.index).append(",Data=").append(this.data);
		sb.append("]");
		return sb.toString();
	}
}
