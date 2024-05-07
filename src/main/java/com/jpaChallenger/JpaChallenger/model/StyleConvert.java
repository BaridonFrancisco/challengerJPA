package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class StyleConvert implements AttributeConverter<Style,String> {
    @Override
    public String convertToDatabaseColumn(Style style) {
        if(style==null) return null;
        return style.getStyle();
    }

    @Override
    public Style convertToEntityAttribute(String s) {
        if(s.isEmpty() || s.equals(" ")) return null;
        return Style.fromStyle(s);
    }
}
