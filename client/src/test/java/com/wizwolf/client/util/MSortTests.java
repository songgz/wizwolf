package com.wizwolf.client.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class YourObject {
    private String name;
    private int age;

    public YourObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "YourObject{name='" + name + "', age=" + age + '}';
    }
}


public class MSortTests {
    @Test
    void contextLoads() {
    }

    @Test
    void sort3() {
        // 创建一些 YourObject 实例
        List<MSort1> list = new ArrayList<>();
        list.add(new MSort1(0,"Alice"));
        list.add(new MSort1(1, "Bob"));
        list.add(new MSort1(2,"Charlie"));

        // 输出原始列表
        System.out.println("Original List:");
        System.out.println(list);

        // 创建按年龄排序的 MSort 对象，采用比较器
        MSort1 ageSort = new MSort1(0, null);
        ageSort.setSortAsc(false);
        Collections.sort(list, ageSort);

        // 输出按年龄排序后的列表
        System.out.println("Sorted by Age (Ascending):");
        System.out.println(list);

        // 创建按名字排序的 MSort 对象
        MSort1 nameSort = new MSort1(1, null);
        nameSort.setSortAsc(false);
        Collections.sort(list, nameSort);

        // 输出按名字排序后的列表
        System.out.println("Sorted by Name (Ascending):");
        System.out.println(list);
    }

    @Test
    void sort() {
        // 创建一些 YourObject 实例
        List<YourObject> list = new ArrayList<>();
        list.add(new YourObject("Alice", 30));
        list.add(new YourObject("Bob", 25));
        list.add(new YourObject("Charlie", 35));

        // 输出原始列表
        System.out.println("Original List:");
        System.out.println(list);

        // 创建按年龄排序的 MSort 对象，采用比较器
        MSort<YourObject> ageSort = new MSort<>(Comparator.comparingInt(YourObject::getAge), true);
        Collections.sort(list, ageSort.getComparator());

        // 输出按年龄排序后的列表
        System.out.println("Sorted by Age (Ascending):");
        System.out.println(list);

        // 创建按名字排序的 MSort 对象
        MSort<YourObject> nameSort = new MSort<>(Comparator.comparing(YourObject::getName), true);
        Collections.sort(list, nameSort.getComparator());

        // 输出按名字排序后的列表
        System.out.println("Sorted by Name (Ascending):");
        System.out.println(list);

    }
}
