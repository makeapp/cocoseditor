/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: yuanyou
 * Date: 11-5-13
 * Time: 下午5:35
 */
@com.googlecode.javacpp.annotation.Opaque
public class FieldUtil
{
    public static boolean hasAnnotation(Field field, Class ann)
    {
        if (field == null || ann == null) {
            return false;
        }
        return field.getAnnotation(ann) != null;
    }

    public static String getGetName(String name)
    {
        if (name == null) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("get");
        buffer.append(Character.toUpperCase(name.charAt(0)));
        buffer.append(name.substring(1));
        return buffer.toString();
    }

    public static String getFieldName(String methodName)
    {
        if (StringUtil.isInvalid(methodName) || !methodName.startsWith("get")) {
            return null;
        }

        String fieldName = methodName.substring(3);

        StringBuffer buffer = new StringBuffer();
        buffer.append(Character.toLowerCase(fieldName.charAt(0)));
        buffer.append(fieldName.substring(1));

        return buffer.toString();
    }

    public static String getSetName(String name)
    {
        if (name == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("set");
        buffer.append(Character.toUpperCase(name.charAt(0)));
        buffer.append(name.substring(1));
        return buffer.toString();
    }

    public static Method getGetMethod(Field field)
    {
        if (field == null) {
            return null;
        }
        String name = getGetName(field.getName());
        Class clazz = field.getDeclaringClass();
        try {
            return clazz.getMethod(name);
        }
        catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getSetMethod(Object object, String name, Class type)
    {
        if (object == null) {
            return null;
        }
        Class clazz = object.getClass();
        name = getSetName(name);
        return getMethod(name, type, clazz);
    }

    private static Method getMethod(String name, Class type, Class clazz)
    {
        if (type == null || clazz == null || name == null) {
            return null;
        }

        Method method = null;
        try {
            method = clazz.getMethod(name, type);
        }
        catch (NoSuchMethodException e) {
        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        if (method == null) {
            Method smethod = getMethod(name, type.getSuperclass(), clazz);
            if (smethod != null) {
                return smethod;
            }
            Class[] interfaces = type.getInterfaces();
            for (Class cl : interfaces) {
                Method imethod = getMethod(name, cl, clazz);
                if (imethod != null) {
                    return imethod;
                }
            }
        }

        return method;
    }

    public static Method getGetMethod(Object object, String name)
    {
        if (object == null) {
            return null;
        }
        Class clazz = object.getClass();
        try {
            name = getGetName(name);
            return clazz.getMethod(name);
        }
        catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static <T extends Annotation> T getFieldAnnotation(Field f, Class<T> tClass)
    {
        T t = (T) f.getAnnotation(tClass);
        if (t == null) {
            Method method = getGetMethod(f);
            if (method != null) {
                t = (T) method.getAnnotation(tClass);
            }
        }
        return t;
    }

    public static Field getField(Object obj, String f)
    {
        if (obj != null) {
            try {
                return obj.getClass().getDeclaredField(f);
            }
            catch (NoSuchFieldException e) {
//                e.printStackTrace();
            }
        }
        return null;
    }


    public static Field getField(Class clazz, String f)
    {
        if (clazz != null) {
            try {
                return clazz.getDeclaredField(f);
            }
            catch (NoSuchFieldException e) {
//                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object getFieldValue(Object obj, String f)
    {
        Method m = getGetMethod(obj, f);
        if (m != null) {
            try {
                return m.invoke(obj);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object getFieldValue(Object obj, Field f)
    {

        Method m = getGetMethod(f);
        if (m != null) {
            try {
                return m.invoke(obj);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void setFieldValue(Object obj, String f, Object value)
    {
        if (value == null) {
            return;
        }
        Field field = FieldUtil.getField(obj, f);
        if (field == null) {
            return;
        }

        Object newValue = value;
        if (newValue == null) {
            return;
        }
        try {
            field.set(obj, value);
            return;
        }
        catch (IllegalAccessException e) {
//            e.printStackTrace();
        }
        Method m = getSetMethod(obj, f, newValue.getClass());
        if (m != null) {
            try {
                m.invoke(obj, newValue);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFieldValue(Object obj, Field f, Object value)
    {
        Method m = getSetMethod(f);
        if (m != null) {
            try {
                m.invoke(obj, value);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static Method getSetMethod(Field field)
    {
        if (field == null) {
            return null;
        }
        String name = getSetName(field.getName());
        Class clazz = field.getDeclaringClass();
        return getMethod(name, field.getType(), clazz);
    }

    public static String[] getFieldNames(Class clazz)
    {
        Field[] fields = clazz.getDeclaredFields();
        String[] filedNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            filedNames[i] = fields[i].getName();
        }
        return filedNames;
    }

    public static void main(String[] args) throws NoSuchFieldException
    {
        System.out.println("" + getGetName("test"));
        System.out.println("" + getSetName("test"));

        System.out.println(getSetMethod(FieldUtil.class.getField("test")));

    }
}
