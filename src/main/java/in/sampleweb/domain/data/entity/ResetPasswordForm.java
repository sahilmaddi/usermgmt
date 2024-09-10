package in.sampleweb.domain.data.entity;

import lombok.Data;

@Data
public class ResetPasswordForm {

    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    // Default constructor
    public ResetPasswordForm() {
    }

    // Constructor with all fields
    public ResetPasswordForm(String email, String oldPassword, String newPassword, String confirmPassword) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Optional: You can also add validation methods if needed
    public boolean isNewPasswordMatching() {
        return this.newPassword.equals(this.confirmPassword);
    }
}
