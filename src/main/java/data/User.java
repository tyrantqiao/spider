package data;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

/**
 * Created by GeoLin on 2017/5/21.
 */
public class User {
    private long id;

    @NotNull
    @Size(min=2,max=16)
    private String username;

    @NotNull
    @Size(min=2,max=16)
    private String password;

    @Email
    private String email;

    public User(){}

    public User(String username, String password, String email) {
        this(new Random().nextLong(),username,password,email);
    }

    public User(long id, String userName, String password, String email) {
        this.id = id;
        this.username = userName;
        this.password = password;
        this.email = email;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
