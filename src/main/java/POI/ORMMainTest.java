package POI;

import POI.ORM.persistence.NewSheet;
import POI.datamodel.Dog;
import POI.datamodel.Person;

import java.util.List;

public class ORMMainTest {
    public static void main(String[] args) {
//        NewSheet.getAnnotations(Person.class);
        NewSheet<Person> sheet = new NewSheet<>(Person.class);
//        sheet.testPerson();
//        sheet.fakeAdd(new Person("Jiawu", 22, false));
//        Person person = sheet.fakeGet(0);
        Person person = sheet.getModelT(0, Person.class);
        List<Dog> dogs = sheet.getModelT(0, 2, Dog.class);
        System.out.println("End");
    }
}
