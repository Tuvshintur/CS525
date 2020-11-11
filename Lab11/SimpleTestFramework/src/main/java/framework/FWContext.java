package framework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.reflections.Reflections;

public class FWContext {

    private static List<Object> objectMap = new ArrayList<>();

    public FWContext() {
        try {
            // find and instantiate all classes annotated with the @TestClass annotation
            Reflections reflections = new Reflections("");
            Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
            types.addAll(reflections.getTypesAnnotatedWith(Service.class));
            for (Class<?> implementationClass : types) {
                objectMap.add((Object) implementationClass.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        performDI();
    }

    public void start() {
        try {
            for (Object theTestClass : objectMap) {
                // find all methods annotated with the @Test annotation
                Method before = null;
                for (Method method : theTestClass.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Before.class)) {
                        before = method;
                        break;
                    }
                }
                for (Method method : theTestClass.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        if (before != null) {
                            before.invoke(theTestClass);
                        }
                        method.invoke(theTestClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performDI(){
        try {
            for (Object theTestClass : objectMap) {
                // find all methods annotated with the @Test annotation
                for (Field field : theTestClass.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> fieldType = field.getType();
                        Object instance = getBeanOftype(fieldType);
                        field.setAccessible(true);
                        field.set(theTestClass, instance);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Object getBeanOftype(Class<?> interfaceClass) {
        Object service = null;
        try {
            for (Object theTestClass : objectMap) {
                Class<?>[] interfaces = theTestClass.getClass().getInterfaces();
                for (Class<?> theInterface : interfaces) {
                    if (theInterface.getName().contentEquals(interfaceClass.getName()))
                        service = theTestClass;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }
}
