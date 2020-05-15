package ikvych.resume.convertor;

import ikvych.resume.model.LanguageType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LanguageTypeAttributeConverter implements AttributeConverter<LanguageType, String> {

    @Override
    public String convertToDatabaseColumn(LanguageType attribute) {
        return attribute.getDbValue();
    }
    @Override
    public LanguageType convertToEntityAttribute(String dbValue) {
        return LanguageType.valueOf(dbValue.toUpperCase());
    }
}