/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.storage;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "JavaStorageClass.h")
@Name("ccj::JavaStorageClass")
@com.googlecode.javacpp.annotation.Opaque
public class Storage
    extends Pointer
{
    public native static Storage getInstance();

    /**
     * Initializes the database. If path is null, it will create an in-memory DB
     */
    public native void init(@StdString String fullpath);

    public native void init();

    /**
     * Frees the allocated resources
     */
    public native void free();

    /**
     * sets an item in the LS
     */
    public native void setItem(@StdString String key, @StdString String value);

    /**
     * gets an item from the LS
     */
    @StdString
    public native String getItem(@StdString String key);

    /**
     * removes an item from the LS
     */
    public native void removeItem(@StdString String key);
}
