package org.example.spring24.person.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.spring24.person.valueobject.SocialPlatform;

@Converter
public class SocialPlatformConverter implements AttributeConverter<SocialPlatform, String> {
    @Override
    public String convertToDatabaseColumn(SocialPlatform attribute) {
        return attribute.platformName();
    }

    @Override
    public SocialPlatform convertToEntityAttribute(String dbData) {
        return new SocialPlatform(dbData);
    }
}
