package POI;

import POI.ORM.NewSheet;
import POI.annotation.Sheet;
import POI.datamodel.Person;

public class ORMMainTest {
    public static void main(String[] args) {
//        NewSheet.getAnnotations(Person.class);
        new NewSheet<Person>().getAll();
    }
}
