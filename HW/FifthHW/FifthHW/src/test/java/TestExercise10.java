import Exercise10.Exercise10Configuration;
import Exercise10.IProfession;
import Exercise10.Person;
import Exercise10.Profession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class TestExercise10 {

    @org.junit.Test
    public void exercise10(){
        var context = new AnnotationConfigApplicationContext(Exercise10Configuration.class);
        Person person = context.getBean(Person.class);
        IProfession profession = person.getProfession();
        System.out.println(profession.printProfession());
        assertNotNull(person);
    }
}
