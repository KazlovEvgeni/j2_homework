package POJO;

import Embaddeble.PetInfo;
import com.sun.istack.Nullable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GenericGenerator(strategy = "increment", name = "pet_increment")
    @GeneratedValue(generator = "pet_increment")
    @Column(name = "id_pet")
    private int petID;
    @Column(name = "name")
    private String name;
    @Embedded
    @Nullable
    private PetInfo petInfo;

    public Pet(int petID, String name) {
        this.petID = petID;
        this.name = name;
    }

    public Pet(String name, PetInfo petInfo) {
        this.name = name;
        this.petInfo = petInfo;
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
