package data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String login;
    private String password;
    private String code;

    public User(String login, String password, String code) {
        this.login = login;
        this.password = password;
        this.code = code;
    }
}
