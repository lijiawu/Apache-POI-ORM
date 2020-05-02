package POI;

import POI.ORM.persistence.NewSheet;
import POI.datamodel.Person;

public class ORMMainTest {
    public static void main(String[] args) {
//        NewSheet.getAnnotations(Person.class);
        NewSheet<Person> sheet = new NewSheet<>(Person.class);
//        sheet.testPerson();
        sheet.fakeAdd(new Person("Jiawu", 22, false));
    }
}
