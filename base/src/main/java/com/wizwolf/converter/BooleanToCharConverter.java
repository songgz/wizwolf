package com.wizwolf.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)  // autoApply = true 表示所有使用这个字段的地方都自动应用此转换器
public class BooleanToCharConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;  // 处理空值
        }
        return attribute ? 'Y' : 'T';  // true 映射为 'Y', false 映射为 'T'
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData == null) {
            return null;  // 处理空值
        }
        return dbData == 'Y';  // 'Y' 映射为 true, 'T' 映射为 false
    }
}
