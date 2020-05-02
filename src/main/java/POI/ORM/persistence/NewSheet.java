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

public class NewSheet<E>{
    private Class<E> genericType;

    private RowMapper<E> rowMapper;

    private FakeSheet sheet;

    public NewSheet(Class<E> type) {
        genericType = type;
        rowMapper = new RowMapper<>(type);
        sheet = new FakeSheet();
    }

    /**
     * a row
     * TODO:pending
     * @return
     */
    public List<E> get(int num) {
        return null;
    }

    /**
     * B1(lefttop):C2(rightBottom)
     * @return
     */
    public List<E> get(Range range) {
        return null;
    }

    public List<E> getAll() {
        return null;
    }

    /**
     * a row
     * TODO:pending
     * @return
     */
    public void add(E data) {

    }

    public void addAll(List<E> data) {

    }

    public void addAll(List<E> data, int numRow) {

    }

    public void remove(int numRow) {

    }

    public void removeAll(Range range) {

    }
    
    /**
     * TODO:Pending to the last
     * shift + create
     */
    public void insert() {

    }



    //==============================

    public void testCreateSheet(Class<E> type) {

    }

    public void fakeAdd(E data) {
        final int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum + 1);
        rowMapper.setEntityToRow(data, row);
    }

    public E fakeGet(int rowNum) {
        Row row = sheet.getRow(rowNum);
        return rowMapper.getEntityFromRow(row);
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
