package corejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reflection {
	
	

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		 
		Class<?> clazz = names.getClass();
		 
		System.out.println(clazz.getTypeName()); //java.util.ArrayList
		System.out.println(clazz.getName());  //java.util.ArrayList
		System.out.println(clazz.getCanonicalName()); //java.util.ArrayList
		System.out.println(clazz.isInterface()); //false
		
		
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors(); //private and public constructors
		Constructor<?>[] constructors = clazz.getConstructors(); // public constructors only
		int length = constructors.length; // no of constructors
		
		try {
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class); //parameterized constructors
			Constructor<?> constructor = clazz.getConstructor(int.class); // public parameterized constructors only
		} catch (NoSuchMethodException e) { //exception
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		
		 
		Method[] declaredMethods = clazz.getDeclaredMethods();
		System.out.println(declaredMethods[0].getName()); //add
		
	}
	

    public static void printConstructorsData(Class<?> clazz) {
        Constructor<?> [] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));

        for (int i = 0 ; i < constructors.length ; i++) {
            Class<?> [] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map( type -> type.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }
    }
    
    public static <T> T createInstanceWithArguments(Class<T> clazz, Object ... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if(constructor.getParameterTypes().length == args.length) {

                return (T) constructor.newInstance(args);
            }
        }
        System.out.println("An appropriate constructor was not found");
        return null;
    }
    
    

}


