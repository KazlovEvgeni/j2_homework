package Exercise2;

public class Person {
    private static Person person = new Person();
    private int age;
    private String name;
    private IAddress address;

    public static Person getInstance() {
        return person;
    }

    public Person() {
    }

    public void init(){
        System.out.println("Init method");
    }

    public void destroy(){
        System.out.println("Destroy method");
    }

    public Person(int age, String name, IAddress address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

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

    public IAddress getAddress() {
        return address;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }
}
