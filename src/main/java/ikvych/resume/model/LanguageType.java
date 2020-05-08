package ikvych.resume.model;

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
}
