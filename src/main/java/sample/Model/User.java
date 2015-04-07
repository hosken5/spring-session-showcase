package sample.Model;

import java.io.Serializable;

/**
 * Created by hongpf on 15/4/6.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -1267719235225203414L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User:{" +
                "name='" + name + '\'' +
                ", pas sword='" + password + '\'' +
                '}';
    }
    private String name ;
    private String password ;
}