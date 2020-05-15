package ikvych.resume.convertor;

import ikvych.resume.model.LanguageLevel;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class LanguageLevelAttributeConverter implements AttributeConverter<LanguageLevel, String> {

    @Override
    public String convertToDatabaseColumn(LanguageLevel attribute) {
        return attribute.getDbValue();
    }
    @Override
    public LanguageLevel convertToEntityAttribute(String dbValue) {
        return LanguageLevel.valueOf(dbValue.toUpperCase());
    }
}
