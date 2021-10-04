package Patterns;

public class LoginBuilder {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private LoginBuilder loginBuilder;

        public Builder() {
            loginBuilder = new LoginBuilder();
        }

        public Builder withUsername(String username) {
            loginBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            loginBuilder.password = password;
            return this;
        }

        public LoginBuilder build() {
            return loginBuilder;
        }
    }

    @Override
    public String toString() {
        return "LoginBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
