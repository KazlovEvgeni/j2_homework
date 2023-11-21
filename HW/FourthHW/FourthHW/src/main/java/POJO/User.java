package POJO;

import Embaddeble.UserInfo;
import com.sun.istack.Nullable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GenericGenerator(strategy = "uuid", name = "user_uuid")
    @GeneratedValue(generator = "user_uuid")
    @Column(name = "id_user")
    private String userID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Embedded
    @Nullable
    private UserInfo userInfo;

    public User(String name, String surname, UserInfo userInfo) {
        this.name = name;
        this.surname = surname;
        this.userInfo = userInfo;
    }

    public User(String userID, String name, String surname, UserInfo userInfo) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.userInfo = userInfo;
    }

    public User() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
