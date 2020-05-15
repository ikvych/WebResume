package ikvych.resume.form;

import ikvych.resume.annotation.constraints.EnglishLanguage;
import ikvych.resume.annotation.constraints.FieldMatch;
import ikvych.resume.annotation.constraints.PasswordStrength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "passwordConfirm", message = "Паролі повинні співпадати")
public class SignUpForm {
    @NotNull
    @NotBlank
    @Size(max = 60)
    @EnglishLanguage(withSpechSymbols = false, withPunctuations = false, withNumbers = false)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(max = 60)
    @EnglishLanguage(withSpechSymbols = false, withPunctuations = false, withNumbers = false)
    private String lastName;
    @PasswordStrength(message = "Недостатньо надійний пароль")
    private String password;
    private String passwordConfirm;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
