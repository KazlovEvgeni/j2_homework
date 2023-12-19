import Exercise2.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class TestExercise2 {

    @org.junit.Test
    public void exercise2(){
        var context = new ClassPathXmlApplicationContext("Exercise2.xml");
        Person person = context.getBean(Person.class);
        context.close();
        assertNotNull(person);
    }
}
