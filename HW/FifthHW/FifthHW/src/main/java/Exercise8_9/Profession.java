package Exercise8_9;

@IJob
public class Profession implements IProfession {
    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

