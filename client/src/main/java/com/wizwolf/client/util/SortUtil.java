package com.wizwolf.client.util;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * SortUtil 是一个用于提供通用排序功能的工具类。它包含了多种排序方法，可以根据对象的属性或字段进行排序。
 */
public class SortUtil {

    /**
     * 根据提供的属性提取函数返回一个可用于排序的 Comparator。
     * 支持所有常见类型（如 int, long, double, String, Comparable 类型等）
     *
     * @param <T> 被排序对象的类型
     * @param keyExtractor 用于提取排序键的函数
     * @param isDescending 是否降序排序，true 为降序，false 为升序
     * @return 返回一个 Comparator，用于对对象进行排序
     * @example
     *        Person person1 = new Person("Alice", 30, 5000.5);
     *         Person person2 = new Person("Bob", 25, 6000.0);
     *         Person person3 = new Person("Charlie", 35, 4500.75);
     *
     *         List<Person> people = new ArrayList<>();
     *         people.add(person1);
     *         people.add(person2);
     *         people.add(person3);
     *
     *         // 按年龄升序排序
     *         people.sort(SortUtil.getComparator(Person::getAge, false));
     *         System.out.println("按年龄升序排序:");
     *         people.forEach(System.out::println);
     *
     *         // 按工资降序排序
     *         people.sort(SortUtil.getComparator(Person::getSalary, true));
     *         System.out.println("按工资降序排序:");
     *         people.forEach(System.out::println);
     *
     *         // 使用反射根据名字排序
     *         people.sort(SortUtil.getComparatorByField("name", false));
     *         System.out.println("按名字升序排序:");
     *         people.forEach(System.out::println);
     */
    public static <T, U> Comparator<T> getComparator(Function<T, U> keyExtractor, boolean isDescending) {
        Comparator<T> comparator;

        // 判断提取的属性类型并选择适当的 Comparator
        if (keyExtractor.apply((T) new Object()) instanceof Integer) {
            comparator = Comparator.comparingInt((ToIntFunction<T>) keyExtractor);
        } else if (keyExtractor.apply((T) new Object()) instanceof Long) {
            comparator = Comparator.comparingLong((ToLongFunction<T>) keyExtractor);
        } else if (keyExtractor.apply((T) new Object()) instanceof Double) {
            comparator = Comparator.comparingDouble((ToDoubleFunction<T>) keyExtractor);
        } else if (keyExtractor.apply((T) new Object()) instanceof String) {
            comparator = Comparator.comparing((Function<T, String>) keyExtractor);
        } else if (keyExtractor.apply((T) new Object()) instanceof Comparable) {
            comparator = Comparator.comparing((Function<T, Comparable>) keyExtractor);
        } else {
            throw new IllegalArgumentException("Unsupported type for sorting");
        }

        if (isDescending) {
            comparator = comparator.reversed();
        }

        return comparator;
    }

    /**
     * 根据对象的字段名称进行排序。
     *
     * @param <T> 被排序对象的类型
     * @param fieldName 排序的字段名称
     * @param isDescending 是否降序排序，true 为降序，false 为升序
     * @return 返回一个 Comparator，用于对对象按指定字段进行排序
     */
    public static <T> Comparator<T> getComparatorByField(String fieldName, boolean isDescending) {
        return (o1, o2) -> {
            try {
                // 获取字段对象
                Field field = o1.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                // 获取字段的值
                Object value1 = field.get(o1);
                Object value2 = field.get(o2);

                // 确保字段值是 Comparable 类型的
                Comparable<Object> comparableValue1 = (Comparable<Object>) value1;
                Comparable<Object> comparableValue2 = (Comparable<Object>) value2;

                // 比较两个字段值
                int comparison = comparableValue1.compareTo(comparableValue2);

                // 根据是否降序调整比较结果
                return isDescending ? -comparison : comparison;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error accessing field for comparison", e);
            }
        };
    }

    /**
     * 示例程序，演示如何使用 SortUtil 类对 Person 对象进行排序。
     */
    public static void main(String[] args) {

    }
}
