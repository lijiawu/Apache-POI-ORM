package POI;

import POI.ORM.persistence.RowMapper;
import POI.ORM.persistence.Sheet;
import POI.datamodel.Person;

public class ORMMainTest {
    public static void main(String[] args) {
        new RowMapper<>(Person.class);
        new Sheet().addModel(new Person());
    }
}
