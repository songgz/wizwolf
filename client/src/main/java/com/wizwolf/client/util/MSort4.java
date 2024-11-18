package com.wizwolf.client.util;

import java.util.Comparator;

/**
 * <h1>MSort 类</h1>
 * <p>
 * MSort 是一个泛型类，用于对对象集合进行排序。它支持自定义排序规则，并且可以设置升序或降序的排序顺序。
 * 该类通过接收一个 Comparator 和一个布尔值来控制排序行为。Comparator 用于定义排序规则，
 * 布尔值则决定是升序排序还是降序排序。
 * </p>
 *
 * <h2>构造方法：</h2>
 * <ul>
 *   <li><b>MSort(Comparator<? super T> comparator, boolean ascending)</b>：构造一个 MSort 实例，
 *   通过传入的比较器来定义排序规则，升序或降序由布尔值决定。</li>
 * </ul>
 *
 * <h2>方法：</h2>
 * <ul>
 *   <li><b>getComparator()</b>：返回适用于当前排序顺序的 Comparator。根据升序或降序的设置，返回
 *   相应的比较器。</li>
 * </ul>
 *
 * <h2>示例：</h2>
 * <pre>
 *   List&lt;String&gt; list = Arrays.asList("banana", "apple", "pear", "orange");
 *
 *   // 升序排序
 *   MSort&lt;String&gt; sorter = new MSort&lt;&gt;(Comparator.naturalOrder(), true);
 *   list.sort(sorter.getComparator());
 *   System.out.println("Sorted in ascending order: " + list);
 *
 *   // 降序排序
 *   MSort&lt;String&gt; reverseSorter = new MSort&lt;&gt;(Comparator.naturalOrder(), false);
 *   list.sort(reverseSorter.getComparator());
 *   System.out.println("Sorted in descending order: " + list);
 * </pre>
 *
 * <h2>类结构：</h2>
 * <pre>
 *   MSort&lt;T&gt;
 *   ├── comparator (Comparator&lt;? super T&gt;)
 *   └── ascending (boolean)
 * </pre>
 *
 * @param <T> 泛型类型，表示需要排序的对象类型
 */
public class MSort4<T> {
    private Comparator<? super T> comparator;
    private boolean ascending;

    public MSort4(Comparator<? super T> comparator, boolean ascending) {
        this.comparator = comparator;
        this.ascending = ascending;
    }

    public Comparator<? super T> getComparator() {
        return ascending ? comparator : comparator.reversed();
    }
}