package POI.ORM;

public class NewXlsx {
    public <T> NewSheet<T> getSheet(Class<T> entity) {
        return new NewSheet();
    }
}
