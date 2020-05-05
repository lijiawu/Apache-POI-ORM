package POI.ORM.persistence;

import POI.ORM.Mock.FakeSheet;
import POI.ORM.Range;
import POI.ORM.persistence.annotation.Column;
import POI.datamodel.Person;
import org.apache.poi.ss.usermodel.Row;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

//TODO:
public class NewSheet<E>{
    private Class<E> genericType;

    private RowMapper<E> rowMapper;

    private FakeSheet sheet;

    public NewSheet(Class<E> type) {
        genericType = type;
        rowMapper = new RowMapper<>(type);
        sheet = new FakeSheet();
    }

    public E getModel(int start) {
        return null;
    }
    /**
     * a row
     * TODO:pending
     * @return
     */
    public List<E> getModelFrom(int start) {
        return null;
    }

    public List<E> getModelRange(int start, int end) {
        return null;
    }

    public void writeModelTile(Class<?> cls, int rownum) {

    }

    /**
     * B1(lefttop):C2(rightBottom)
     * @return
     */
    public List<E> getModel(Range range) {
        return null;
    }

    public List<E> getModelAll() {
        return null;
    }

    /**
     * a row
     * TODO:pending
     * @return
     */
    public void addModel(E data) {

    }

    public void addModelAll(List<E> data) {

    }

    public void addModelAll(List<E> data, int numRow) {

    }

    //==============================

    public <T> T getModelT(int rowNum, Class<T> modelCls) {
        RowMapper<T> mapper = new RowMapper<>(modelCls);
        Row row = sheet.getRow(rowNum);
        return mapper.getModelFromRow(row);
    }

    public <T> List<T> getModelT(int startRowNum, int endRowNum, Class<T> modelCls) {
        //TODO:CHECK startRowNum <= endRowNum
        RowMapper<T> mapper = new RowMapper<>(modelCls);
        List<T> models = new ArrayList<>();
        for(int i = startRowNum; i < endRowNum; ++i) {
            Row row = sheet.getRow(i);
            models.add(mapper.getModelFromRow(row));
        }
        return models;
    }

    public void testCreateSheet(Class<E> type) {

    }

    public void fakeAdd(E data) {
        final int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum + 1);
        rowMapper.setModelToRow(data, row);
    }

    public E fakeGet(int rowNum) {
        Row row = sheet.getRow(rowNum);
        return rowMapper.getModelFromRow(row);
    }

    public void testPerson() {
        Field[] fields = genericType.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.toString() + "#type:" + field.getType().toString() + "#has Column Anno:" + field.isAnnotationPresent(Column.class));
        }
    }

    public void add(E obj, E ...objs) {}
    public List<E> test() {
        List<String> i = new ArrayList<>();
        NewSheet<Person> p = new NewSheet<>(Person.class);
        Type itype = p.getClass().getGenericSuperclass();

        System.out.println(itype instanceof ParameterizedType);
        Type[] type = getClass().getGenericInterfaces();
        for(Type t : type) {
            System.out.println(t.toString());
        }

        TypeVariable[]  variables = getClass().getTypeParameters();
        for(TypeVariable v : variables) {
            Type[] types = v.getBounds();
            for(Type t : types) {
                Type d = determineClass(Object.class, t);
                System.out.println(d.toString());
            }

        }

        return new ArrayList<>();
    }

    private static <T> Class<T> determineClass(Class<? super T> bound, Type candidate) {
        if (candidate instanceof Class<?>) {
            final Class<?> cls = (Class<?>) candidate;
            if (bound.isAssignableFrom(cls)) {
                return (Class<T>) cls;
            }
        }

        return null;
    }

    public static <T> void getAnnotations(Class<T> c) {
        Annotation[] annotations = c.getDeclaredAnnotations();
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.toString());
        }
        for(Annotation anno : annotations) {
            System.out.println(anno.toString());
        }
    }
}
