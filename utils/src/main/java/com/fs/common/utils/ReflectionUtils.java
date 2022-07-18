package com.fs.common.utils;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类 <br />
 * <br />
 * 提供了一系列的获取某一个类的信息的方法<br />
 * 包括获取全类名，实现的接口，接口的泛型等<br />
 * 并且提供了根据Class类型获取对应的实例对象的方法，以及修改属性和调用对象的方法等
 */
public class ReflectionUtils {
    public static final String TAG = "ReflectionUtils";

    /**
     * 查找类名
     *
     * @param clazzName
     * @param classLoader
     * @return
     */
    public static Class<?> findClass(String clazzName, ClassLoader classLoader) {
        Class<?> aClass
                = null;
        try {
            aClass = classLoader.loadClass(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }


    /**
     * 获取包名
     *
     * @return 包名【String类型】
     */
    public static String getPackage(Class<?> clazz) {
        Package pck = clazz.getPackage();
        if (null != pck) {
            return pck.getName();
        } else {
            return "没有包！";
        }
    }

    /**
     * 获取继承的父类的全类名
     *
     * @return 继承的父类的全类名【String类型】
     */
    public static String getSuperClassName(Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        if (null != superClass) {
            return superClass.getName();
        } else {
            return "没有父类！";
        }
    }

    /**
     * 获取全类名
     *
     * @return 全类名【String类型】
     */
    public static String getClassName(Class<?> clazz) {
        return clazz.getName();
    }

    /**
     * 获取实现的接口名
     *
     * @return 所有的接口名【每一个接口名的类型为String，最后保存到一个List集合中】
     */
    public static List<String> getInterfaces(Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();
        int len = interfaces.length;

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            Class<?> itfc = interfaces[i];

            // 接口名
            String interfaceName = itfc.getSimpleName();

            list.add(interfaceName);
        }

        return list;
    }


    public static void setLongField(Object obj, String fieldName, long value) {
        try {
            findField(obj.getClass(), fieldName).setLong(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void setShortField(Object obj, String fieldName, short value) {
        try {
            findField(obj.getClass(), fieldName).setShort(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    //#################################################################################################

    /**
     * Sets the value of an object field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setObjectField(Object obj, String fieldName, Object value) {
        try {
            findField(obj.getClass(), fieldName).set(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of a {@code boolean} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setBooleanField(Object obj, String fieldName, boolean value) {
        try {
            findField(obj.getClass(), fieldName).setBoolean(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of a {@code byte} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setByteField(Object obj, String fieldName, byte value) {
        try {
            findField(obj.getClass(), fieldName).setByte(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of a {@code char} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setCharField(Object obj, String fieldName, char value) {
        try {
            findField(obj.getClass(), fieldName).setChar(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of a {@code double} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setDoubleField(Object obj, String fieldName, double value) {
        try {
            findField(obj.getClass(), fieldName).setDouble(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of a {@code float} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setFloatField(Object obj, String fieldName, float value) {
        try {
            findField(obj.getClass(), fieldName).setFloat(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Sets the value of an {@code int} field in the given object instance. A class reference is not sufficient! See also {@link #findField}.
     */
    public static void setIntField(Object obj, String fieldName, int value) {
        try {
            findField(obj.getClass(), fieldName).setInt(obj, value);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * 获取所有属性
     *
     * @return 所有的属性【每一个属性添加到StringBuilder中，最后保存到一个List集合中】
     */
    public static List<StringBuilder> getFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        int len = fields.length;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            Field field = fields[i];
            sb = new StringBuilder();

            // 修饰符
            String modifier = Modifier.toString(field.getModifiers());
            sb.append(modifier + " ");

            // 数据类型
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();
            sb.append(typeName + " ");

            // 属性名
            String fieldName = field.getName();
            sb.append(fieldName + ";");

            list.add(sb);
        }

        return list;
    }

    public static Object getStaticObjectField(Class<?> clazz, String fieldName) {
        try {
            return findField(clazz, fieldName).get(null);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static Object getObjectField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).get(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static long getLongField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getLong(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static short getShortField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getShort(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static int getIntField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getInt(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static float getFloatField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getFloat(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static double getDoubleField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getDouble(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static char getCharField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getChar(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static byte getByteField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getByte(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static boolean getBooleanField(Object obj, String fieldName) {
        try {
            return findField(obj.getClass(), fieldName).getBoolean(obj);
        } catch (IllegalAccessException e) {
            // should not happen
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Look up a field in a class and set it to accessible.
     * 在指定的类中寻找一个字段，并且设置他们为可访问的，然后将他们通过键值对缓存起来
     *
     * @param clazz     The class which either declares or inherits the field.
     * @param fieldName The field name.
     * @return A reference to the field.
     * @throws NoSuchFieldError In case the field was not found.
     */
    public static Field findField(Class<?> clazz, String fieldName) {
        String fullFieldName = clazz.getName() + '#' + fieldName;


        try {
            Field field = findFieldRecursiveImpl(clazz, fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            throw new NoSuchFieldError(fullFieldName);
        }
    }


    private static Field findFieldRecursiveImpl(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            while (true) {
                clazz = clazz.getSuperclass();
                if (clazz == null || clazz.equals(Object.class))
                    break;

                try {
                    return clazz.getDeclaredField(fieldName);
                } catch (NoSuchFieldException ignored) {
                }
            }
            throw e;
        }
    }

    /**
     * 获取所有公共的属性
     *
     * @return 所有公共的属性【每一个属性添加到StringBuilder中，最后保存到一个List集合中】
     */
    public static List<StringBuilder> getPublicFields(Class<?> clazz) {
        Field[] fields = clazz.getFields();
        int len = fields.length;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            Field field = fields[i];
            sb = new StringBuilder();

            // 修饰符
            String modifier = Modifier.toString(field.getModifiers());
            sb.append(modifier + " ");

            // 数据类型
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();
            sb.append(typeName + " ");

            // 属性名
            String fieldName = field.getName();
            sb.append(fieldName + ";");

            list.add(sb);
        }

        return list;
    }

    /**
     * 获取所有构造方法
     *
     * @return 所有的构造方法【每一个构造方法添加到StringBuilder中，最后保存到一个List集合中】
     */
    public static List<StringBuilder> getConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        int len = constructors.length;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            Constructor<?> constructor = constructors[i];
            sb = new StringBuilder();

            // 修饰符
            String modifier = Modifier.toString(constructor.getModifiers());
            sb.append(modifier + " ");

            // 方法名（类名）
            String constructorName = clazz.getSimpleName();
            sb.append(constructorName + " (");

            // 形参列表
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length = parameterTypes.length;
            for (int j = 0; j < length; j++) {
                Class<?> parameterType = parameterTypes[j];

                String parameterTypeName = parameterType.getSimpleName();

                if (j < length - 1) {
                    sb.append(parameterTypeName + ", ");
                } else {
                    sb.append(parameterTypeName);
                }

            }

            sb.append(") {}");

            list.add(sb);
        }

        return list;
    }

    /**
     * 获取所有自身的方法
     *
     * @return 所有自身的方法【每一个方法添加到StringBuilder中，最后保存到一个List集合中】
     */
    public static List<StringBuilder> getMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        int len = methods.length;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            Method method = methods[i];
            sb = new StringBuilder();

            // 修饰符
            String modifier = Modifier.toString(method.getModifiers());
            sb.append(modifier + " ");

            // 返回值类型
            Class<?> returnClass = method.getReturnType();
            String returnType = returnClass.getSimpleName();
            sb.append(returnType + " ");

            // 方法名
            String methodName = method.getName();
            sb.append(methodName + " (");

            // 形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            int length = parameterTypes.length;

            for (int j = 0; j < length; j++) {
                Class<?> parameterType = parameterTypes[j];

                // 形参类型
                String parameterTypeName = parameterType.getSimpleName();

                if (j < length - 1) {
                    sb.append(parameterTypeName + ", ");
                } else {
                    sb.append(parameterTypeName);
                }

            }

            sb.append(") {}");

            list.add(sb);
        }

        return list;
    }

    /**
     * 获取所有公共的方法
     *
     * @return 所有公共的方法【每一个方法添加到StringBuilder中，最后保存到一个List集合中】
     */
    public static List<StringBuilder> getPublicMethods(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        int len = methods.length;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            Method method = methods[i];
            sb = new StringBuilder();

            // 修饰符
            String modifier = Modifier.toString(method.getModifiers());
            sb.append(modifier + " ");

            // 返回值类型
            Class<?> returnClass = method.getReturnType();
            String returnType = returnClass.getSimpleName();
            sb.append(returnType + " ");

            // 方法名
            String methodName = method.getName();
            sb.append(methodName + " (");

            // 形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            int length = parameterTypes.length;

            for (int j = 0; j < length; j++) {
                Class<?> parameterType = parameterTypes[j];

                // 形参类型
                String parameterTypeName = parameterType.getSimpleName();

                if (j < length - 1) {
                    sb.append(parameterTypeName + ", ");
                } else {
                    sb.append(parameterTypeName);
                }

            }

            sb.append(") {}");

            list.add(sb);
        }

        return list;
    }

    /**
     * 获取所有的注解名
     *
     * @return 所有的注解名【每一个注解名的类型为String，最后保存到一个List集合中】
     */
    public static List<String> getAnnotations(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        int len = annotations.length;

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            Annotation annotation = annotations[i];

            String annotationName = annotation.annotationType().getSimpleName();
            list.add(annotationName);
        }

        return list;
    }

    /**
     * 获取父类的泛型
     *
     * @return 父类的泛型【Class类型】
     */
    public static Class<?> getSuperClassGenericParameterizedType(Class<?> clazz) {
        Type genericSuperClass = clazz.getGenericSuperclass();

        Class<?> superClassGenericParameterizedType = null;

        // 判断父类是否有泛型
        if (genericSuperClass instanceof ParameterizedType) {
            // 向下转型，以便调用方法
            ParameterizedType pt = (ParameterizedType) genericSuperClass;
            // 只取第一个，因为一个类只能继承一个父类
            Type superClazz = pt.getActualTypeArguments()[0];
            // 转换为Class类型
            superClassGenericParameterizedType = (Class<?>) superClazz;
        }

        return superClassGenericParameterizedType;
    }

    /**
     * 获取接口的所有泛型
     *
     * @return 所有的泛型接口【每一个泛型接口的类型为Class，最后保存到一个List集合中】
     */
    public static List<Class<?>> getInterfaceGenericParameterizedTypes(Class<?> clazz) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        int len = genericInterfaces.length;

        List<Class<?>> list = new ArrayList<Class<?>>();
        for (int i = 0; i < len; i++) {
            Type genericInterface = genericInterfaces[i];

            // 判断接口是否有泛型
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) genericInterface;

                // 得到所有的泛型【Type类型的数组】
                Type[] interfaceTypes = pt.getActualTypeArguments();

                int length = interfaceTypes.length;

                for (int j = 0; j < length; j++) {
                    // 获取对应的泛型【Type类型】
                    Type interfaceType = interfaceTypes[j];
                    // 转换为Class类型
                    Class<?> interfaceClass = (Class<?>) interfaceType;
                    list.add(interfaceClass);
                }

            }

        }

        return list;
    }

    /**
     * 打印包名
     */
    public static void printPackage(Class<?> clazz) {
        System.out.println(getPackage(clazz));
    }

    /**
     * 打印继承的父类的全类名
     */
    public static void printSuperClassName(Class<?> clazz) {
        System.out.println(getSuperClassName(clazz));
    }

    /**
     * 打印全类名
     */
    public static void printClassName(Class<?> clazz) {
        System.out.println(getClassName(clazz));
    }

    /**
     * 打印实现的接口
     */
    public static void printInterfaces(Class<?> clazz) {
        List<String> list = getInterfaces(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有实现接口！");
        }
    }

    /**
     * 打印所有属性
     */
    public static void printFields(Class<?> clazz) {
        List<StringBuilder> list = getFields(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有属性！");
        }
    }

    /**
     * 打印所有公共的属性
     */
    public static void printPublicFields(Class<?> clazz) {
        List<StringBuilder> list = getPublicFields(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有属性！");
        }
    }

    /**
     * 打印所有构造方法
     */
    public static void printConstructors(Class<?> clazz) {
        List<StringBuilder> list = getConstructors(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有构造方法！");
        }
    }

    /**
     * 打印所有方法
     */
    public static void printMethods(Class<?> clazz) {
        List<StringBuilder> list = getMethods(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有方法！");
        }
    }

    /**
     * 打印所有公共的方法
     */
    public static void printPublicMethods(Class<?> clazz) {
        List<StringBuilder> list = getPublicMethods(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有方法！");
        }
    }

    /**
     * 打印所有的注解
     */
    public static void printAnnotations(Class<?> clazz) {
        List<String> list = getAnnotations(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("没有注解！");
        }
    }

    /**
     * 打印父类的泛型名
     */
    public static void printSuperClassGenericParameterizedType(Class<?> clazz) {
        Class<?> superClassGenericParameterizedType = getSuperClassGenericParameterizedType(clazz);
        if (null != superClassGenericParameterizedType) {
            System.out.println(superClassGenericParameterizedType.getSimpleName());
        } else {
            System.out.println("父类没有泛型！");
        }
    }

    /**
     * 打印接口的泛型
     */
    public static void printInterfaceGenericParameterizedTypes(Class<?> clazz) {
        List<Class<?>> list = getInterfaceGenericParameterizedTypes(clazz);
        int size = list.size();
        if (0 < size) {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i).getSimpleName());
            }
        } else {
            System.out.println("没有泛型接口！");
        }
    }

    /**
     * 打印一个类的相关信息
     *
     * @param clazz
     */
    public static void printAll(Class<?> clazz) {
        System.out.print("【包名】  ");
        printPackage(clazz);

        System.out.print("【类名】  ");
        System.out.println(clazz.getSimpleName());

        System.out.println("\n【父类全类名】");
        printSuperClassName(clazz);
        System.out.println("【全类名】");
        printClassName(clazz);
        System.out.println("\n【所有已实现的接口】");
        printInterfaces(clazz);

        System.out.println("\n【属性】");
        printFields(clazz);
        System.out.println("\n【构造方法】");
        printConstructors(clazz);
        System.out.println("\n【方法】");
        printMethods(clazz);

        System.out.println("\n【公共的属性】");
        printPublicFields(clazz);
        System.out.println("\n【公共的方法】");
        printPublicMethods(clazz);
    }

    /**
     * 根据Class类型，获取对应的实例【要求必须有无参的构造器】
     *
     * @return 对应的实例【Object类型】
     */
    public static Object getNewInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }

    /**
     * 根据传入的类的Class对象，以及构造方法的形参的Class对象，获取对应的构造方法对象
     *
     * @param clazz          类的Class对象
     * @param parameterTypes 构造方法的形参的Class对象【可以不写】
     * @return 构造方法对象【Constructor类型】
     */
    public static Constructor<?> getConstructor(Class<?> clazz, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return clazz.getDeclaredConstructor(parameterTypes);
    }

    /**
     * 根据传入的构造方法对象，以及，获取对应的实例
     *
     * @param constructor 构造方法对象
     * @param initargs    传入构造方法的实参【可以不写】
     * @return 对应的实例【Object类型】
     */
    public static Object getNewInstance(Constructor<?> constructor, Object... initargs)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        constructor.setAccessible(true);
        return constructor.newInstance(initargs);
    }

    /**
     * 根据传入的属性名字符串，修改对应的属性值
     *
     * @param clazz 类的Class对象
     * @param name  属性名
     * @param obj   要修改的实例对象
     * @param value 修改后的新值
     */
    public static void setField(Class<?> clazz, String name, Object obj, Object value)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }

    /**
     * 根据传入的方法名字符串，获取对应的方法
     *
     * @param clazz          类的Class对象
     * @param name           方法名
     * @param parameterTypes 方法的形参对应的Class类型【可以不写】
     * @return 方法对象【Method类型】
     */
    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        if (parameterTypes == null) {

            Method method = null;
            try {
                method = clazz.getDeclaredMethod(name);

            } catch (Exception e) {

            }

            if (method == null) {
                clazz.getMethod(name);
            }

            return method;
        }
        if (parameterTypes.length == 0) {

            Method declaredMethod = null;

            try {
                declaredMethod = clazz.getDeclaredMethod(name);
            } catch (Exception e) {
            }
            if (declaredMethod == null) {
                declaredMethod = clazz.getMethod(name);
            }
            return declaredMethod;

        }

        Method method = null;


        try {
            method = clazz.getDeclaredMethod(name, parameterTypes);
        } catch (Exception e) {
        }


        if (method == null) {
            method = clazz.getMethod(name, parameterTypes);
        }
        return method;
    }

    /**
     * 根据传入的方法对象，调用对应的方法
     *
     * @param method 方法对象
     * @param obj    要调用的实例对象【如果是调用静态方法，则可以传入null】
     * @param args   传入方法的实参【可以不写】
     * @return 方法的返回值【没有返回值，则返回null】
     */
    public static Object invokeMethod(Method method, Object obj, Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    /**
     * 直接执行传入的对象的指定方法
     *
     * @param obj
     * @param methodName
     * @param args
     * @return
     */
    public static Object callMethod(Object obj, String methodName, Object... args) {
        if (obj == null) {
            Log.d(TAG, "callMethod: 将要调用的对象为空,无法执行方法" + methodName);
            return null;
        }
        Class<?> aClass = obj.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?>[] parameterClasses = new Class[0];
        try {
            parameterClasses = getParameterClasses(classLoader, args);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "callMethod: ", e);
        }
        return callMethod(obj, methodName, parameterClasses, args);
    }


    public static Object callMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args) {
        Class<?> aClass = obj.getClass();
        try {

            Method method = getMethod(aClass, methodName, parameterTypes);
            if (method == null) {
                throw new NullPointerException("方法为找到:" + methodName);
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "callMethod: ", e);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "callMethod: ", e);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "callMethod: ", e);
        }
        return null;
    }


    private static Class<?>[] getParameterClasses(ClassLoader classLoader, Object[] parameterTypesAndCallback) throws ClassNotFoundException {
        Class<?>[] parameterClasses = null;
        for (int i = parameterTypesAndCallback.length - 1; i >= 0; i--) {
            Object type = parameterTypesAndCallback[i];
            if (type == null)
                throw new ClassNotFoundException("参数不能为空,否则无法获取类型!");

            if (parameterClasses == null)
                parameterClasses = new Class<?>[i + 1];

            if (type instanceof Class)
                parameterClasses[i] = (Class<?>) type;
            else if (type instanceof String)
                parameterClasses[i] = findClass((String) type, classLoader);
            else
                throw new ClassNotFoundException("parameter type must either be specified as Class or String", null);
        }

        // if there are no arguments for the method
        if (parameterClasses == null)
            parameterClasses = new Class<?>[0];

        return parameterClasses;
    }


    public static Object callStaticMethod(Class<?> clazz, String methodName, Object... args) {
        ClassLoader classLoader = clazz.getClassLoader();
        Object invoke = null;
        try {
            Class<?>[] parameterClasses = getParameterClasses(classLoader, args);
            invoke = callStaticMethod(clazz, methodName, parameterClasses, args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoke;
    }

    public static Object callStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object... args) {
        Object invoke = null;
        try {
            Method method = getMethod(clazz, methodName, parameterTypes);
            method.setAccessible(true);
            invoke = method.invoke(null, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return invoke;
    }

}