package POI.datamodel;

import POI.annotation.Column;
import POI.annotation.Sheet;

@Sheet(name = "Contact")
public class Person {
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private boolean gender;

    Object extra;

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
