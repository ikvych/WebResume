package ikvych.resume.model;

import java.beans.PropertyEditorSupport;

public enum LanguageType {
    ALL,
    WRITING,
    SPOKEN;

    public String getDbValue() {
        return name().toLowerCase();
    }

    public LanguageType getReversType() {
        if (this == SPOKEN) {
            return WRITING;
        } else if (this == WRITING){
            return SPOKEN;
        } else {
            throw new IllegalArgumentException(this + " does not have reverse type");
        }
    }

    public String getCaption() {
        return name();
    }

    public static PropertyEditorSupport getPropertyEditor(){
        return new PropertyEditorSupport(){
            @Override
            public void setAsText(String dbValue) throws IllegalArgumentException {
                setValue(LanguageType.valueOf(dbValue.toUpperCase()));
            }
        };
    }
}
