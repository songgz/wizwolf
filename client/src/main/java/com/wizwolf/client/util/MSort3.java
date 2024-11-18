package com.wizwolf.client.util;

import com.wizwolf.util.NamePair1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Comparator;

public final class MSort3 implements Comparator<MSort3>, Serializable {
    private static final long serialVersionUID = 1L;

    public int index;
    public Object data;
    private int m_multiplier = 1;

    public MSort3(int newIndex, Object newData) {
        this.index = newIndex;
        this.data = newData;
    }

    public void setSortAsc(boolean ascending) {
        this.m_multiplier = ascending ? 1 : -1;
    }

    @Override
    public int compare(MSort3 o1, MSort3 o2) {
        Object cmp1 = o1.data instanceof NamePair1 ? ((NamePair1) o1.data).getName() : o1.data;
        Object cmp2 = o2.data instanceof NamePair1 ? ((NamePair1) o2.data).getName() : o2.data;

        if (cmp1 == null) {
            cmp1 = "";
        }
        if (cmp2 == null) {
            cmp2 = "";
        }

        if (cmp1 instanceof Timestamp && cmp2 instanceof Timestamp) {
            return ((Timestamp) cmp1).compareTo((Timestamp) cmp2) * m_multiplier;
        } else if (cmp1 instanceof BigDecimal && cmp2 instanceof BigDecimal) {
            return ((BigDecimal) cmp1).compareTo((BigDecimal) cmp2) * m_multiplier;
        } else if (cmp1 instanceof Integer && cmp2 instanceof Integer) {
            return ((Integer) cmp1).compareTo((Integer) cmp2) * m_multiplier;
        } else {
            String str1 = cmp1.toString();
            String str2 = cmp2.toString();
            return str1.compareTo(str2) * m_multiplier;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MSort1)) return false;
        MSort1 ms = (MSort1) obj;
        return this.data == ms.data;
    }

    @Override
    public String toString() {
        return String.format("MSort[Index=%d, Data=%s]", this.index, this.data);
    }

    public static void main(String[] args) {
        MSort3 ms1 = new MSort3(1, "ss");
        MSort3 ms2 = new MSort3(2, "jj");

        ms1.setSortAsc(true);
        System.out.println("Comparison result: " + ms1.compare(ms1, ms2));
    }
}



