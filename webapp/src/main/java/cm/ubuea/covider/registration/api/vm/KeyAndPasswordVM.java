package cm.ubuea.covider.registration.api.vm;
/**
 * View Model object for storing the user's key and password.
 * login : root
 * pass : t00ri$$3cur3
 */
public class KeyAndPasswordVM {

    private String key;

    private String newPassword;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
