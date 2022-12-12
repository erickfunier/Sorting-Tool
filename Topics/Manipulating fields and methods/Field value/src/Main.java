import java.lang.reflect.Field;
/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Class itemClass = object.getClass();

        for (Field field : itemClass.getDeclaredFields()) {
            if (!field.trySetAccessible())
                return null;
            if (field.getName().equals(fieldName)) {
                return field.get(fieldName);
            }
        }
        return null;
    }

}