package POI.ORM.persistence;

import POI.ORM.persistence.annotation.Column;
import POI.ORM.persistence.annotation.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

final class RowMapper<E> {
    private Class<E> cls;
    private String sheetName;
    List<CellMapper> cellMappers;
    RowMapper(Class<E> cls) {
        //precondition check
        if(null == cls) {
            throw new IllegalArgumentException("Parameter can't be null.");
        }
        try {
            cls.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(cls.toString() + " must has default constructor.");
        }
        if(!cls.isAnnotationPresent(Sheet.class)){
            //FIXME:proper exception type
            throw new IllegalArgumentException(cls.toString() + " must indicate sheet'name by using " + Sheet.class.toString());
        }

        //interprete class
        this.cls = cls;
        Sheet annotationSheet = cls.getAnnotation(Sheet.class);
        sheetName = annotationSheet.name();

        cellMappers = new ArrayList<>();
        Field[] fields = cls.getDeclaredFields();
        int colIndex = 0;
        for(Field field : fields) {
            if(!field.isAnnotationPresent(Column.class)) {
                continue;
            }
            field.setAccessible(true);
            cellMappers.add(new CellMapper(colIndex++, field));
        }
        if(cellMappers.isEmpty()) {
            //FIXME:proper exception type
            throw new IllegalArgumentException(cls.toString() + " contains no such field which is annotated by " + Column.class.toString());
        }
    }

    void setModelToRow(E model, Row row) {
        for(CellMapper cellMapper : cellMappers) {
            Cell cell = row.createCell(cellMapper.index, cellMapper.cellType);
            cellMapper.setModelToCell(model, cell);
        }
    }

    E getModelFromRow(Row row) {
        E obj = createObject();
        for(CellMapper cellMapper : cellMappers) {
            Cell cell = row.getCell(cellMapper.index);
            cellMapper.setCellToModel(cell, obj);
        }
        return obj;
    }

    private E createObject() {
        try {
            Constructor<E> defaultConstructor = cls.getConstructor();
            return defaultConstructor.newInstance();
        } catch (Exception e) {
            //FIXME: proper exception
            throw new RuntimeException("internal error:" +e.getMessage());
        }
    }

    private class CellMapper {
        Field field;
        int index;
        CellType cellType;
        CellMapper(int index, Field field) {
            this.index = index;
            this.field = field;
            cellType = MapperUtils.getCellType(field);
        }

        void setModelToCell(Object data, Cell cell) {
            final Object value = get(data);
            switch (cellType) {
                case NUMERIC:
                    cell.setCellValue(((Number)value).doubleValue());
                    break;
                case STRING:
                    cell.setCellValue((String) value);
                    break;
                case BOOLEAN:
                    cell.setCellValue((Boolean) value);
                    break;
                default:
                    break;
            }
        }

        void setCellToModel(Cell cell, Object data) {
            switch (cellType) {
                case NUMERIC:
                    set(data, MapperUtils.castNumericValue(field.getType(), cell.getNumericCellValue()));
                    break;
                case STRING:
                    set(data, cell.getStringCellValue());
                    break;
                case BOOLEAN:
                    set(data, cell.getBooleanCellValue());
                    break;
                default:
                    break;
            }
        }

        Object get(Object data) {
            //Lets boxing the primitive value to Object
            Object value = null;
            try {
                value = field.get(data);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                //FIXME:Throw Exception
            }
            return value;
        }

        void set(Object data, Object value) {
            try {
                field.set(data, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                //FIXME:Throw Exception
            }
        }
    }
}
