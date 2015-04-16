/****************************************************************************************
 * Copyright(c) Shanghai YiJun Network Info Technologies Inc. All right reserved.     *
 ****************************************************************************************/

package org.ccj.util;

import java.util.*;


/**
 * 跟Collection相关的方法
 *
 * @author yuanyou
 * @version 1.00 2005-2-7 15:06:51
 */
@com.googlecode.javacpp.annotation.Opaque
public class CollectionUtil
{
    public static Map newHashMap()
    {
        return new HashMap();
    }

    public static List newArrayList()
    {
        return new ArrayList();
    }

    public static List setToList(Set set)
    {
        List list = new ArrayList();

        if (set != null) {
            list.addAll(set);
        }

        return list;
    }

    public static Set listToSet(List set)
    {
        Set list = new HashSet();
        list.addAll(set);

        return list;
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source list.
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(List<V> dest, V[] src)
    {
        ArrayUtil.addAll(dest, src);
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source list.
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(Collection<V> dest, V[] src)
    {
        ArrayUtil.addAll(dest, src);
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source Iterator
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(List<V> dest, Iterator<V> src)
    {
        while (src.hasNext()) {
            dest.add(src.next());
        }
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source Iterator
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(Collection<V> dest, Iterator<V> src)
    {
        while (src.hasNext()) {
            dest.add(src.next());
        }
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source Enumeration
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(List<V> dest, Enumeration<V> src)
    {
        while (src.hasMoreElements()) {
            dest.add(src.nextElement());
        }
    }

    /**
     * Copies all of the elements from one list into another.  After the
     * operation, the index of each copied element in the destination list
     * will be identical to its index in the source list.  The destination
     * list must be at least as long as the source list.  If it is longer, the
     * remaining elements in the destination list are unaffected. <p>
     * <p/>
     * This method runs in linear time.
     *
     * @param dest The destination list.
     * @param src  The source Enumeration
     *
     * @throws IndexOutOfBoundsException     if the destination list is too small
     *                                       to contain the entire source List.
     * @throws UnsupportedOperationException if the destination list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     */
    public static <V> void copy(Collection<V> dest, Enumeration<V> src)
    {
        while (src.hasMoreElements()) {
            dest.add(src.nextElement());
        }
    }

    /**
     * 判断数组时候有效
     *
     * @param coll
     */
    public static final boolean isValid(Collection<? extends Object> coll)
    {
        return coll != null && !coll.isEmpty();
    }

    /**
     * 判断数组时候无效
     *
     * @param coll
     */
    public static final boolean isInvalid(Collection coll)
    {
        return coll == null || coll.isEmpty();
    }

    /**
     * 判断数组时候有效
     *
     * @param map
     */
    public static final boolean isValid(Map map)
    {
        return map != null && !map.isEmpty();
    }

    /**
     * 判断数组时候无效
     *
     * @param map
     */
    public static final boolean isInvalid(Map map)
    {
        return map == null || map.isEmpty();
    }

    public static <V> Set<V> emptySet()
    {
        return Collections.emptySet();
    }

    public static <V> List<V> emptyList()
    {
        return Collections.emptyList();
    }

    public static <K, V> Map<K, V> emptyMap()
    {
        return Collections.emptyMap();
    }

    /**
     * The empty list (immutable).  This list is serializable.
     */
    public static final List<? extends Object> EMPTY_LIST = Collections.EMPTY_LIST;
    public static final Set<? extends Object> EMPTY_SET = Collections.EMPTY_SET;
    public static final Map<? extends Object, ? extends Object> EMPTY_MAP = Collections.EMPTY_MAP;

    public static <V> Iterator<V> emptyIterator()
    {
        return (Iterator<V>) EMPTY_ITERATOR;
    }

    public static final Iterator EMPTY_ITERATOR = new Iterator()
    {

        /**
         * Removes from the underlying collection the last element returned by the
         * iterator (optional operation).  This method can be called only once per
         * call to <tt>next</tt>.  The behavior of an iterator is unspecified if
         * the underlying collection is modified while the iteration is in
         * progress in any way other than by calling this method.
         *
         * @throws UnsupportedOperationException if the <tt>remove</tt>
         *                                       operation is not supported by this Iterator.
         * @throws IllegalStateException         if the <tt>next</tt> method has not
         *                                       yet been called, or the <tt>remove</tt> method has already
         *                                       been called after the last call to the <tt>next</tt>
         *                                       method.
         */
        public void remove()
        {
            throw new NoSuchElementException("No such element");
        }

        /**
         * Returns <tt>true</tt> if the iteration has more elements. (In other
         * words, returns <tt>true</tt> if <tt>next</tt> would return an element
         * rather than throwing an exception.)
         *
         * @return <tt>true</tt> if the iterator has more elements.
         */
        public boolean hasNext()
        {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration.
         * @throws java.util.NoSuchElementException
         *          iteration has no more elements.
         */
        public Object next()
        {
            throw new NoSuchElementException("No such element");
        }
    };

    public static <V> ListIterator<V> emptyListIterator()
    {
        return (ListIterator<V>) emptyListIterator();
    }

    public static final ListIterator<? extends Object> EMPTY_LIST_ITERATOR = new ListIterator()
    {

        /**
         * Returns the index of the element that would be returned by a subsequent
         * call to <tt>next</tt>. (Returns list size if the list iterator is at the
         * end of the list.)
         *
         * @return the index of the element that would be returned by a subsequent
         *         call to <tt>next</tt>, or list size if list iterator is at end
         *         of list.
         */
        public int nextIndex()
        {
            return 0;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent
         * call to <tt>previous</tt>. (Returns -1 if the list iterator is at the
         * beginning of the list.)
         *
         * @return the index of the element that would be returned by a subsequent
         *         call to <tt>previous</tt>, or -1 if list iterator is at
         *         beginning of list.
         */
        public int previousIndex()
        {
            return 0;
        }

        /**
         * Removes from the underlying collection the last element returned by the
         * iterator (optional operation).  This method can be called only once per
         * call to <tt>next</tt>.  The behavior of an iterator is unspecified if
         * the underlying collection is modified while the iteration is in
         * progress in any way other than by calling this method.
         *
         * @throws UnsupportedOperationException if the <tt>remove</tt>
         *                                       operation is not supported by this Iterator.
         * @throws IllegalStateException         if the <tt>next</tt> method has not
         *                                       yet been called, or the <tt>remove</tt> method has already
         *                                       been called after the last call to the <tt>next</tt>
         *                                       method.
         */
        public void remove()
        {
            throw new NoSuchElementException("No such element");
        }

        /**
         * Returns <tt>true</tt> if the iteration has more elements. (In other
         * words, returns <tt>true</tt> if <tt>next</tt> would return an element
         * rather than throwing an exception.)
         *
         * @return <tt>true</tt> if the iterator has more elements.
         */
        public boolean hasNext()
        {
            return false;
        }

        /**
         * Returns <tt>true</tt> if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words, returns
         * <tt>true</tt> if <tt>previous</tt> would return an element rather than
         * throwing an exception.)
         *
         * @return <tt>true</tt> if the list iterator has more elements when
         *         traversing the list in the reverse direction.
         */
        public boolean hasPrevious()
        {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration.
         * @throws java.util.NoSuchElementException
         *          iteration has no more elements.
         */
        public Object next()
        {
            throw new NoSuchElementException("No such element");
        }

        /**
         * Returns the previous element in the list.  This method may be called
         * repeatedly to iterate through the list backwards, or intermixed with
         * calls to <tt>next</tt> to go back and forth.  (Note that alternating
         * calls to <tt>next</tt> and <tt>previous</tt> will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list.
         * @throws java.util.NoSuchElementException
         *          if the iteration has no previous
         *          element.
         */
        public Object previous()
        {
            throw new NoSuchElementException("No such element");
        }

        /**
         * Inserts the specified element into the list (optional operation).  The
         * element is inserted immediately before the next element that would be
         * returned by <tt>next</tt>, if any, and after the next element that
         * would be returned by <tt>previous</tt>, if any.  (If the list contains
         * no elements, the new element becomes the sole element on the list.)
         * The new element is inserted before the implicit cursor: a subsequent
         * call to <tt>next</tt> would be unaffected, and a subsequent call to
         * <tt>previous</tt> would return the new element.  (This call increases
         * by one the value that would be returned by a call to <tt>nextIndex</tt>
         * or <tt>previousIndex</tt>.)
         *
         * @param o the element to insert.
         * @throws UnsupportedOperationException if the <tt>add</tt> method is
         *                                       not supported by this list iterator.
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list.
         * @throws IllegalArgumentException      if some aspect of this element
         *                                       prevents it from being added to this list.
         */
        public void add(Object o)
        {
            throw new NoSuchElementException("No such element");
        }

        /**
         * Replaces the last element returned by <tt>next</tt> or
         * <tt>previous</tt> with the specified element (optional operation).
         * This call can be made only if neither <tt>ListIterator.remove</tt> nor
         * <tt>ListIterator.add</tt> have been called after the last call to
         * <tt>next</tt> or <tt>previous</tt>.
         *
         * @param o the element with which to replace the last element returned by
         *          <tt>next</tt> or <tt>previous</tt>.
         * @throws UnsupportedOperationException if the <tt>set</tt> operation
         *                                       is not supported by this list iterator.
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list.
         * @throws IllegalArgumentException      if some aspect of the specified
         *                                       element prevents it from being added to this list.
         * @throws IllegalStateException         if neither <tt>next</tt> nor
         *                                       <tt>previous</tt> have been called, or <tt>remove</tt> or
         *                                       <tt>add</tt> have been called after the last call to
         *                                       <tt>next</tt> or <tt>previous</tt>.
         */
        public void set(Object o)
        {
            throw new NoSuchElementException("No such element");
        }
    };

    public static <V> Enumeration<V> emptyEnum()
    {
        return (Enumeration<V>) EMPTY_ENUMERATION;
    }

    public static final Enumeration EMPTY_ENUMERATION = new Enumeration()
    {

        /**
         * Tests if this enumeration contains more elements.
         *
         * @return <code>true</code> if and only if this enumeration object
         *         contains at least one more element to provide;
         *         <code>false</code> otherwise.
         */
        public boolean hasMoreElements()
        {
            return false;
        }

        /**
         * Returns the next element of this enumeration if this enumeration
         * object has at least one more element to provide.
         *
         * @return the next element of this enumeration.
         * @throws java.util.NoSuchElementException
         *          if no more elements exist.
         */
        public Object nextElement()
        {
            throw new NoSuchElementException();
        }
    };

    /**
     * The empty map (immutable).  This map is serializable.
     *
     * @since 1.3
     */
    public static final Properties EMPTY_PROPERTIES = new EmptyProperties();

    public static class EmptyProperties
        extends Properties
    {
        public int size()
        {
            return 0;
        }

        public boolean isEmpty()
        {
            return true;
        }

        public boolean containsKey(String key)
        {
            return false;
        }

        /**
         * 是否拥有给定的值
         *
         * @param value [Object]
         */
        public boolean containsValue(Object value)
        {
            return false;
        }

        public Object get(String key)
        {
            return null;
        }

        public Object put(String key, Object value)
        {
            return null;
        }

        public Object remove(String key)
        {
            return null;
        }

        public Enumeration<Object> keys()
        {
            return emptyEnum();
        }

        public Set<Object> keySet()
        {
            return Collections.emptySet();
        }

        public Collection<Object> values()
        {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Object, Object>> entrySet()
        {
            return Collections.emptySet();
        }

        public boolean equals(Object o)
        {
            return (o instanceof Properties) && ((Properties) o).size() == 0;
        }

        public int hashCode()
        {
            return 0;
        }

        public void clear()
        {
        }
    }

    /**
     * 如果list为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param collection
     */
    public static <E> Iterator<E> iterator(Collection<E> collection)
    {
        if (isValid(collection)) {
            return collection.iterator();
        }
        else {
            return emptyIterator();
        }
    }

    /**
     * 如果list为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param en
     */
//    public static <E> Iterator<E> iterator(Enumeration<E> en)
//    {
//        if (en != null) {
//            return new EnumIterator<E>(en);
//        }
//        else {
//            return emptyIterator();
//        }
//    }

    /**
     * 将Iterator 转换成Enumeration
     *
     * @param iterator
     */
//    public static <E> Enumeration<E> toEnum(Iterator<E> iterator)
//    {
//        if (iterator != null) {
//            return new EnumIterator<E>(iterator);
//        }
//        else {
//            return emptyEnum();
//        }
//    }


    /**
     * 如果list为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param obj 对象
     */
//    public static <E> Iterator<E> iterator(E obj)
//    {
//        if (obj != null) {
//            return new SingleIterator<E>(obj);
//        }
//        else {
//            return emptyIterator();
//        }
//    }

    /**
     * 将Iterator 转换成Enumeration
     *
     * @param obj
     */
//    public static <E> Enumeration<E> toEnum(E obj)
//    {
//        if (obj != null) {
//            return new SingleIterator<E>(obj);
//        }
//        else {
//            return emptyEnum();
//        }
//    }

    /**
     * 如果vector<code>null</code>，返回<code>EMPTY_ENUMERATION</code>
     *
     * @param vector
     */
    public static <E> Enumeration<E> elements(Vector<E> vector)
    {
        if (isValid(vector)) {
            return vector.elements();
        }
        else {
            return emptyEnum();
        }
    }

    /**
     * 如果vector<code>null</code>，返回<code>EMPTY_ENUMERATION</code>
     *
     * @param coll
     */
//    public static <E> Enumeration<E> elements(Collection<E> coll)
//    {
//        if (isValid(coll)) {
//            return new EnumIterator<E>(coll.iterator());
//        }
//        else {
//            return emptyEnum();
//        }
//    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param map
     */
    public static <K> Iterator<K> keys(Map<K, ?> map)
    {
        if (isValid(map)) {
            return map.keySet().iterator();
        }
        else {
            return emptyIterator();
        }
    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param map
     */
    public static <K> Set<K> keySet(Map<K, ?> map)
    {
        if (isValid(map)) {
            return map.keySet();
        }
        else {
            return Collections.emptySet();
        }
    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ENUMERATION</code>
     *
     * @param map
     */
//    public static <K> Enumeration<K> keyEnum(Map<K, ?> map)
//    {
//        if (isValid(map)) {
//            return new EnumIterator<K>(map.keySet().iterator());
//        }
//        else {
//            return emptyEnum();
//        }
//    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param map
     */
    public static <V> Iterator<V> values(Map<?, V> map)
    {
        if (isValid(map)) {
            return map.values().iterator();
        }
        else {
            return emptyIterator();
        }
    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param map
     */
    public static <V> Collection<V> valueSet(Map<?, V> map)
    {
        if (isValid(map)) {
            return map.values();
        }
        else {
            return Collections.emptySet();
        }
    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ITERATOR</code>
     *
     * @param map
     */
    public static <K, V> Set<Map.Entry<K, V>> entrySet(Map<K, V> map)
    {
        if (isValid(map)) {
            return map.entrySet();
        }
        else {
            return Collections.emptySet();
        }
    }

    /**
     * 如果map为<code>null</code>，返回<code>EMPTY_ENUMERATION</code>
     *
     * @param map
     */
//    public static <V> Enumeration<V> valueEnum(Map<?, V> map)
//    {
//        if (isValid(map)) {
//            return new EnumIterator<V>(map.values().iterator());
//        }
//        else {
//            return emptyEnum();
//        }
//    }


    /**
     * 克隆一个给定的List对象。
     *
     * @param list 将要被克隆的List对象
     *
     * @return 克隆的List对象。
     */
    public static <V> List<V> clone(List<V> list)
    {
        if (list == null) {
            return list;
        }
        Class clazz = list.getClass();
        if (clazz == Vector.class) {
            return (List<V>) ((Vector) list).clone();
        }
        else if (clazz == ArrayList.class) {
            return (List<V>) ((ArrayList) list).clone();
        }
        else if (list instanceof Cloneable) {
        }
        else {
            try {
                List<V> cloned = (List<V>) clazz.newInstance();
                cloned.addAll(list);
                return cloned;
            }
            catch (InstantiationException e) {
                throw new IllegalArgumentException("Can't create list:" + e.getMessage());
            }
            catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Can't create list:" + e.getMessage());
            }
        }
        return list;
    }

    /**
     * 克隆一个给定的Map对象。
     *
     * @param map 需要克隆的对象
     *
     * @return 克隆的对
     */
    public static <K, V> Map<K, V> clone(Map<K, V> map)
    {
        if (map == null) {
            return map;
        }

        Class clazz = map.getClass();
        if (clazz == Hashtable.class) {
            return (Map<K, V>) ((Hashtable<K, V>) map).clone();
        }
        else if (clazz == HashMap.class) {
            return (Map<K, V>) ((HashMap<K, V>) map).clone();
        }
        else if (map instanceof Cloneable) {
//            return (Map<K, V>)Reflection.invoke(map, "clone");
        }
        else {
            try {
                Map<K, V> cloned = (Map<K, V>) clazz.newInstance();
                cloned.putAll(map);
                return cloned;
            }
            catch (InstantiationException e) {
                throw new IllegalArgumentException("Can't create map:" + e.getMessage());
            }
            catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Can't create map:" + e.getMessage());
            }
        }
        return map;
    }

    /**
     * Sorts the specified list according to the order induced by the
     * specified comparator.  All elements in the list must be <i>mutually
     * comparable</i> using the specified comparator (that is,
     * <tt>c.compare(e1, e2)</tt> must not throw a <tt>ClassCastException</tt>
     * for any elements <tt>e1</tt> and <tt>e2</tt> in the list).<p>
     * <p/>
     * This sort is guaranteed to be <i>stable</i>:  equal elements will
     * not be reordered as a result of the sort.<p>
     * <p/>
     * The sorting algorithm is a modified mergesort (in which the merge is
     * omitted if the highest element in the low sublist is less than the
     * lowest element in the high sublist).  This algorithm offers guaranteed
     * n log(n) performance, and can approach linear performance on nearly
     * sorted lists.<p>
     * <p/>
     * The specified list must be modifiable, but need not be resizable.
     * This implementation dumps the specified list into an array, sorts
     * the array, and iterates over the list resetting each element
     * from the corresponding position in the array.  This avoids the
     * n<sup>2</sup> log(n) performance that would result from attempting
     * to sort a linked list in place.
     *
     * @param list the list to be sorted.
     * @param c    the comparator to determine the order of the list.  A
     *             <tt>null</tt> value indicates that the elements' <i>natural
     *             ordering</i> should be used.
     *
     * @throws ClassCastException            if the list contains elements that are not
     *                                       <i>mutually comparable</i> using the specified comparator.
     * @throws UnsupportedOperationException if the specified list's
     *                                       list-iterator does not support the <tt>set</tt> operation.
     * @see java.util.Comparator
     */
    public static <T> void sort(List<T> list, Comparator<? super T> c)
    {
        if (list == null) {
            return;
        }
        Collections.sort(list, c);
    }

    public static <T> Collection sort(Collection<T> list, Comparator<? super T> c)
    {
        if (list == null) {
            return null;
        }
        ArrayList tmp = new ArrayList();
        tmp.addAll(list);
        Collections.sort(tmp, c);
        return tmp;
    }


    /**
     * 把一个List的指定项拷贝到另外一个List中。
     *
     * @param dest   目的列表
     * @param src    源列表
     * @param offset 拷贝的偏移量
     * @param length 拷贝想的长度.
     *
     * @return 实际拷贝项的数量。
     */
    public static <V> int copy(List<V> dest, List<V> src, int offset, int length)
    {
        int size = src.size();
        size = size > offset + length ? offset + length : size;
        int i = offset;
        for (; i < size; i++) {
            dest.add(src.get(i));
        }
        return i;
    }
}
