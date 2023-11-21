package Extends.SingleTable.DAO;

import Extends.SingleTable.POJO.Person1;

public interface Person1DAO {
    int createPerson(Person1 person);
    Person1 readPerson(int id);
}
