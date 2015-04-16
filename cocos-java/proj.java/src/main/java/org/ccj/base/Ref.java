/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import java.lang.reflect.Constructor;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.Logger;
import org.ccj.util.LongKeyMap;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 下午5:01 $
 *          $Id$
 */
@Platform(include = "CCRef.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Ref
    extends Pointer
{
    protected static LongKeyMap objects = new LongKeyMap(1000, 0.75f);

    public Ref()
    {
    }

    public Ref(long address)
    {
        this(getPointer(address));
    }

    private static Pointer getPointer(long address) {
        Pointer p=new Pointer();
        p.init(address,0,0);
        return p;
    }


    public Ref(Pointer p)
    {
        super(p);
    }

    public static void putRef(Ref ref)
    {
        objects.put(ref.address, ref);
    }

    public static boolean containsRef(long address)
    {
        return objects.containsKey(address);
    }


    public static Ref getRef(long address)
    {
        return (Ref) objects.get(address);
    }

    public static Ref releaseRef(long address)
    {
        return (Ref) objects.remove(address);
    }

    /**
     * Retains the ownership.
     * <p/>
     * This increases the Ref's reference count.
     *
     * @js NA
     */
    public native void retain();

    /**
     * Release the ownership immediately.
     * <p/>
     * This decrements the Ref's reference count.
     * <p/>
     * If the reference count reaches 0 after the descrement, this Ref is
     * destructed.
     *
     * @js NA
     */
    public native void release();

    /**
     * Release the ownership sometime soon automatically.
     * <p/>
     * This descrements the Ref's reference count at the end of current
     * autorelease pool block.
     * <p/>
     * If the reference count reaches 0 after the descrement, this Ref is
     * destructed.
     *
     * @returns The Ref itself.
     * @js NA
     * @lua NA
     */
    public native Ref autorelease();

    /**
     * Returns the Ref's current reference count.
     *
     * @returns The Ref's reference count.
     * @js NA
     */
    public native int getReferenceCount();

    public static <T extends Pointer> T cast(Ref ref, Class<T> tClass)
    {
        if (ref == null) {
            return null;
        }
        /*Ref obj = getRef(ref.address);
        if (obj != null && obj.getClass().equals(tClass)) {
            return (T) obj;
        }*/
        try {
            Constructor constructor = tClass.getConstructor(Pointer.class);
            if (constructor != null) {
                return (T) constructor.newInstance(ref);
            }
            else {
                Logger.log("Can't find Constructor Pointer " + ref);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int hashCode()
    {
        return (int) address();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Ref) {
            Ref ref = (Ref) obj;
            return ref.address() == address();
        }

        return super.equals(obj);
    }

    /*protected void finalize() throws Throwable
    {
        super.finalize();
//        System.out.println("objs "+objects.size()+" "+getClass().getName());
        objects.remove(address);
    }*/
}
