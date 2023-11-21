package Embaddeble;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;

public class UserInfo {
    @AttributeOverride(name = "age", column = @Column(name = "age"))
    private int age;
    @AttributeOverride(name = "sex", column = @Column(name = "sex"))
    private char sex;

    public UserInfo() {
    }

    public UserInfo(int age, char sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
