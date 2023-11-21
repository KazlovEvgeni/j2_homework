package Extends.TablePerClass.DAO;

import Extends.TablePerClass.POJO.Person;

public interface PersonDAO {
    int createPerson(Person person);
    Person readPerson(int id);
}
