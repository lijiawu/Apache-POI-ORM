package POI.ORM.persistence;

import java.util.List;

public class Sheet{

    public Sheet() {
    }

    public <T> T getModel(int rowNum, Class<T> modelCls) {
        return null;
    }

    public <T> List<T> getModelFrom(int startRowNum, Class<T> modelCls) {
        return null;
    }

    public <T> List<T> getModelRange(int startRowNum, int endRowNum, Class<T> modelCls) {
        return null;
    }

    public <T> List<T> getModelAll(Class<T> modelCls) {
        return null;
    }

    public void writeModelTile(int rowNum, Class<?> cls) {

    }

    public <T> void addModel(T data) {

    }

    public <T> void addModelAll(List<T> data) {

    }

    public <T> void addModelAll(int startRowNum, List<T> data) {

    }
}
