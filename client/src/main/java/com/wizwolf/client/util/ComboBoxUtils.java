package com.wizwolf.client.util;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ComboBoxUtils {

    /**
     * 通用方法：将 JComboBox 绑定到对象列表
     * @param comboBox JComboBox 实例
     * @param data 数据列表
     * @param displayProperty 显示的属性名称（例如："name"）
     * @param <T> 泛型类型
     * @example
     * <pre>
     * List<Person> persons = Arrays.asList(
     *     new Person("John", 30),
     *     new Person("Alice", 25),
     *     new Person("Bob", 40)
     * );
     * JComboBox<Person> comboBox = new JComboBox<>();
     * ComboBoxUtils.bindComboBox(comboBox, persons, "name");
     * </pre>
     */
    public static <T> void bindComboBox(JComboBox<T> comboBox, List<T> data, String displayProperty) {
        // 创建一个 DefaultComboBoxModel 并设置数据源
        DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>();
        for (T item : data) {
            model.addElement(item);
        }
        comboBox.setModel(model);

        // 设置渲染器
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    // 反射获取对象的指定属性（displayProperty）
                    try {
                        String propertyValue = value.getClass().getMethod("get" + capitalize(displayProperty)).invoke(value).toString();
                        setText(propertyValue);
                    } catch (Exception e) {
                        setText(value.toString()); // 默认处理
                    }
                }
                return c;
            }
        });
    }

    /**
     * 字符串首字母大写
     * @param str 输入字符串
     * @return 首字母大写的字符串
     */
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
