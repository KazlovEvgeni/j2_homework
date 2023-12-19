package Exercise8_9;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    private int age;
    private String name;
    @Autowired
    @IJob
    private IProfession profession;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IProfession getProfession() {
        return profession;
    }

    public void setProfession(IProfession profession) {
        this.profession = profession;
    }
}
