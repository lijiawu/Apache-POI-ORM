package POI.ORM;

import POI.ORM.persistence.NewSheet;

public class NewXlsx {

    public <T> NewSheet<T> createSheet(Class<T> entity) {
        return new NewSheet<>(entity);
    }

    public <T> NewSheet<T> getSheet(Class<T> entity) {
        return new NewSheet<>(entity);
    }
}
