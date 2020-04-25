package POI.ORM;

import POI.annotation.Column;
import POI.annotation.Sheet;

@Sheet(name = "Contact")
public class NewPerson {
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private boolean gender;

    Object extra;

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
