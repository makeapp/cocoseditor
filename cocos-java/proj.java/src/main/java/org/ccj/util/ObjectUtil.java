/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: yuanyou
 * Date: 11-8-3
 * Time: 下午1:51
 */
@com.googlecode.javacpp.annotation.Opaque
public class ObjectUtil
{
    public static boolean wait(Object obj, long timeout)
    {
        synchronized (obj) {
            try {
                obj.wait(timeout);
                return true;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static void waitInterrupted(Object obj, long timeout)
        throws InterruptedException
    {
        synchronized (obj) {
            obj.wait(timeout);
        }
    }

    public static boolean notify(Object obj)
    {
        synchronized (obj) {
            obj.notify();
            return true;
        }
    }

    public static boolean notifyAll(Object obj)
    {
        synchronized (obj) {
            obj.notifyAll();
            return true;
        }
    }


    public static <T> T copyObject(Object from, Object to)
    {
        return (T) copyFieldsValue(from, to);
    }

    public static <T> T copyObject(Object from)
    {
        try {
            Object to = from.getClass().newInstance();
            return (T) copyFieldsValue(from, to);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T copyObject(Object from, Class clazz)
    {
        try {
            Object to = clazz.newInstance();
            return (T) copyFieldsValue(from, to);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T copyFieldsValue(Object from, Object to)
    {
        if (from == null || to == null) {
            return (T) to;
        }

        Field[] fields = to.getClass().getDeclaredFields();
        for (Field field : fields) {
            Method getMethod = FieldUtil.getGetMethod(from, field.getName());
            Method setMethod = FieldUtil.getSetMethod(field);
            Object result = MethodUtil.invokeMethod(from, getMethod);
            if (result != null) {
                MethodUtil.invokeMethod(to, setMethod, result);
            }
        }
        return (T) to;
    }

    public static Object copyFieldsValue(Map<String, Object> from, Object to)
    {
        if (from == null || to == null) {
            return to;
        }

        return to;
    }


    public static Map<String, Object> copyFieldsValue(Object from, Map<String, Object> to)
    {
        if (from == null || to == null) {
            return to;
        }

        Field[] fields = from.getClass().getDeclaredFields();
        for (Field field : fields) {
            Method getMethod = FieldUtil.getGetMethod(from, field.getName());
            Object result = MethodUtil.invokeMethod(from, getMethod);
            if (result != null) {
                to.put(field.getName(), result);
            }
        }
        return to;
    }


    public static void writeObject(Object object, File file)
        throws IOException
    {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(file));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(object);
        }
        finally {
            out.close();
        }
    }

    public static Object readObject(File file)
        throws ClassNotFoundException, IOException
    {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            inputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return objectInputStream.readObject();
        }
        finally {
            inputStream.close();
        }
    }

    /**
     * Empty
     */
    public static final Object[] EMTPY_ARRAY = new Object[0];

    /**
     * Singleton used as a null placeholder where null has another meaning.
     * <p/>
     * For example, in a <code>HashMap</code> the get(key) method returns null
     * if the Map contains null or if there is no matching key. The Null
     * placeholder can be used to distinguish between these two cases.
     * <p/>
     * Another example is <code>HashTable</code>, where <code>null</code>
     * cannot be stored.
     * <p/>
     * This instance is Serializable.
     */
    public static final Null NULL = new Null();

    /**
     * ObjectUtils instances should NOT be constructed in standard programming.
     * Instead, the class should be used as <code>ObjectUtils.defaultIfNull("a","b");</code>.
     * This constructor is public to permit tools that require a JavaBean instance
     * to operate.
     */
    protected ObjectUtil()
    {
    }

    /**
     * Returns a default value if the object passed is null.
     *
     * @param object       the object to test
     * @param defaultValue the default value to return
     *
     * @return object if it is not null, defaultValue otherwise
     */
    public static final Object defaultIfNull(Object object, Object defaultValue)
    {
        return (object != null ? object : defaultValue);
    }

    /**
     * Compares two objects for equality, where either one or both
     * objects may be <code>null</code>.
     *
     * @param object1 the first object
     * @param object2 the second object
     *
     * @return <code>true</code> if the values of both objects are the same
     */
    public static final boolean equals(Object object1, Object object2)
    {
        if (object1 == object2) {
            return true;
        }
        if ((object1 == null) || (object2 == null)) {
            return false;
        }
        return object1.equals(object2);
    }

    /**
     * 取对象的hashCode
     *
     * @param obj
     *
     * @return 对象的hashCode
     */
    public static final int hashCode(Object obj)
    {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /**
     * Gets the toString that would be produced by Object if a class did not
     * override toString itself. Null will return null.
     *
     * @param object the object to create a toString for, may be null
     *
     * @return the default toString text, or null if null passed in
     */
    public static final String identityToString(Object object)
    {
        if (object == null) {
            return null;
        }
        return new StringBuilder()
            .append(object.getClass().getName())
            .append('@')
            .append(Integer.toHexString(System.identityHashCode(object)))
            .toString();
    }

    /**
     * Class used as a null placeholder where null has another meaning.
     * <p/>
     * For example, in a <code>HashMap</code> the get(key) method returns null
     * if the Map contains null or if there is no matching key. The Null
     * placeholder can be used to distinguish between these two cases.
     * <p/>
     * Another example is <code>HashTable</code>, where <code>null</code>
     * cannot be stored.
     */
    public static class Null
    {
        /**
         * Ensure singleton.
         *
         * @return the singleton value
         */
        private Object readResolve()
        {
            return NULL;
        }
    }

    public static boolean hasNull(Object... objs)
    {
        if (objs != null) {
            for (Object obj : objs) {
                if (obj == null) {
                    return true;
                }
            }
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isBaseDataType(Object data)
    {
        if (data instanceof Number
            || data instanceof String
            || data instanceof Date
            || data instanceof Boolean) {
            return true;
        }
        return false;
    }

    public static boolean isBaseDataType(Class dataType)
    {
        if (Number.class.isAssignableFrom(dataType)
            || String.class.isAssignableFrom(dataType)
            || Date.class.isAssignableFrom(dataType)
            || Boolean.class.isAssignableFrom(dataType)) {
            return true;
        }
        return false;
    }

}
