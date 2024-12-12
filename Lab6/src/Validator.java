import java.lang.reflect.Method;

public class Validator {
    public static void validate(Object... objects) throws Exception {
        for (Object obj : objects) {
            Class objectClass = obj.getClass();
            if (objectClass.isAnnotationPresent(Validate.class)) {
                Validate validateAnnotation = (Validate) objectClass.getAnnotation(Validate.class);
                Class<?> testClass = validateAnnotation.value();
                Method[] methods = testClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(objectClass)) {
                        method.setAccessible(true);
                        Object result = method.invoke(null, obj);
                        if(result.toString() != "true")
                            throw new Exception(result.toString());
                    }
                }
            }
        }
    }
}
