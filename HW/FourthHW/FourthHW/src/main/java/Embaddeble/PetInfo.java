package Embaddeble;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PetInfo {
    @AttributeOverride(name = "age", column = @Column(name = "age"))
    private int age;

    public PetInfo() {
    }

    public PetInfo(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
