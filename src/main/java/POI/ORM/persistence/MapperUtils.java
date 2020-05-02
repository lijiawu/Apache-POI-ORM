package POI.ORM.persistence;

import org.apache.poi.ss.usermodel.CellType;

import java.lang.reflect.Field;

class MapperUtils {
    private MapperUtils() {
    }

    public static CellType getCellType(Field field) {
        Class<?> type = field.getType();
        if (isNumberType(type)) {
            return CellType.NUMERIC;
        } else if (String.class.isAssignableFrom(type)) {
            return CellType.STRING;
        } else if (isBooleanType(type)) {
            return CellType.BOOLEAN;
        } else {
            //TODO:Check
            return CellType.ERROR;
        }
    }

    private static boolean isNumberType(Class<?> type) {
        return Number.class.isAssignableFrom(type) ||
                int.class == type ||
                long.class == type ||
                float.class == type ||
                double.class == type;
    }

    private static boolean isBooleanType(Class<?> type) {
        return Boolean.class.isAssignableFrom(type) ||
                boolean.class.isAssignableFrom(type);
    }
}
