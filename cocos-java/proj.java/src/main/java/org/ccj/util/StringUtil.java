/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串处理工具类
 *
 * @author yuanyou
 * @version 1.00 2005-2-5 21:01:09
 */
//@Named
@com.googlecode.javacpp.annotation.Opaque
public class StringUtil
{
    public static final String NULL = "null";
    public static final char[] NULL_CHARS = NULL.toCharArray();
    /**
     * 空的字符串数
     */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * 空的字符
     */
    public static final String EMPTY_STRING = "";

    /**
     * Check if the string value is valid
     *
     * @param value
     */
    public static final boolean isValid(String value)
    {
        return value != null && value.length() > 0;
    }

    public static final boolean isInvalidInput(String value)
    {
        return !isValidInput(value);
    }

    public static final boolean isValidInput(String value)
    {
        if (isValid(value)) {
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                    return false;
                }
            }
        }
        return false;
    }

    public static final String urlDecode(String value)
    {
        try {
            return URLDecoder.decode(value, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static final String urlDecode(String value, String enc)
    {
        try {
            return URLDecoder.decode(value, enc);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }


    public static final String urlEncode(String value)
    {
        try {
            return URLEncoder.encode(value, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static final String urlEncode(String value, String enc)
    {
        try {
            return URLEncoder.encode(value, enc);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }


    public static final String plusString(String... value)
    {
        StringBuffer buf = new StringBuffer();
        for (String s : value) {
            buf.append(s);
        }
        return buf.toString();
    }

    public static final boolean contains(String value, String s)
    {
        if (StringUtil.isValid(value) && StringUtil.isValid(s)) {
            return value.indexOf(s) >= 0;
        }
        return false;
    }


    private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    public static boolean isEmailAddress(String email)
    {

        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

    public static boolean isPhoneNumber(String phone)
    {
        Pattern pattern = Pattern.compile("^13/d{9}||15[8,9]/d{8}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Check if the string value is invalid
     *
     * @param value
     */
    public static final boolean isInvalid(String value)
    {
        return value == null || value.length() == 0;
    }

//    /**
//     * Return string value from an object
//     * (String String[0] object.toString)
//     *
//     * @param object
//     */
//    public static final String getString(Object object)
//    {
//        return DataUtil.getString(object, null);
//    }
//
//    /**
//     * 将对象格式化成字符串
//     *
//     * @param object   对象
//     * @param defValue 默认字符
//     */
//    public static final String getString(Object object, String defValue)
//    {
//        return DataUtil.getString(object, defValue);
//    }
//
//    /**
//     * 根据对象返回字符串数.
//     *
//     * @param object 对象
//     *
//     * @return 对象返回字符串数
//     */
//    public static final String[] getStringArray(Object object)
//    {
//        return DataUtil.getStringArray(object);
//    }

    /**
     * 比较两个字符串是否相.
     * <p/>
     * 如果 str1 == str2 == null return true
     *
     * @param str1 字符
     * @param str2 字符
     *
     * @return [true|false] 是否相等
     */
    public static final boolean equals(String str1, String str2)
    {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    public static String getFirstCharLower(String name)
    {
        if (StringUtil.isValid(name)) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(Character.toLowerCase(name.charAt(0)));
            buffer.append(name.substring(1));
            return buffer.toString();
        }
        return name;
    }

    public static String getFirstCharUpper(String name)
    {
        if (StringUtil.isValid(name)) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(Character.toUpperCase(name.charAt(0)));
            buffer.append(name.substring(1));
            return buffer.toString();
        }
        return name;
    }

    /**
     * 比较两个字符串是否相等（忽略大小写）
     * <p/>
     * <p/>
     * 如果 str1 == str2 == null return true
     *
     * @param str1 字符
     * @param str2 字符
     *
     * @return [true|false] 是否相等
     */
    public static final boolean equalsIgnoreCase(String str1,
                                                 String str2)
    {
        if (str1 == null) {
            return str2 == null;
        }
        return str1.equalsIgnoreCase(str2);
    }

    /**
     * 返回字符串的哈希
     *
     * @param str 字符
     *
     * @return <code>str.hashCode</code> 如果对象code>null</code> 返回<code>0</codeL
     */
    public static final int hashCode(String str)
    {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /**
     * 忽略大小写产生的Hash代码
     *
     * @param str
     *
     * @return Hash代码
     */
    public static final int hashCodeIgnoreCase(String str)
    {
        if (str == null) {
            return 0;
        }
        int len = str.length();
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = 31 * hash + Character.toLowerCase(str.charAt(i));
        }
        return hash;
    }

    public static final String[] toStringLines(String src)
    {
        return toStringArray(src, '\n');
    }

    /**
     * 根据分隔符将字符串分成字符串数组
     *
     * @param src 字符
     * @param sep 分隔
     *
     * @return 如果<code>src == null</code>返回<code>null</code>
     * 如果<code>src == ""</code> 返回<code>#EMPTY_STRING_ARRAY</code>
     */
    public static final String[] toStringArray(String src, char sep)
    {
        if (src == null) {
            return new String[0];
        }
        int length = src.length();
        if (length == 0) {
            return EMPTY_STRING_ARRAY;
        }

        int count = countChar(src, sep);
        String[] array = new String[count + 1];
        int begin = 0;
        int end = 0;
        for (int i = 0; i <= count; i++) {
            end = src.indexOf(sep, begin);
            if (end == -1) {
                array[i] = begin == length ? "" : src.substring(begin);
                break;
            }
            else {
                array[i] = src.substring(begin, end);
                begin = end + 1;
            }
        }
        return array;
    }

    /**
     * 根据分隔符将字符串分成字符串数组
     *
     * @param src    字符
     * @param sep    分隔
     * @param ignore 是否忽略空的字符
     *
     * @return 如果<code>src == null</code>返回<code>null</code>
     * 如果<code>src == ""</code> 返回<code>#EMPTY_STRING_ARRAY</code>
     */
    public static final String[] toStringArray(String src, char sep, boolean ignore)
    {
        String[] array = toStringArray(src, sep);
        if (ignore && ArrayUtil.isValid(array)) {
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (StringUtil.isValid(array[i])) {
                    array[j++] = array[i];
                }
            }
            if (j < array.length) {
                String[] newArray = new String[j];
                System.arraycopy(array, 0, newArray, 0, j);
                array = newArray;
            }
        }
        return array;
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(String[] array, int off,
                                        int len, char sep)
    {
        return toString((Object[]) array, off, len, sep);
    }

    /**
     * 将对象数组变成字符串
     *
     * @param array 对象数组
     * @param sep   分隔
     *
     * @return 字符
     */
    public static final String toString(Object[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(Object[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }

        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(String[] strs, char sep)
    {
        if (strs == null) {
            return null;
        }
        return toString(strs, 0, strs.length, sep);
    }

    public static final String toString(Collection<String> strs, char sep)
    {
        if (strs == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (String s : strs) {
            if (buffer.length() > 0) {
                buffer.append(sep);
            }
            buffer.append(s);
        }
        return buffer.toString();
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(boolean[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }

        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(boolean[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(byte[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(byte[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

//    public static final String toString(Collection collection, char sep)
//    {
//        StringBuffer buffer = new StringBuffer();
//        for (Object obj : collection) {
//            if (buffer.length() > 0) {
//                buffer.append(sep);
//            }
//            buffer.append(obj.toString());
//        }
//        return buffer.toString();
//    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(char[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(char[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(int[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(int[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(long[] array, int off,
                                        int len, char sep)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
            return String.valueOf(array[off]);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(array[off]);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
                sb.append(array[i]);
            }
            return sb.toString();
        }
    }

    public static final String toString(long[] array, char sep)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(float[] array, int off,
                                        int len, char sep, int fraction)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
//            return NumberFormat.format(array[off], fraction);
        }
        else {
            StringBuilder sb = new StringBuilder();
//            NumberFormat.format(sb, array[off], fraction);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
//                NumberFormat.format(sb, array[i], fraction);
            }
            return sb.toString();
        }
        return null;
    }

    public static final String toString(float[] array, char sep, int fraction)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep, fraction);
    }

    /**
     * 将字符串数组组合成字符串，每个元素间用分隔符隔开
     *
     * @param array 字符
     * @param off   起始位置
     * @param len   长度
     * @param sep   分隔
     *
     * @return 如果<code>array == null</code>返回<code>null</code>
     * 如果<code>len - off == 0<code> 返回<code>#EMPTY_STRING</code>
     *
     * @throws ArrayIndexOutOfBoundsException 如果off或len提供的位置出
     * @see #toStringArray(String, char)
     */
    public static final String toString(double[] array, int off,
                                        int len, char sep, int fraction)
    {
        if (array == null) {
            return null;
        }

        if (off < 0) {
            throw new ArrayIndexOutOfBoundsException("Off=" + off);
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("Len=" + len);
        }
        int end = off + len;
        if (end > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid off=" + off + " or len=" + len
                + " array length=" + array.length);
        }

        if (len == 0) {
            return EMPTY_STRING;
        }
        else if (len == 1) {
//            return NumberFormat.format(array[off], fraction);
        }
        else {
            StringBuilder sb = new StringBuilder();
//            NumberFormat.format(sb, array[off], fraction);
            for (int i = off + 1; i < end; i++) {
                sb.append(sep);
//                NumberFormat.format(sb, array[i], fraction);
            }
            return sb.toString();
        }
        return null;
    }

    public static final String toString(double[] array, char sep, int fraction)
    {
        if (array == null) {
            return null;
        }
        return toString(array, 0, array.length, sep, fraction);
    }

    public static final String toString(byte[] bytes, int off, int len, String encoding)
    {
        String result = null;
        if (bytes == null) {
            return null;
        }
        else if (encoding == null) {
            result = new String(bytes, off, len);
        }
        else {
            try {
                result = new String(bytes, off, len, encoding);
            }
            catch (Exception e) {
                result = new String(bytes, off, len);
            }
        }
        return result;
    }

    public static final String toString(byte[] bytes, String encoding)
    {
        if (bytes == null) {
            return null;
        }
        return toString(bytes, 0, bytes.length, encoding);
    }

    public static final String toString(byte[] bytes)
    {
        return toString(bytes, null);
    }

    public static final byte[] toBytes(String str)
    {
        return toBytes(str, null);
    }

    public static final byte[] toBytes(String str, String encoding)
    {
        byte[] bytes = null;
        if (str == null) {
            return null;
        }
        else if (str.length() == 0) {
            return new byte[0];
        }
        else if (encoding == null) {
            bytes = str.getBytes();
        }
        else {
            try {
                bytes = str.getBytes(encoding);
            }
            catch (Exception e) {
                bytes = str.getBytes();
            }
        }
        return bytes;
    }

    /**
     * Separate the string to array
     * if src == null return null;
     * ""     --> {0}
     * ",1,2" --> {0, 1, 2}
     * "1,,2," --> {1,0,2,0}
     * "a,1,2," --> null (Exception)
     */
    public static final int[] toIntArray(String src, char sep)
    {
        if (src == null) {
            return null;
        }
        int length = src.length();
        if (length == 0) {
            return new int[]{0};
        }

        int count = countChar(src, sep);
        int[] array = new int[count + 1];
        int i = 0;  //index of array
//        int begin = 0;
        int value = 0;
        boolean neg = false;
        int index = 0; //index of src
        char c = 0;
        while (index < length) {
            c = src.charAt(index);
            if (isDigit(c)) {
                value = 10 * value + (c - '0');
            }
            else if (c == sep) {
                array[i++] = neg ? -value : value;
                value = 0;
                neg = false;
            }
            else if (c == '-') {
                if (value == 0) {
                    neg = true;
                }
                else {
                    //格式错误，返
                    return null;
                }
            }
            else if (c == ' ' || c == '\t') {
                index++;
                continue;
            }
            else {
                return null;
            }
            index++;
        }
        array[i] = neg ? -value : value;
        return array;
    }

    private static boolean isDigit(char c)
    {
        return false;
    }

    public static final int[] toIntArray(String[] src)
    {
        if (ArrayUtil.isValid(src)) {
            int[] result = new int[src.length];
            for (int i = 0; i < src.length; i++) {
                result[i] = Integer.valueOf(src[i]);
            }
            return result;
        }
        return new int[0];
    }


    public static final Integer[] toIntegerArray(String[] src)
    {
        if (ArrayUtil.isInvalid(src)) {
            return new Integer[0];
        }

        Integer[] result = new Integer[src.length];
        for (int i = 0; i < src.length; i++) {
            result[i] = Integer.valueOf(src[i]);
        }
        return result;
    }

    /**
     * Return the count of the char in the String
     * if src == null return -1;
     * if src.length() == 0 return 0;
     */
    public static final int countChar(String src, char c)
    {
        if (src == null) {
            return -1;
        }
        int length = src.length();
        if (length == 0) {
            return 0;
        }

        int count = 0;
        int ch = 0;
        for (int i = 0; i < length; i++) {
            ch = src.charAt(i);
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static String replaceWrapToHtml(String text)
    {
        return replace(text, '\n', "<br/>");
    }

    /**
     * use specific string to replace specific char
     */
    public static final String replace(String str, char src, String dst)
    {
        if (isInvalid(str)) {
            return str;
        }
        if (dst == null) {
            throw new IllegalArgumentException("Null destination string");
        }

        int strLen = str.length();
        int size = strLen + (strLen / 20) * dst.length() + 20;

        StringBuilder sb = new StringBuilder(size);
        int offset = 0;
        int index = 0;
        while (offset < strLen && (index = str.indexOf((int) src, offset)) != -1) {
            sb.append(str.substring(offset, index));
            sb.append(dst);
            offset = ++index;
        }
        if (offset < strLen) {
            sb.append(str.substring(offset));
        }
        return sb.toString();
    }

    public static final String replace(String str, String src, String dst)
    {
        if (isInvalid(str)) {
            return str;
        }
        if (isInvalid(src)) {
            throw new IllegalArgumentException("Invalid source string:" + src);
        }
        if (dst == null) {
            throw new IllegalArgumentException("Invalid destination string:" + dst);
        }

        int srcLen = src.length();
        if (srcLen == 1) {
            return replace(str, src.charAt(0), dst);
        }


        int strLen = str.length();
        StringBuilder sb = new StringBuilder(strLen);
        int offset = 0;
        int index = 0;

        while (offset < strLen && (index = str.indexOf(src, offset)) != -1) {
            sb.append(str.substring(offset, index));
            sb.append(dst);
            offset = index + srcLen;
        }
        if (offset < strLen) {
            sb.append(str.substring(offset));
        }
        return sb.toString();
    }

    /**
     * 替换字符
     *
     * @param str 字符
     * @param src
     * @param dst
     *
     * @return 字符
     */
    public static final String replace(String str, char[] src, String[] dst)
    {
        if (isInvalid(str)) {
            return str;
        }
        if (ArrayUtil.isInvalid(src)) {
            throw new IllegalArgumentException("Invalid source string:" + src);
        }
        if (dst == null) {
            throw new IllegalArgumentException("Invalid destination string:" + dst);
        }
        if (src.length != dst.length) {
            throw new IllegalArgumentException("Not same size of two arrays, source:"
                + src + " destination:" + dst);
        }

        if (src.length == 1) {
            return replace(str, src[0], dst[0]);
        }

        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 64);

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int matched = -1;
            for (int j = 0; j < src.length; j++) {
                if (c == src[j]) {
                    matched = j;
                    break;
                }
            }
            if (matched >= 0) {
                sb.append(dst[matched]);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否以指定的字符开
     *
     * @param str 字符
     * @param ch  字符
     *
     * @return 是否以指定的字符��
     */
    public static final boolean startsWith(String str, char ch)
    {
        return isValid(str) && str.charAt(0) == ch;
    }

    /**
     * 判断字符串是否以指定的字符结
     *
     * @param str 字符
     * @param ch  字符
     *
     * @return 是否以指定的字符结束
     */
    public static final boolean endsWith(String str, char ch)
    {
        return isValid(str) && str.charAt(str.length() - 1) == ch;
    }

    private static final Locale DEFAULT = Locale.getDefault();

    /**
     * 将字符串转换成大由于JDK(<=1.3)自身的toUpperCase效率较低)
     *
     * @param str
     *
     * @return 大写
     */
    public static final String toUpperCase(String str)
    {
        return toUpperCase(str, DEFAULT);
    }

    /**
     * 将字符串转换成大由于JDK(<=1.3)自身的toUpperCase效率较低)
     *
     * @param str
     * @param locale
     *
     * @return 大写
     */
    public static final String toUpperCase(String str, Locale locale)
    {
        if (isInvalid(str)) {
            return str;
        }
        int len = str.length();
//        if (len > CharBufferPool.DEFAULT_BUFFER_SIZE) {
        return str.toUpperCase(locale);
//        }
//        else {
//            return toUpperCase(str, len, locale);
//        }
    }


    private static String toUpperCase(String str, int len, Locale locale)
    {
        CharBuffer buffer = null;
        char[] val = buffer.array();
        str.getChars(0, len, val, 0);
        int firstLower;
        /* Now check if there are any characters that need changing. */
        scan:
        {
            for (firstLower = 0; firstLower < len; firstLower++) {
                char c = val[firstLower];
                if (Character.isLowerCase(c)) {
                    break scan;
                }
            }
            return str;
        }

        /* val grows, so i+resultOffset * is the write location in val */
        if (locale.getLanguage().equals("tr")) {
            // special loop for Turkey
            for (int i = firstLower; i < len; ++i) {
                char ch = val[i];
                if (ch == 'i') {
                    val[i] = '\u0130';  // dotted cap i
                    continue;
                }
                if (ch == '\u0131') {                   // dotless i
                    val[i] = 'I';       // cap I
                    continue;
                }
                val[i] = Character.toUpperCase(ch);
            }
        }
        else {
            // normal, fast loop
            for (int i = firstLower; i < len; ++i) {
                char ch = val[i];
                val[i] = Character.toUpperCase(ch);
            }
        }
        String newStr = new String(val, 0, len);
        return newStr;
    }

    /**
     * 返回字符数组
     *
     * @param text          文本
     * @param caseSensitive 大小写敏
     *
     * @return 字符数组
     */
    public static final char[] toCharArray(String text, boolean caseSensitive)
    {
        if (text == null) {
            return new char[0];
        }
        if (caseSensitive) {
            return text.toCharArray();
        }
        else {
            return text.toUpperCase().toCharArray();
        }
    }

    /**
     * 将字符串转换成小由于JDK(<=1.3)自身的toUpperCase效率较低)
     *
     * @param str
     *
     * @return 小写
     */
    public static final String toLowerCase(String str)
    {
        return toLowerCase(str, DEFAULT);
    }


    public static String trim(String str)
    {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    /**
     * 将字符串转换成小由于JDK(<=1.3)自身的toUpperCase效率较低)
     *
     * @param str
     * @param locale
     *
     * @return 小写
     */
    public static final String toLowerCase(String str, Locale locale)
    {
        if (isInvalid(str)) {
            return str;
        }
        int len = str.length();
//        if (len > CharBufferPool.DEFAULT_BUFFER_SIZE) {
//            return str.toLowerCase(locale);
//        }
//        else {
        return toLowerCase(str, len, locale);
//        }
    }

    /**
     * @param str
     * @param len
     * @param locale
     *
     * @return 小写
     */
    private static final String toLowerCase(String str, int len, Locale locale)
    {
        CharBuffer buffer = null;
        char[] val = buffer.array();
        str.getChars(0, len, val, 0);
        int firstUpper;
        /* Now check if there are any characters that need changing. */
        scan:
        {
            for (firstUpper = 0; firstUpper < len; firstUpper++) {
                char c = val[firstUpper];
                if (Character.isUpperCase(c)) {
                    break scan;
                }
            }
            return str;
        }

        if (locale.getLanguage().equals("tr")) {
            // special loop for Turkey
            for (int i = firstUpper; i < len; ++i) {
                char ch = val[i];
                if (ch == 'I') {
                    val[i] = '\u0131'; // dotless small i
                    continue;
                }
                if (ch == '\u0130') {       // dotted I
                    val[i] = 'i';      // dotted i
                    continue;
                }
                val[i] = Character.toLowerCase(ch);
            }
        }
        else {
            // normal, fast loop
            for (int i = firstUpper; i < len; ++i) {
                val[i] = Character.toLowerCase(val[i]);
            }
        }
        String newStr = new String(val, 0, len);
        return newStr;
    }


    /**
     * Checks whether the String contains only digit characters.
     * Null and blank string will return false.
     *
     * @param str the string to check
     *
     * @return boolean contains only unicode numeric
     */
    public static final boolean isDigits(String str)
    {
        if (isInvalid(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将List转成String[]
     *
     * @param list
     *
     * @return String[]
     */
    public static final String[] toStringArray(List<String> list)
    {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return EMPTY_STRING_ARRAY;
        }
        String[] array = new String[size];
        list.toArray(array);
        return array;
    }

    /**
     * 判断是不是完全属859_1字符集的字符
     *
     * @param str 字符
     */
    public static final boolean isISO88591(String str)
    {
        if (isInvalid(str)) {
            return true;
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            if (!isISO88591(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是完全属859_1字符集的字符
     *
     * @param chars 字符
     */
    public static final boolean isISO88591(char[] chars)
    {
        if (ArrayUtil.isInvalid(chars)) {
            return true;
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!isISO88591(chars[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是完全属859_1字符集的字符
     *
     * @param ch 字符
     */
    public static boolean isISO88591(char ch)
    {
        return ch <= '\u00FF';
    }

    /**
     * 判断是不是完全属于ASCII
     *
     * @param str 字符
     */
    public static boolean isAscii(String str)
    {
        if (isInvalid(str)) {
            return true;
        }

        for (int i = 0, len = str.length(); i < len; i++) {
            if (str.charAt(i) >= 0x80) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是完全属于ASCII
     *
     * @param chars 字符
     */
    public static boolean isAscii(char[] chars)
    {
        if (ArrayUtil.isInvalid(chars)) {
            return true;
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] >= 0x80) {
                return false;
            }
        }
        return true;
    }


    /**
     * 字符串转化为其他的字符集形式<br>
     * 如果异常返回原来的字符串<br>
     * 这个方法只合于"8859_1"的数据跟其它字符集的还原操作<br>
     *
     * @param string 字符
     * @param from   源字符集
     * @param to     目标字符
     */
    public static String convert(String string,
                                 String from,
                                 String to)
    {
        if (isInvalid(string)) {
            return string;
        }
        if (isInvalid(from)) {
//            from = Charset.getFileEncoding();
        }
        if (isInvalid(to)) {
//            to = Charset.getFileEncoding();
        }
        try {
            byte[] bytes = null;
            if (isInvalid(from)) {
                bytes = string.getBytes();
            }
            else {
                bytes = string.getBytes(from);
            }

            String str = null;
            if (isInvalid(to)) {
                str = new String(bytes);
            }
            else {
                str = new String(bytes, to);
            }

            return str;
        }
        catch (Exception e) {
            return string;
        }
    }

    /**
     * 从字符s后开始截取str
     *
     * @param str 源字符串
     * @param s   截取��
     *
     * @return 目标字符
     */
    public static String getAfterByStr(String str, String s)
    {
        return str.substring(str.lastIndexOf(s) + 1);
    }


    /**
     * 把字符中的，空格，回车，制表修剪
     *
     * @param str 源字符串
     *
     * @return 去掉空格、回车制表位的字符
     */
    public String trimString(String str)
    {
        if (!isValid(str)) {
            return str;
        }
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        String str2 = m.replaceAll("");
        return str2;
    }


}
