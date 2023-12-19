import Exercise8_9.IProfession;
import Exercise8_9.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class TestExercise8_9 {

    @org.junit.Test
    public void exercise8_9(){
        var context = new ClassPathXmlApplicationContext("Exercise8_9.xml");
        Person person = context.getBean(Person.class);
        IProfession profession = person.getProfession();
        assertNotNull(profession);
    }
}
