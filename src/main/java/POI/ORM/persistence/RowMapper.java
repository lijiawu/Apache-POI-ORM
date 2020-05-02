package POI.ORM.persistence;

import POI.ORM.persistence.annotation.Column;
import POI.ORM.persistence.annotation.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class RowMapper<E> {
    private Class<E> cls;
    private String sheetName;
    List<CellMapper> cellMappers;
    RowMapper(Class<E> cls) {
        if(null == cls) {
            throw new IllegalArgumentException("cls can't be null.");
        }
        if(!cls.isAnnotationPresent(Sheet.class)){
            //TODO:proper exception type
            throw new IllegalArgumentException("cls must indicate sheet'name by using " + Sheet.class.toString());
        }
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
            //TODO:proper exception type
            throw new IllegalArgumentException("cls contains no such field which is annotated by " + Column.class.toString());
        }
    }

    void setDataToRow(E data, Row row) {
        for(CellMapper cellMapper : cellMappers) {
            Cell cell = row.createCell(cellMapper.index, cellMapper.cellType);
            cellMapper.setDataToCell(data, cell);
        }
    }

    E getDataFromRow(Row row) {
        return null;
    }

    class CellMapper {
        Field field;
        int index;
        CellType cellType;
        CellMapper(int index, Field field) {
            this.index = index;
            this.field = field;
            cellType = MapperUtils.getCellType(field);
        }

        void setDataToCell(Object data, Cell cell) {
            //Lets boxing the primitive value to Object
            Object value = null;
            try {
                value = field.get(data);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(value == null) {
                //TODO: proper error
                throw new RuntimeException("Can't getValue from data obj");
            }
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
    }
}
