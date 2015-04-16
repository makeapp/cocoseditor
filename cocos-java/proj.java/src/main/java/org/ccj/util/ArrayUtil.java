/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.*;


/**
 * Array工具类
 *
 * @author yuanyou
 * @version 1.00 2005-2-5 20:44:57
 */
@com.googlecode.javacpp.annotation.Opaque
public class ArrayUtil
{
    /**
     * 没有找到
     */
    public static final int NOT_FOUND = -1;
    private static final int MAX_CAPACITY = 1024;
    private static ThreadLocal<SoftReference<List>> listCache = new ThreadLocal<SoftReference<List>>();


    /**
     * 区间检查
     *
     * @param length 数组长度
     * @param from   起始位置
     * @param to     结束位置
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void rangeCheck(int length, int from, int to)
    {
        if (from >= to) {
            throw new IllegalArgumentException("from(" + from +
                ") > to(" + to + ")");
        }
        if (from < 0) {
            throw new ArrayIndexOutOfBoundsException(from);
        }
        if (to > length) {
            throw new ArrayIndexOutOfBoundsException(to);
        }
    }

    /**
     * 索引检查
     *
     * @param off   数组起始偏指
     * @param len   有效访问长度
     * @param index 索引
     *
     * @throws ArrayIndexOutOfBoundsException <code>index<off||index>=off+len</code>
     */
    public static void indexCheck(int off, int len, int index)
    {
        if (index < off || index >= off + len) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound:" + index);
        }
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(long[], int, int, long)
     */
    public static int search(long[] a, long key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a    数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     * @param key  要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(long[], long)
     */
    public static int search(long[] a, int from, int to, long key)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(int[], int, int, int)
     */
    public static int search(int[] a, int key)
    {
        return search(a, 0, a.length, key);
    }

    public static int search(boolean[] a, boolean key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a    数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     * @param key  要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(int[], int)
     */
    public static int search(int[] a, int from, int to, int key)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public static int search(boolean[] a, int from, int to, boolean key)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(short[], int, int, short)
     */
    public static int search(short[] a, short key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(short[], short)
     */
    public static int search(short[] a, int from, int to, short key)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(char[], int, int, char)
     */
    public static int search(char[] a, char key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(char[], char)
     */
    public static int search(char[] a, int from, int to, char key)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a      数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], int, int, byte)
     */
    public static int indexOf(char[] a, char[] target)
    {
        return indexOf(a, 0, a.length, target);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param source 数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], byte)
     */
    public static int indexOf(char[] source, int from, int to, char[] target)
    {
        int sourceCount = to - from;
        int targetCount = target.length;
        if (from >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (from < 0) {
            from = 0;
        }
        if (targetCount == 0) {
            return from;
        }

        char first = target[0];
        int i = from;
        int max = sourceCount - targetCount + i;

        startSearchForFirstChar:
        while (true) {
            /* Look for first character. */
            while (i <= max && source[i] != first) {
                i++;
            }
            if (i > max) {
                return NOT_FOUND;
            }

            /* Found first character, now look at the rest of v2 */
            int j = i + 1;
            int end = j + targetCount - 1;
            int k = 1;
            while (j < end) {
                if (source[j++] != target[k++]) {
                    i++;
                    /* Look for str's first char again. */
                    continue startSearchForFirstChar;
                }
            }
            return i;    /* Found whole string. */
        }
    }

    /**
     * 查找给定的值
     *
     * @param a      数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], int, int, byte)
     */
    public static int search(byte[] a, byte target)
    {
        return search(a, 0, a.length, target);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a      数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], byte)
     */
    public static int search(byte[] a, int from, int to, byte target)
    {
        for (int i = from; i < to; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a      数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], int, int, byte)
     */
    public static int indexOf(byte[] a, byte[] target)
    {
        return indexOf(a, 0, a.length, target);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param source 数组
     * @param target 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(byte[], byte)
     */
    public static int indexOf(byte[] source, int from, int to, byte[] target)
    {
        int sourceCount = to - from;
        int targetCount = target.length;
        if (from >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (from < 0) {
            from = 0;
        }
        if (targetCount == 0) {
            return from;
        }

        byte first = target[0];
        int i = from;
        int max = sourceCount - targetCount + i;

        startSearchForFirstChar:
        while (true) {
            /* Look for first character. */
            while (i <= max && source[i] != first) {
                i++;
            }
            if (i > max) {
                return NOT_FOUND;
            }

            /* Found first character, now look at the rest of v2 */
            int j = i + 1;
            int end = j + targetCount - 1;
            int k = 1;
            while (j < end) {
                if (source[j++] != target[k++]) {
                    i++;
                    /* Look for str's first char again. */
                    continue startSearchForFirstChar;
                }
            }
            return i;    /* Found whole string. */
        }
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(double[], int, int, double)
     */
    public static int search(double[] a, double key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(double[], double)
     */
    public static int search(double[] a, int from, int to, double key)
    {


        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(float[], int, int, float)
     */
    public static int search(float[] a, float key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(float[], float)
     */
    public static int search(float[] a, int from, int to, float key)
    {


        for (int i = from; i < to; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public static int search(String[] array, String s)
    {
        if (s == null || array == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (StringUtil.equals(array[i], s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定的值
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(Object[], int, int, Object)
     */
    public static <T> int search(T[] a, T key)
    {
        return search(a, 0, a.length, key);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a   数组
     * @param key 要查的值
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(Object[], Object)
     */
    public static <T> int search(T[] a, int from, int to, T key)
    {


        for (int i = from; i < to; i++) {
            if (key == a[i] || key.equals(a[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /****************************************************************************/

    /**
     * 查找给定的值
     *
     * @param a          数组
     * @param key        要查的值
     * @param comparator 比较器
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(Object[], int, int, Object)
     */
    public static <T> int search(T[] a, T key, Comparator<T> comparator)
    {
        return search(a, 0, a.length, key, comparator);
    }

    /**
     * 查找给定的值（为了提高速度，没有检查<code>from</code>, <code>to</code>，呵呵）
     *
     * @param a          数组
     * @param key        要查的值
     * @param comparator 比较器
     *
     * @return 返回找到的位置，否则返回<code>#NOT_FOUND</code>
     *
     * @see #search(Object[], Object)
     */
    public static <T> int search(T[] a, int from, int to,
                                 T key, Comparator<T> comparator)
    {


        for (int i = from; i < to; i++) {
            if (comparator.compare(key, a[i]) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(long[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(long[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(int[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(int[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(short[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(short[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(char[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(char[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(byte[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(byte[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(boolean[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(boolean[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(double[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(double[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(float[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(float[] a)
    {
        return a == null || a.length == 0;
    }

    //数组操作

    /**
     * 判断数组时候有效
     *
     * @param a 数组
     */
    public static boolean isValid(Object[] a)
    {
        return a != null && a.length > 0;
    }

    /**
     * 判断数组时候无效
     *
     * @param a 数组
     */
    public static boolean isInvalid(Object[] a)
    {
        return a == null || a.length == 0;
    }

    /**
     * 往指定数组中添加对象，产生新的数组
     *
     * @param array 对象数组
     * @param obj   对象
     *
     * @return 新的数组
     */
    public static <O> O[] add(O[] array, O obj)
    {
        Class clazz = array.getClass().getComponentType();
        int len = array.length;
        O[] newArray = (O[]) Array.newInstance(clazz, len + 1);
        if (len > 0) {
            System.arraycopy(array, 0, newArray, 0, len);
        }
        newArray[len] = obj;
        return newArray;
    }

    /**
     * 往指定数组中添加字符串，产生新的数组
     *
     * @param array 数组
     * @param obj
     * @param pos   在指定的位置插入字符串 [0, array.length]
     *
     * @return 新的数组
     */
    public static <O> O[] add(O[] array, int pos, O obj)
    {
        int len = array.length;
        if (pos < 0 || pos > len) {
            throw new IndexOutOfBoundsException("Invalid pos:" + pos + " length:" + len);
        }
        Class clazz = array.getClass().getComponentType();
        O[] newArray = (O[]) Array.newInstance(clazz, len + 1);
        if (pos > 0) {
            System.arraycopy(array, 0, newArray, 0, pos);
        }
        int c = len - pos;
        if (c > 0) {
            System.arraycopy(array, pos, newArray, pos + 1, c);
        }
        newArray[pos] = obj;
        return newArray;
    }

    /**
     * 往指定数组中删除对象，如果删除成功产生新的数组，反之直接返回该数组
     *
     * @param array 对象数组
     * @param obj   对象
     *
     * @return 如果删除成功产生新的数组，反之直接返回该数组
     */
    public static <O> O[] remove(O[] array, O obj)
    {
        for (int i = 0; i < array.length; i++) {
            if (obj.equals(array[i])) {
                return remove0(array, i);
            }
        }
        return array;
    }

    /**
     * 往指定数组中删除对象，如果删除成功产生新的数组，反之直接返回该数组
     *
     * @param array 对象数组
     * @param index 对象
     *
     * @return 如果删除成功产生新的数组，反之直接返回该数组
     */
    public static Object[] remove(Object[] array, int index)
    {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return remove0(array, index);
    }

    /**
     * 往指定数组中删除对象，如果删除成功产生新的数组，反之直接返回该数组
     *
     * @param array 对象数组
     * @param index 对象
     *
     * @return 如果删除成功产生新的数组，反之直接返回该数组
     */
    private static <O> O[] remove0(O[] array, int index)
    {
        Class clazz = array.getClass().getComponentType();
        int size = array.length - 1;
        O[] newArray = (O[]) Array.newInstance(clazz, size);
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index);
        }
        if (index < size) {
            System.arraycopy(array, index + 1, newArray, index, size - index);
        }
        return newArray;
    }

    /**
     * 往指定数组中添加字符串，产生新的数组
     *
     * @param array 字符串数组
     * @param str   字符串
     *
     * @return 新的数组
     */
    public static String[] add(String[] array, String str)
    {
        int len = array.length;
        String[] newArray = new String[len + 1];
        if (len > 0) {
            System.arraycopy(array, 0, newArray, 0, len);
        }
        newArray[len] = str;
        return newArray;
    }

    /**
     * 往指定数组中添加字符串，产生新的数组
     *
     * @param array 字符串数组
     * @param str   字符串
     * @param pos   在指定的位置插入字符串 [0, array.length]
     *
     * @return 新的数组
     */
    public static String[] add(String[] array, int pos, String str)
    {
        int len = array.length;
        if (pos < 0 || pos > len) {
            throw new IndexOutOfBoundsException("Invalid pos:" + pos + " length:" + len);
        }
        String[] newArray = new String[len + 1];
        if (pos > 0) {
            System.arraycopy(array, 0, newArray, 0, pos);
        }
        int c = len - pos;
        if (c > 0) {
            System.arraycopy(array, pos, newArray, pos + 1, c);
        }
        newArray[pos] = str;
        return newArray;
    }

    /**
     * 往指定数组中删除字符串，如果删除成功产生新的数组，反之直接返回该数组
     *
     * @param array 字符串数组
     * @param str   字符串
     *
     * @return 如果删除成功产生新的数组，反之直接返回该数组
     */
    public static String[] remove(String[] array, String str)
    {
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])) {
                int size = array.length - 1;
                String[] newArray = new String[size];
                if (i > 0) {
                    System.arraycopy(array, 0, newArray, 0, i);
                }
                if (i < size) {
                    System.arraycopy(array, i + 1, newArray, i, size - i);
                }
                return newArray;
            }
        }
        return array;
    }

    /**
     * 添加所有的数据到列表中去
     *
     * @param coll  集合
     * @param array 数组
     */
    public static <E> int addAll(Collection<E> coll, E[] array)
    {
        if (isValid(array)) {
            for (E anArray : array) {
                coll.add(anArray);
            }
            return array.length;
        }
        return 0;
    }

    /**
     * 添加所有的数据到列表中去
     *
     * @param coll  集合
     * @param array 数组
     */
    public static <E> int addAll(List<E> coll, E[] array)
    {
        if (isValid(array)) {
            for (int i = 0, size = array.length; i < size; i++) {
                coll.add(array[i]);
            }
            return array.length;
        }
        return 0;
    }

    //Matches

    /**
     * 从列表中删除指定的对象
     *
     * @param list  列表
     * @param array 数组
     */
    public static <E> void removeAll(List<E> list, E[] array)
    {
        if (isValid(array)) {
            for (int i = 0; i < array.length; i++) {
                list.remove(array[i]);
            }
        }
    }

    /**
     * 添加所有的数据到列表中去
     *
     * @param array 数组
     * @param toAdd 需要被添加的数组
     */
    public static Object[] append(Object[] array, Object[] toAdd)
    {
        if (isValid(toAdd)) {
            Object[] newArray = new Object[array.length + toAdd.length];
            System.arraycopy(array, 0, newArray, 0, array.length);
            System.arraycopy(toAdd, 0, newArray, array.length, toAdd.length);
            return newArray;
        }
        return array;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(long[] a1, int off1,
                                  long[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(long[] a1, int off1,
                                    long[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (a1[i] != a2[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(int[] a1, int off1,
                                  int[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(int[] a1, int off1,
                                    int[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (a1[i] != a2[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(short[] a1, int off1,
                                  short[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(short[] a1, int off1,
                                    short[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (a1[i] != a2[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(char[] a1, int off1,
                                  char[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length, false);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1         数组1
     * @param off1       起始位置1
     * @param a2         数组2
     * @param off2       起始位置2
     * @param length     比较长度
     * @param ignoreCase 是否忽略大小写
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(char[] a1, int off1,
                                  char[] a2, int off2,
                                  int length,
                                  boolean ignoreCase)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length, ignoreCase);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(char[] a1, int off1,
                                    char[] a2, int off2,
                                    int length,
                                    boolean ignoreCase)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        if (ignoreCase) {
            for (; i < max; i++, j++) {
                if (Character.toUpperCase(a1[i]) != Character.toUpperCase(a2[j])) {
                    return false;
                }
            }
        }
        else {
            for (; i < max; i++, j++) {
                if (a1[i] != a2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(byte[] a1, int off1,
                                  byte[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        return !(a1 == null || a2 == null) && matches0(a1, off1, a2, off2, length, false);

    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1         数组1
     * @param off1       起始位置1
     * @param a2         数组2
     * @param off2       起始位置2
     * @param length     比较长度
     * @param ignoreCase
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(byte[] a1, int off1,
                                  byte[] a2, int off2,
                                  int length, boolean ignoreCase)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        return matches0(a1, off1, a2, off2, length, ignoreCase);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1         数组1
     * @param off1       起始位置1
     * @param a2         数组2
     * @param off2       起始位置2
     * @param length     比较长度
     * @param ignoreCase 是否忽略大小写
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(byte[] a1, int off1,
                                    byte[] a2, int off2,
                                    int length,
                                    boolean ignoreCase)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        if (ignoreCase) {
            for (; i < max; i++, j++) {
                if (a1[i] != a2[j]) {
                    return false;
                }
            }
        }
        else {
            for (; i < max; i++, j++) {
                if (a1[i] != a2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(boolean[] a1, int off1,
                                  boolean[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        return matches0(a1, off1, a2, off2, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(boolean[] a1, int off1,
                                    boolean[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (a1[i] != a2[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(double[] a1, int off1,
                                  double[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        return matches0(a1, off1, a2, off2, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(double[] a1, int off1,
                                    double[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (Double.doubleToLongBits(a1[i]) != Double.doubleToLongBits(a2[j])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(float[] a1, int off1,
                                  float[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        return matches0(a1, off1, a2, off2, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(float[] a1, int off1,
                                    float[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        for (; i < max; i++, j++) {
            if (Float.floatToIntBits(a1[i]) != Float.floatToIntBits(a2[j])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    public static boolean matches(Object[] a1, int off1,
                                  Object[] a2, int off2,
                                  int length)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        return matches0(a1, off1, a2, off2, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1     数组1
     * @param off1   起始位置1
     * @param a2     数组2
     * @param off2   起始位置2
     * @param length 比较长度
     *
     * @return <tt>true</tt> 是否匹配
     */
    private static boolean matches0(Object[] a1, int off1,
                                    Object[] a2, int off2,
                                    int length)
    {
        int i = off1, max = off1 + length;
        int j = off2;
        Object obj1, obj2;
        for (; i < max; i++, j++) {
            obj1 = a1[i];
            obj2 = a2[j];
            if (!(obj1 == null ? obj2 == null : obj1.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     */
    public static <T> Iterator<T> iterator(T[] array)
    {
        return listIterator(array);
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     * @param off   起始偏值
     * @param len   需要被枚举的数组长度
     */
    public static <T> Iterator<T> iterator(T[] array, int off, int len)
    {
        return listIterator(array, off, len);
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     */
    public static <T> ListIterator<T> listIterator(T[] array)
    {
        if (isInvalid(array)) {
            return CollectionUtil.emptyListIterator();
        }
        else {
//            return new ArrayIterator<T>(array);
        }
        return null;
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     * @param off   起始偏值
     * @param len   需要被枚举的数组长度
     */
    public static <T> ListIterator<T> listIterator(T[] array, int off, int len)
    {
        if (isInvalid(array) || len == 0 || off > len) {
            return CollectionUtil.emptyListIterator();
        }
        else {
//            return new ArrayIterator<T>(array, off, len);
        }
        return null;
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     */
    public static <T> Enumeration<T> toEnum(T[] array)
    {
        if (isInvalid(array)) {
            return CollectionUtil.emptyEnum();
        }
        else {
//            return new ArrayIterator<T>(array);
        }
        return null;
    }

    /**
     * 对象数组到Iterator的转换
     *
     * @param array 对象数组
     * @param off   起始偏值
     * @param len   需要被枚举的数组长度
     *              Iterator的转换
     */
    public static <T> Enumeration<T> toEnum(T[] array, int off, int len)
    {
        if (isInvalid(array) || len == 0 || off > len) {
            return CollectionUtil.emptyEnum();
        }
        else {
//            return new ArrayIterator<T>(array, off, len);
        }
        return null;
    }

    /**
     * 返回Cache的列表
     */
    static <E> List<E> getList()
    {
        SoftReference ref = listCache.get();
        List<E> list;
        if (ref == null || (list = (List<E>) ref.get()) == null) {
            list = new ArrayList<E>(256);
            listCache.set(new SoftReference<List>(list));
        }
        return list;
    }

    /**
     * 清除Cache
     */
    static void clearList(List list, int size)
    {
        if (size > MAX_CAPACITY) {
            listCache.set(new SoftReference<List>(new ArrayList(256)));
        }
        else {
            list.clear();
        }
    }

    /**
     * 将枚举中的对象转换成对象数组
     *
     * @param en 枚举
     */
    public static <E> E[] toArray(Enumeration<E> en)
    {
        List<E> list = getList();
        CollectionUtil.copy(list, en);
        int size = list.size();
        E[] array = (E[]) new Object[size];
        list.toArray(array);
        clearList(list, size);
        return array;
    }

    /**
     * 将枚举中的对象转换成对象数组
     *
     * @param it 枚举
     */
    public static <E> E[] toArray(Iterator<E> it)
    {
        List<E> list = getList();
        CollectionUtil.copy(list, it);
        int size = list.size();
        E[] array = (E[]) new Object[size];
        list.toArray(array);
        clearList(list, size);
        return array;
    }

    /**
     * 将枚举中的对象转换成对象数组
     *
     * @param en            枚举
     * @param componentType 创建的数组的子类型
     */
    public static <E> E[] toArray(Enumeration<E> en, Class componentType)
    {
        List<E> list = getList();
        CollectionUtil.copy(list, en);
        int size = list.size();
        E[] array = (E[]) Array.newInstance(componentType, size);
        list.toArray(array);
        clearList(list, size);
        return array;
    }

    /**
     * 将枚举中的对象转换成对象数组
     *
     * @param it            枚举
     * @param componentType 创建的数组的子类型
     */
    public static <E> E[] toArray(Iterator<E> it, Class componentType)
    {
        List<E> list = getList();
        CollectionUtil.copy(list, it);
        int size = list.size();
        E[] array = (E[]) Array.newInstance(componentType, size);
        list.toArray(array);
        clearList(list, size);
        return array;
    }

    //From Arrays

    /**
     * 对长整数数组进行快速排序
     *
     * @param l 长整数组
     */
    public static void sort(long[] l)
    {
        Arrays.sort(l);
    }

    /**
     * 对长整数数组进行快速排序
     *
     * @param l    长整数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, l.length)
     */
    public static void sort(long[] l, int from, int to)
    {
        Arrays.sort(l, from, to);
    }

    /**
     * 对整数数组的快速排序
     *
     * @param i 整数组
     */
    public static void sort(int[] i)
    {
        Arrays.sort(i);
    }

    /**
     * 对整数数组的快速排序
     *
     * @param i    整数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, i.length)
     */
    public static void sort(int[] i, int from, int to)
    {
        Arrays.sort(i, from, to);
    }

    /**
     * 对短整数数组的快速排序
     *
     * @param s 短整数组
     */
    public static void sort(short[] s)
    {
        Arrays.sort(s);
    }

    /**
     * 对短整数数组的快速排序
     *
     * @param s    短整数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, s.length)
     */
    public static void sort(short[] s, int from, int to)
    {
        Arrays.sort(s, from, to);
    }

    /**
     * 对字符数组的快速排序
     *
     * @param a 字符数组
     */
    public static void sort(char[] a)
    {
        Arrays.sort(a);
    }

    /**
     * 对字符数组的快速排序
     *
     * @param a    字符数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     */
    public static void sort(char[] a, int from, int to)
    {
        Arrays.sort(a, from, to);
    }

    /**
     * 对字节数组的快速排序
     *
     * @param a 字节数组
     */
    public static void sort(byte[] a)
    {
        Arrays.sort(a);
    }

    /**
     * 对字节数组的快速排序
     *
     * @param a    字节数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     */
    public static void sort(byte[] a, int from, int to)
    {
        Arrays.sort(a, from, to);
    }

    /**
     * 对高精度浮点数数组的快速排序
     *
     * @param a 高精度浮点数数组
     */
    public static void sort(double[] a)
    {
        Arrays.sort(a);
    }

    /**
     * 对高精度浮点数数组的快速排序
     *
     * @param a    高精度浮点数数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     */
    public static void sort(double[] a, int from, int to)
    {
        Arrays.sort(a, from, to);
    }

    /**
     * 对浮点数数组的快速排序
     *
     * @param a 浮点数数组
     */
    public static void sort(float[] a)
    {
        Arrays.sort(a);
    }

    /**
     * 对浮点数数组的快速排序
     *
     * @param a    浮点数数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     */
    public static void sort(float[] a, int from, int to)
    {
        Arrays.sort(a, from, to);
    }

    /**
     * 对对象数组的快速排序
     *
     * @param a 对象数组
     */
    public static void sort(Object[] a)
    {
        Arrays.sort(a);
    }

    /**
     * 对对象数组的快速排序
     *
     * @param a    对象数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     */
    public static void sort(Object[] a, int from, int to)
    {
        Arrays.sort(a, from, to);
    }

    /**
     * 对对象数组的快速排序
     *
     * @param a 对象数组
     * @param c 比较器
     */
    public static <T> void sort(T[] a, Comparator<? super T> c)
    {
        Arrays.sort(a, c);
    }

    /**
     * 对对象数组的快速排序
     *
     * @param a    对象数组
     * @param from 起始位置 [0, to]
     * @param to   结束位置 [from, a.length)
     * @param c    比较器
     */
    public static <T> void sort(T[] a, int from, int to,
                                Comparator<? super T> c)
    {
        Arrays.sort(a, from, to, c);
    }

    /**************************************************************************/

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(byte[])
     */
    public static int binarySearch(long[] a, long key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(int[])
     */
    public static int binarySearch(int[] a, int key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(short[])
     */
    public static int binarySearch(short[] a, short key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(char[])
     */
    public static int binarySearch(char[] a, char key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(byte[])
     */
    public static int binarySearch(byte[] a, byte key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(double[])
     */
    public static int binarySearch(double[] a, double key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(float[])
     */
    public static int binarySearch(float[] a, float key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(Object[])
     */
    public static int binarySearch(Object[] a, Object key)
    {
        return Arrays.binarySearch(a, key);
    }

    /**
     * 二分法查找<br>
     * 数组必需已经排好序<br>
     *
     * @param a   数组
     * @param key 要查找的元素
     *            如果找到该元素，则返回索引，否则<code>-起始点</code>
     *
     * @see #sort(Object[], java.util.Comparator)
     */
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)
    {
        return Arrays.binarySearch(a, key, c);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(long[] a1, long[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    public static boolean contains(String[] array, String s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(int[] array, int s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(long[] array, long s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(byte[] array, byte s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(short[] array, short s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(boolean[] array, boolean s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(float[] array, float s)
    {
        return search(array, s) >= 0;
    }

    public static boolean contains(double[] array, double s)
    {
        return search(array, s) >= 0;
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(int[] a1, int[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(short[] a1, short[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(char[] a1, char[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equalsIgnoreCase(char[] a1, char[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length, true);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(byte[] a1, byte[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equalsIgnoreCase(byte[] a1, byte[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length, true);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(boolean[] a1, boolean[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(double[] a1, double[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(float[] a1, float[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**
     * 判断两个数组中的数组大小和每个元素是否相等<br>
     * （为了提高速度，没有检查位置和长度，呵呵）
     *
     * @param a1 数组1
     * @param a2 数组2
     *           <tt>true</tt> 是否匹配
     */
    public static boolean equals(Object[] a1, Object[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        return matches(a1, 0, a2, 0, length);
    }

    /**************************************************************************/

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(long[] a, long val)
    {
        //为什么不直接调用 # fill(long[], int, int,long)？？
        //掠过区间检查，提高效率
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(long[] a, int from, int to,
                            long val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(int[] a, int val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(int[] a, int from, int to,
                            int val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(short[] a, short val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(short[] a, int from, int to,
                            short val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(char[] a, char val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(char[] a, int from, int to,
                            char val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(byte[] a, byte val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(byte[] a, int from, int to,
                            byte val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(boolean[] a, boolean val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(boolean[] a, int from, int to,
                            boolean val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(double[] a, double val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(double[] a, int from, int to,
                            double val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(float[] a, float val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(float[] a, int from, int to,
                            float val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组
     *
     * @param a   数组
     * @param val 给定值
     */
    public static void fill(Object[] a, Object val)
    {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    /**
     * 用给定的值来填充数组区间
     *
     * @param a    数组
     * @param from 起始位置
     * @param to   结束位置
     * @param val  给定值
     *
     * @throws IllegalArgumentException       <code> from > to</code>
     * @throws ArrayIndexOutOfBoundsException <code>from<0||to>length</code>
     */
    public static void fill(Object[] a, int from, int to,
                            Object val)
    {
        rangeCheck(a.length, from, to);
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>long</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Long}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(long a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        long element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];

            int elementHash = (int) (element ^ (element >>> 32));
            result = 31 * result + elementHash;
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two non-null <tt>int</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Integer}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(int a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        int element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];

            result = 31 * result + element;
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>short</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Short}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(short a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        short element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];

            result = 31 * result + element;
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>char</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Character}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(char a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        char element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];

            result = 31 * result + element;
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>byte</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Byte}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(byte a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        byte element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];

            result = 31 * result + element;
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>boolean</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Boolean}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(boolean a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        boolean element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];
            result = 31 * result + (element ? 1231 : 1237);
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>float</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Float}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(float a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        float element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];
            result = 31 * result + Float.floatToIntBits(element);
        }

        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     * For any two <tt>double</tt> arrays <tt>a</tt> and <tt>b</tt>
     * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is the same value that would be
     * obtained by invoking the {@link java.util.List#hashCode() <tt>hashCode</tt>}
     * method on a {@link java.util.List} containing a sequence of {@link Double}
     * instances representing the elements of <tt>a</tt> in the same order.
     * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
     *
     * @param a the array whose hash value to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @since 1.5
     */
    public static int hashCode(double a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;
        double element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];
            long bits = Double.doubleToLongBits(element);
            result = 31 * result + (int) (bits ^ (bits >>> 32));
        }
        return result;
    }

    /**
     * Returns a hash code based on the contents of the specified array.  If
     * the array contains other arrays as elements, the hash code is based on
     * their identities rather than their contents.  It is therefore
     * acceptable to invoke this method on an array that contains itself as an
     * element,  either directly or indirectly through one or more levels of
     * arrays.
     * <p/>
     * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
     * <tt>Arrays.equals(a, b)</tt>, it is also the case that
     * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
     * <p/>
     * <p>The value returned by this method is equal to the value that would
     * be returned by <tt>Arrays.asList(a).hashCode()</tt>, unless <tt>a</tt>
     * is <tt>null</tt>, in which case <tt>0</tt> is returned.
     *
     * @param a the array whose content-based hash code to compute
     *          a content-based hash code for <tt>a</tt>
     *
     * @see #deepHashCode(Object[])
     * @since 1.5
     */
    public static int hashCode(Object a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;

        Object element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }

        return result;
    }

    /**
     * Returns a hash code based on the "deep contents" of the specified
     * array.  If the array contains other arrays as elements, the
     * hash code is based on their contents and so on, ad infinitum.
     * It is therefore unacceptable to invoke this method on an array that
     * contains itself as an element, either directly or indirectly through
     * one or more levels of arrays.  The behavior of such an invocation is
     * undefined.
     * <p/>
     * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
     * <tt>Arrays.deepEquals(a, b)</tt>, it is also the case that
     * <tt>Arrays.deepHashCode(a) == Arrays.deepHashCode(b)</tt>.
     * <p/>
     * <p>The computation of the value returned by this method is similar to
     * that of the value returned by {@link java.util.List#hashCode()} on a list
     * containing the same elements as <tt>a</tt> in the same order, with one
     * difference: If an element <tt>e</tt> of <tt>a</tt> is itself an array,
     * its hash code is computed not by calling <tt>e.hashCode()</tt>, but as
     * by calling the appropriate overloading of <tt>Arrays.hashCode(e)</tt>
     * if <tt>e</tt> is an array of a primitive type, or as by calling
     * <tt>Arrays.deepHashCode(e)</tt> recursively if <tt>e</tt> is an array
     * of a reference type.  If <tt>a</tt> is <tt>null</tt>, this method
     * returns 0.
     *
     * @param a the array whose deep-content-based hash code to compute
     *          a deep-content-based hash code for <tt>a</tt>
     *
     * @see #hashCode(Object[])
     * @since 1.5
     */
    public static int deepHashCode(Object a[])
    {
        if (a == null) {
            return 0;
        }

        int result = 1;

        Object element;
        for (int i = 0; i < a.length; i++) {
            element = a[i];
            int elementHash = 0;
            if (element instanceof Object[]) {
                elementHash = deepHashCode((Object[]) element);
            }
            else if (element instanceof byte[]) {
                elementHash = hashCode((byte[]) element);
            }
            else if (element instanceof short[]) {
                elementHash = hashCode((short[]) element);
            }
            else if (element instanceof int[]) {
                elementHash = hashCode((int[]) element);
            }
            else if (element instanceof long[]) {
                elementHash = hashCode((long[]) element);
            }
            else if (element instanceof char[]) {
                elementHash = hashCode((char[]) element);
            }
            else if (element instanceof float[]) {
                elementHash = hashCode((float[]) element);
            }
            else if (element instanceof double[]) {
                elementHash = hashCode((double[]) element);
            }
            else if (element instanceof boolean[]) {
                elementHash = hashCode((boolean[]) element);
            }
            else if (element != null) {
                elementHash = element.hashCode();
            }

            result = 31 * result + elementHash;
        }

        return result;
    }

    /**
     * Returns <tt>true</tt> if the two specified arrays are <i>deeply
     * equal</i> to one another.  Unlike the @link{#equals{Object[],Object[])
     * method, this method is appropriate for use with nested arrays of
     * arbitrary depth.
     * <p/>
     * <p>Two array references are considered deeply equal if both
     * are <tt>null</tt>, or if they refer to arrays that contain the same
     * number of elements and all corresponding pairs of elements in the two
     * arrays are deeply equal.
     * <p/>
     * <p>Two possibly <tt>null</tt> elements <tt>e1</tt> and <tt>e2</tt> are
     * deeply equal if any of the following conditions hold:
     * <ul>
     * <li> <tt>e1</tt> and <tt>e2</tt> are both arrays of object reference
     * types, and <tt>Arrays.deepEquals(e1, e2) would return true</tt>
     * <li> <tt>e1</tt> and <tt>e2</tt> are arrays of the same primitive
     * type, and the appropriate overloading of
     * <tt>Arrays.equals(e1, e2)</tt> would return true.
     * <li> <tt>e1 == e2</tt>
     * <li> <tt>e1.equals(e2)</tt> would return true.
     * </ul>
     * Note that this definition permits <tt>null</tt> elements at any depth.
     * <p/>
     * <p>If either of the specified arrays contain themselves as elements
     * either directly or indirectly through one or more levels of arrays,
     * the behavior of this method is undefined.
     *
     * @param a1 one array to be tested for equality
     * @param a2 the other array to be tested for equality
     *           <tt>true</tt> if the two arrays are equal
     *
     * @see #equals(Object[], Object[])
     * @since 1.5
     */
    public static boolean deepEquals(Object[] a1, Object[] a2)
    {
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }
        int length = a1.length;
        if (a2.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            Object e1 = a1[i];
            Object e2 = a2[i];

            if (e1 == e2) {
                continue;
            }
            if (e1 == null) {
                return false;
            }

            // Figure out whether the two elements are equal
            boolean eq;
            if (e1 instanceof Object[] && e2 instanceof Object[]) {
                eq = deepEquals((Object[]) e1, (Object[]) e2);
            }
            else if (e1 instanceof byte[] && e2 instanceof byte[]) {
                eq = equals((byte[]) e1, (byte[]) e2);
            }
            else if (e1 instanceof short[] && e2 instanceof short[]) {
                eq = equals((short[]) e1, (short[]) e2);
            }
            else if (e1 instanceof int[] && e2 instanceof int[]) {
                eq = equals((int[]) e1, (int[]) e2);
            }
            else if (e1 instanceof long[] && e2 instanceof long[]) {
                eq = equals((long[]) e1, (long[]) e2);
            }
            else if (e1 instanceof char[] && e2 instanceof char[]) {
                eq = equals((char[]) e1, (char[]) e2);
            }
            else if (e1 instanceof float[] && e2 instanceof float[]) {
                eq = equals((float[]) e1, (float[]) e2);
            }
            else if (e1 instanceof double[] && e2 instanceof double[]) {
                eq = equals((double[]) e1, (double[]) e2);
            }
            else if (e1 instanceof boolean[] && e2 instanceof boolean[]) {
                eq = equals((boolean[]) e1, (boolean[]) e2);
            }
            else {
                eq = e1.equals(e2);
            }

            if (!eq) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(long)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(long[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(int)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt> is
     * <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(int[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(short)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(short[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(char)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(char[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements
     * are separated by the characters <tt>", "</tt> (a comma followed
     * by a space).  Elements are converted to strings as by
     * <tt>String.valueOf(byte)</tt>.  Returns <tt>"null"</tt> if
     * <tt>a</tt> is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(byte[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf( boolean)</tt>.  Returns <tt>"null"</tt> if
     * <tt>a</tt> is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(boolean[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(float)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(float[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
     * separated by the characters <tt>", "</tt> (a comma followed by a
     * space).  Elements are converted to strings as by
     * <tt>String.valueOf(double)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @since 1.5
     */
    public static String toString(double[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(a[0]);

        for (int i = 1; i < a.length; i++) {
            buf.append(", ");
            buf.append(a[i]);
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * If the array contains other arrays as elements, they are converted to
     * strings by the {@link Object#toString} method inherited from
     * <tt>Object</tt>, which describes their <i>identities</i> rather than
     * their contents.
     * <p/>
     * <p>The value returned by this method is equal to the value that would
     * be returned by <tt>Arrays.asList(a).toString()</tt>, unless <tt>a</tt>
     * is <tt>null</tt>, in which case <tt>"null"</tt> is returned.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @see #deepToString(Object[])
     * @since 1.5
     */
    public static String toString(Object[] a)
    {
        if (a == null) {
            return "null";
        }
        if (a.length == 0) {
            return "[]";
        }

        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                buf.append('[');
            }
            else {
                buf.append(", ");
            }

            buf.append(String.valueOf(a[i]));
        }

        buf.append("]");
        return buf.toString();
    }

    /**
     * Returns a string representation of the "deep contents" of the specified
     * array.  If the array contains other arrays as elements, the string
     * representation contains their contents and so on.  This method is
     * designed for converting multidimensional arrays to strings.
     * <p/>
     * <p>The string representation consists of a list of the array's
     * elements, enclosed in square brackets (<tt>"[]"</tt>).  Adjacent
     * elements are separated by the characters <tt>", "</tt> (a comma
     * followed  by a space).  Elements are converted to strings as by
     * <tt>String.valueOf(Object)</tt>, unless they are themselves
     * arrays.
     * <p/>
     * <p>If an element <tt>e</tt> is an array of a primitive type, it is
     * converted to a string as by invoking the appropriate overloading of
     * <tt>Arrays.toString(e)</tt>.  If an element <tt>e</tt> is an array of a
     * reference type, it is converted to a string as by invoking
     * this method recursively.
     * <p/>
     * <p>To avoid infinite recursion, if the specified array contains itself
     * as an element, or contains an indirect reference to itself through one
     * or more levels of arrays, the self-reference is converted to the string
     * <tt>"[...]"</tt>.  For example, an array containing only a reference
     * to itself would be rendered as <tt>"[[...]]"</tt>.
     * <p/>
     * <p>This method returns <tt>"null"</tt> if the specified array
     * is <tt>null</tt>.
     *
     * @param a the array whose string representation to return
     *          a string representation of <tt>a</tt>
     *
     * @see #toString(Object[])
     * @since 1.5
     */
    public static String deepToString(Object[] a)
    {
        if (a == null) {
            return "null";
        }

        int bufLen = 20 * a.length;
        if (a.length != 0 && bufLen <= 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuilder buf = new StringBuilder(bufLen);
        deepToString(a, buf, new HashSet());
        return buf.toString();
    }

    private static void deepToString(Object[] a, StringBuilder buf, Set dejaVu)
    {
        if (a == null) {
            buf.append("null");
            return;
        }
        dejaVu.add(a);
        buf.append('[');
        for (int i = 0; i < a.length; i++) {
            if (i != 0) {
                buf.append(", ");
            }

            Object element = a[i];
            if (element == null) {
                buf.append("null");
            }
            else {
                Class eClass = element.getClass();

                if (eClass.isArray()) {
                    if (eClass == byte[].class) {
                        buf.append(toString((byte[]) element));
                    }
                    else if (eClass == short[].class) {
                        buf.append(toString((short[]) element));
                    }
                    else if (eClass == int[].class) {
                        buf.append(toString((int[]) element));
                    }
                    else if (eClass == long[].class) {
                        buf.append(toString((long[]) element));
                    }
                    else if (eClass == char[].class) {
                        buf.append(toString((char[]) element));
                    }
                    else if (eClass == float[].class) {
                        buf.append(toString((float[]) element));
                    }
                    else if (eClass == double[].class) {
                        buf.append(toString((double[]) element));
                    }
                    else if (eClass == boolean[].class) {
                        buf.append(toString((boolean[]) element));
                    }
                    else { // element is an array of object references
                        if (dejaVu.contains(element)) {
                            buf.append("[...]");
                        }
                        else {
                            deepToString((Object[]) element, buf, dejaVu);
                        }
                    }
                }
                else {  // element is non-null and not an array
                    buf.append(element.toString());
                }
            }
        }
        buf.append("]");
        dejaVu.remove(a);
    }


}
