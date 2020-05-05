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

    public static Object castNumericValue(Class<?> type, Number value) {
        if (int.class == type || Integer.class == type) {
            return value.intValue();
        }
        if (float.class == type || Float.class == type) {
            return value.floatValue();
        }
        if (long.class == type || Long.class == type) {
            return value.longValue();
        }
        if (double.class == type || Double.class == type) {
            return value.doubleValue();
        }
        return value;
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
