package by.grsu.domain;

public class UserCredential {

    private String login;

    private String password;

    private boolean isRegisteredUser;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRegisteredUser() {
        return isRegisteredUser;
    }

    public void setIsRegisteredUser(boolean isRegisteredUser) {
        this.isRegisteredUser = isRegisteredUser;
    }
}
