package POI.ORM;

public class Xlsx {
    private Xlsx() {}

    public static NewXlsx load(final String path) {
        return new NewXlsx();
    }
}