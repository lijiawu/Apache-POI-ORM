package POI.datamodel;

import POI.ORM.persistence.annotation.Column;
import POI.ORM.persistence.annotation.Sheet;

@Sheet(name = "Contact")
public class Person {
    @Column(name)
    private String name;
    @Column
    private int age;
    Object extra;
    @Column
    private boolean gender;

    public Person() {}

    public Person(final String name, final int age, final boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public boolean gender() {
        return gender;
    }
}
