package com.wizwolf.client.util;

import java.util.Comparator;

public class MSort<T> {
    private Comparator<? super T> comparator;
    private boolean ascending;

    public MSort(Comparator<? super T> comparator, boolean ascending) {
        this.comparator = comparator;
        this.ascending = ascending;
    }

    public Comparator<? super T> getComparator() {
        return ascending ? comparator : comparator.reversed();
    }
}