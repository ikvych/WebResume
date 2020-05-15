package ikvych.resume.model;

import org.apache.commons.lang3.text.WordUtils;

import java.beans.PropertyEditorSupport;

public enum LanguageLevel {
    BEGINNER,
    ELEMENTARY,
    PRE_INTERMEDIATE,
    INTERMEDIATE,
    UPPER_INTERMEDIATE,
    ADVANCED,
    PROFICIENCY;

    public int getSliderIntValue(){
        return ordinal();
    }

    public String getDbValue() {
        return name().toLowerCase();
    }

    public String getCaption(){
        return WordUtils.capitalize(name().trim().toLowerCase()).replace("_", "-");
    }

    public static PropertyEditorSupport getPropertyEditor(){
        return new PropertyEditorSupport(){
            @Override
            public void setAsText(String sliderIntValue) throws IllegalArgumentException {
                setValue(LanguageLevel.values()[Integer.parseInt(sliderIntValue)]);
            }
        };
    }
}
