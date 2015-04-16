/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yuanyou
 * Date: 11-5-13
 * Time: 下午5:37
 */
@com.googlecode.javacpp.annotation.Opaque
public class MethodUtil
{
    public static boolean hasAnnotation(Method field, Class ann)
    {
        if (field == null || ann == null) {
            return false;
        }
        return field.getAnnotation(ann) != null;
    }


    public static Object invokeMethod(Object obj, Method m, Object... args)
    {
        if (m != null) {
            try {
                return m.invoke(obj, args);
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

    public static Object invokeMethod(Object obj, String name)
    {
        return invokeMethod(obj, name, new Class[]{});
    }


    public static Object invokeMethod(Object obj, String name, Class[] clazz, Object... args)
    {

        Method m = getMethod(obj, name, clazz);
        if (m != null) {
            try {
                return m.invoke(obj, args);
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

    public static Method[] getMethods(Object obj, String name)
    {
        if (obj == null) {
            return new Method[0];
        }

        Method[] methods = obj.getClass().getMethods();
        List<Method> methodList = new ArrayList<Method>();
        for (Method method : methods) {
            if (StringUtil.equals(name, method.getName())) {
                methodList.add(method);
            }
        }
        return methodList.toArray(new Method[methodList.size()]);
    }

    public static Object invokeMethod(Object obj, String name, Object... params)
    {
        Method[] methods = obj.getClass().getMethods();
        out:
        for (Method method : methods) {
            if (StringUtil.equals(name, method.getName())) {
                Class[] paramTypes = method.getParameterTypes();
                if (params.length == paramTypes.length) {
                    Object[] nParams = new Object[paramTypes.length];
                    boolean sameType = true;
                    for (int i = 0; i < params.length; i++) {
                        if (sameType && params[i] != null) {
                            sameType = paramTypes[i].equals(params[i].getClass());
                        }

                        if (!sameType) {
                            if (ObjectUtil.isBaseDataType(paramTypes[i]) && ObjectUtil.isBaseDataType(params[i])) {
//                                nParams[i] = DataUtil.getObject(paramTypes[i], params[i]);
                            }
                            else {
                                continue out;
                            }
                        }
                    }
                    try {
                        if (sameType) {
                            return method.invoke(obj, params);
                        }
                        else {
                            return method.invoke(obj, nParams);
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static Method getMethod(Object obj, String name, Class<?>... parameterTypes)
    {
        try {
            return obj.getClass().getMethod(name, parameterTypes);
        }
        catch (NoSuchMethodException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
