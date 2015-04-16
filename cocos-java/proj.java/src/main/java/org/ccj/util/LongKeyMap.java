package org.ccj.util;

import java.io.Serializable;
import java.util.*;

import org.ccj.Logger;


/**
 */
public class LongKeyMap implements Serializable, Cloneable
{
    /**
     * Null Key
     */
    public static final long NULL = Long.MIN_VALUE + 1;

    private transient Entry table[];

    private transient int count;

    private int threshold;

    private float loadFactor;

    private transient int modCount = 0;

    public LongKeyMap(int initialCapacity, float loadFactor)
    {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Initial Capacity: " +
                                               initialCapacity);
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal Load factor: " +
                                               loadFactor);
        }
        if (initialCapacity == 0) {
            initialCapacity = 1;
        }
        this.loadFactor = loadFactor;
        table = new Entry[initialCapacity];
        threshold = (int)(initialCapacity * loadFactor);
    }

    public LongKeyMap(int initialCapacity)
    {
        this(initialCapacity, 0.75f);
    }

    public LongKeyMap()
    {
        this(11, 0.75f);
    }

    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean containsValue(Object value)
    {
        Entry tab[] = table;

        if (value == null) {
            for (int i = tab.length; i-- > 0;) {
                for (Entry e = tab[i]; e != null; e = e.next) {
                    if (e.value == null) {
                        return true;
                    }
                }
            }
        }
        else {
            for (int i = tab.length; i-- > 0;) {
                for (Entry e = tab[i]; e != null; e = e.next) {
                    if (value.equals(e.value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean containsKey(long key)
    {
        Entry tab[] = table;
        if (key != NULL) {
            int index = (int)(key & 0x7FFFFFFF) % tab.length;
            for (Entry e = tab[index]; e != null; e = e.next) {
                if (key == e.key) {
                    return true;
                }
            }
        }
        else {
            for (Entry e = tab[0]; e != null; e = e.next) {
                if (e.key == NULL) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(long key)
    {
        Entry tab[] = table;

        if (key >0) {
            int index = (int)(key & 0x7FFFFFFF) % tab.length;
            for (Entry e = tab[index]; e != null; e = e.next) {
                if (key == e.key) {
                    return e.value;
                }
            }
        }
        return null;
    }

    private void rehash()
    {
        int oldCapacity = table.length;
        Entry oldMap[] = table;

        int newCapacity = oldCapacity * 2 + 1;
        Entry newMap[] = new Entry[newCapacity];

        modCount++;
        threshold = (int)(newCapacity * loadFactor);
        table = newMap;

        for (int i = oldCapacity; i-- > 0;) {
            for (Entry old = oldMap[i]; old != null;) {
                Entry e = old;
                old = old.next;
                int index = (int)(e.key & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }

    public Object put(long key, Object value)
    {
        // Makes sure the key is not already in the LongKeyMap.
        Entry tab[] = table;
        int index = 0;

        if (key >0) {
            index = (int)(key & 0x7FFFFFFFL) % tab.length;
            for (Entry e = tab[index]; e != null; e = e.next) {
                if ((key == e.key)) {
                    Object old = e.value;
                    e.value = value;
                    return old;
                }
            }
        }

        modCount++;
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            index = (int)(key & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        Entry e = getFree();
        e.init(key, value, tab[index]);

        tab[index] = e;
        count++;
        return null;
    }

    /**
     * Removes the mapping for this key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map.
     * @return previous value associated with specified key, or <tt>null</tt>
     *         if there was no mapping for key.  A <tt>null</tt> return can
     *         also indicate that the map previously associated <tt>null</tt>
     *         with the specified key.
     */
    public Object remove(long key)
    {
        Entry tab[] = table;

        if (key != NULL) {
            int index = (int)(key & 0x7FFFFFFF) % tab.length;
            for (Entry e = tab[index], prev = null; e != null;
                 prev = e, e = e.next) {
                if (e.key == key) {
                    modCount++;
                    if (prev != null) {
                        prev.next = e.next;
                    }
                    else {
                        tab[index] = e.next;
                    }

                    count--;
                    Object oldValue = e.value;
                    //e.value = null;
                    recycle(e);
                    return oldValue;
                }
            }
        }
        else {
            for (Entry e = tab[0], prev = null; e != null;
                 prev = e, e = e.next) {
                if (e.key == NULL) {
                    modCount++;
                    if (prev != null) {
                        prev.next = e.next;
                    }
                    else {
                        tab[0] = e.next;
                    }

                    count--;
                    Object oldValue = e.value;
                    //e.value = null;
                    recycle(e);
                    return oldValue;
                }
            }
        }

        return null;
    }

    /**
     * Copies all of the mappings from the specified map to this one.
     * <p/>
     * These mappings replace any mappings that this map had for any of the
     * keys currently in the specified Map.
     *
     * @param t Mappings to be stored in this map.
     */
    public void putAll(LongKeyMap t)
    {
        Iterator i = t.entrySet().iterator();
        while (i.hasNext()) {
            LongKeyMap.Entry e = (LongKeyMap.Entry)i.next();
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Removes all mappings from this map.
     */
    public void clear()
    {
        Entry tab[] = table;
        modCount++;
        for (int index = tab.length; --index >= 0;) {
            tab[index] = null;
        }
        count = 0;
    }

    /**
     * Returns a shallow copy of this <tt>LongKeyMap</tt> instance: the keys and
     * values themselves are not cloned.
     *
     * @return a shallow copy of this map.
     */
    public Object clone()
    {
        try {
            LongKeyMap t = (LongKeyMap)super.clone();
            t.table = new Entry[table.length];
            for (int i = table.length; i-- > 0;) {
                t.table[i] = (table[i] != null)
                             ? (Entry)table[i].clone() : null;
            }
            t.keySet = null;
            t.entrySet = null;
            t.values = null;
            t.modCount = 0;
            return t;
        }
        catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    // Views

    private transient Set keySet = null;
    private transient Set entrySet = null;
    private transient Collection values = null;

    /**
     * Returns a set view of the keys contained in this map.  The set is
     * backed by the map, so changes to the map are reflected in the set, and
     * vice-versa.  The set supports element removal, which removes the
     * corresponding mapping from this map, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt>, and
     * <tt>clear</tt> operations.  It does not support the <tt>add</tt> or
     * <tt>addAll</tt> operations.
     *
     * @return a set view of the keys contained in this map.
     */
    public Set keySet()
    {
        if (keySet == null) {
            keySet = new AbstractSet()
            {
                public Iterator iterator()
                {
                    return getHashIterator(KEYS);
                }

                public int size()
                {
                    return count;
                }

                public boolean contains(int key)
                {
                    return containsKey(key);
                }

                public boolean remove(int key)
                {
                    int oldSize = count;
                    LongKeyMap.this.remove(key);
                    return count != oldSize;
                }

                public void clear()
                {
                    LongKeyMap.this.clear();
                }
            };
        }
        return keySet;
    }

    public Collection values()
    {
        if (values == null) {
            values = new AbstractCollection()
            {
                public Iterator iterator()
                {
                    return getHashIterator(VALUES);
                }

                public int size()
                {
                    return count;
                }

                public boolean contains(Object o)
                {
                    return containsValue(o);
                }

                public void clear()
                {
                    LongKeyMap.this.clear();
                }
            };
        }
        return values;
    }

    public Set entrySet()
    {
        if (entrySet == null) {
            entrySet = new AbstractSet()
            {
                public Iterator iterator()
                {
                    return getHashIterator(ENTRIES);
                }

                public boolean contains(Object o)
                {
                    if (!(o instanceof LongKeyMap.Entry)) {
                        return false;
                    }
                    LongKeyMap.Entry entry = (LongKeyMap.Entry)o;
                    long key = entry.getKey();
                    Entry tab[] = table;
                    int index = (int)(key & 0x7FFFFFFF) % tab.length;

                    for (Entry e = tab[index]; e != null; e = e.next) {
                        if (e.key == key && e.equals(entry)) {
                            return true;
                        }
                    }
                    return false;
                }

                public boolean remove(Object o)
                {
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry)o;
                    Object key = entry.getKey();
                    Entry tab[] = table;
                    int hash = (key == null ? 0 : key.hashCode());
                    int index = (hash & 0x7FFFFFFF) % tab.length;

                    for (Entry e = tab[index], prev = null; e != null;
                         prev = e, e = e.next) {
                        if (e.key == hash && e.equals(entry)) {
                            modCount++;
                            if (prev != null) {
                                prev.next = e.next;
                            }
                            else {
                                tab[index] = e.next;
                            }

                            count--;
                            e.value = null;
                            return true;
                        }
                    }
                    return false;
                }

                public int size()
                {
                    return count;
                }

                public void clear()
                {
                    LongKeyMap.this.clear();
                }
            };
        }

        return entrySet;
    }

    private Iterator getHashIterator(int type)
    {
        if (count == 0) {
            return emptyHashIterator;
        }
        else {
            return new HashIterator(type);
        }
    }

    //Free Head
    private static Entry free = new Entry();

    private static Entry getFree()
    {
        synchronized (free) {
            if (free.next == null) {
                return new Entry();
            }
            else {
                Entry entry = free.next;
                free.next = entry.next;
                entry.next = null;
                return entry;
            }
        }
    }

    private static void recycle(Entry entry)
    {
        synchronized (free) {
            entry.recycle();
            entry.next = free.next;
            free.next = entry;
        }
    }

    public static void initEntries(int size)
    {
        for (int i = 0; i < size; i++) {
            recycle(new Entry());
        }
    }


    /**
     * LongKeyMap collision list entry.
     */
    private static class Entry
    {
        long key;
        Object value;
        Entry next;

        Entry()
        {
        }

        void init(long key, Object value, Entry next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Object clone()
        {
            Entry entry = getFree();
            entry.init(key, value,
                (next == null ? null : (Entry)next.clone()));
            return entry;
        }

        public long getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        void recycle()
        {
            this.key = NULL;
            this.next = null;
            this.value = null;
        }

        public Object setValue(Object value)
        {
            Object oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o)
        {
            if (!(o instanceof LongKeyMap.Entry)) {
                return false;
            }
            LongKeyMap.Entry e = (LongKeyMap.Entry)o;

            return key == e.key &&
                   (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        public int hashCode()
        {
            return (int)key ^ (value == null ? 0 : value.hashCode());
        }

        public String toString()
        {
            return key + "=" + value;
        }
    }

    // Types of Iterators
    private static final int KEYS = 0;
    private static final int VALUES = 1;
    private static final int ENTRIES = 2;

    private static EmptyHashIterator emptyHashIterator
        = new EmptyHashIterator();

    private static class EmptyHashIterator implements Iterator
    {

        EmptyHashIterator()
        {
        }

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new IllegalStateException();
        }

    }

    private class HashIterator implements Iterator
    {
        Entry[] table = LongKeyMap.this.table;
        int index = table.length;
        Entry entry = null;
        Entry lastReturned = null;
        int type;

        private int expectedModCount = modCount;

        HashIterator(int type)
        {
            this.type = type;
        }

        public boolean hasNext()
        {
            Entry e = entry;
            int i = index;
            Entry t[] = table;
            /* Use locals for faster loop iteration */
            while (e == null && i > 0) {
                e = t[--i];
            }
            entry = e;
            index = i;
            return e != null;
        }

        public Object next()
        {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            Entry et = entry;
            int i = index;
            Entry t[] = table;

            /* Use locals for faster loop iteration */
            while (et == null && i > 0) {
                et = t[--i];
            }

            entry = et;
            index = i;
            if (et != null) {
                Entry e = lastReturned = entry;
                entry = e.next;
                return type == KEYS ? new Long(e.key) : (type == VALUES ? e.value : e);
            }
            throw new NoSuchElementException();
        }

        public void remove()
        {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            Entry[] tab = LongKeyMap.this.table;
            int index = (int)(lastReturned.key & 0x7FFFFFFF) % tab.length;

            for (Entry e = tab[index], prev = null; e != null;
                 prev = e, e = e.next) {
                if (e == lastReturned) {
                    modCount++;
                    expectedModCount++;
                    if (prev == null) {
                        tab[index] = e.next;
                    }
                    else {
                        prev.next = e.next;
                    }
                    count--;
                    lastReturned = null;
                    return;
                }
            }
            throw new ConcurrentModificationException();
        }
    }

    int capacity()
    {
        return table.length;
    }

    float loadFactor()
    {
        return loadFactor;
    }
}
