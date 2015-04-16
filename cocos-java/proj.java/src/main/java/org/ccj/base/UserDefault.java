/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-16 上午9:57 $
 *          $Id$
 */
@Platform(include = "CCUserDefault.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class UserDefault
    extends Pointer
{
    /**
     * @brief Get boolean  value by key, if the key doesn't exist, a default value will return.
     * You can set the default value, or it is false.
     * @js NA
     */
    public native boolean getBoolForKey(String pKey);

    /**
     * @js NA
     */
    public native boolean getBoolForKey(String pKey, boolean defaultValue);

    /**
     * @brief Get integer value by key, if the key doesn't exist, a default value will return.
     * You can set the default value, or it is 0.
     * @js NA
     */
    public native int getIntegerForKey(String pKey);

    /**
     * @js NA
     */
    public native int getIntegerForKey(String pKey, int defaultValue);

    /**
     * @brief Get float value by key, if the key doesn't exist, a default value will return.
     * You can set the default value, or it is 0.0f.
     * @js NA
     */
    public native float getFloatForKey(String pKey);

    /**
     * @js NA
     */
    public native float getFloatForKey(String pKey, float defaultValue);

    /**
     * @brief Get double value by key, if the key doesn't exist, a default value will return.
     * You can set the default value, or it is 0.0.
     * @js NA
     */
    public native double getDoubleForKey(String pKey);

    /**
     * @js NA
     */
    public native double getDoubleForKey(String pKey, double defaultValue);

    /**
     * @brief Get string value by key, if the key doesn't exist, a default value will return.
     * You can set the default value, or it is "".
     * @js NA
     */
    @StdString
    public native String getStringForKey(String pKey);

    /**
     * @js NA
     */
    @StdString
    public native String getStringForKey(String pKey, @StdString String defaultValue);
    /**
     @brief Get binary data value by key, if the key doesn't exist, a default value will return.
     You can set the default value, or it is null.
      * @js NA
     * @lua NA
     */
//      public native  Data getDataForKey(String pKey);
    /**
     * @js NA
     * @lua NA
     */
//      public native  Data getDataForKey(String pKey, const Data& defaultValue);

    // set value methods

    /**
     * @brief Set boolean  value by key.
     * @js NA
     */
    public native void setBoolForKey(String pKey, boolean value);

    /**
     * @brief Set integer value by key.
     * @js NA
     */
    public native void setIntegerForKey(String pKey, int value);

    /**
     * @brief Set float value by key.
     * @js NA
     */
    public native void setFloatForKey(String pKey, float value);

    /**
     * @brief Set double value by key.
     * @js NA
     */
    public native void setDoubleForKey(String pKey, double value);

    /**
     * @brief Set string value by key.
     * @js NA
     */
    public native void setStringForKey(String pKey, @StdString String value);
    /**
     @brief Set binary data value by key.
      * @js NA
     * @lua NA
     */
//      public native void    setDataForKey(String pKey, const Data& value);

    /**
     * @brief Save content to xml file
     * @js NA
     */
    public native void flush();

    /**
     * returns the singleton
     *
     * @js NA
     * @lua NA
     */
    public native static UserDefault getInstance();

    /**
     * @js NA
     */
    public native static void destroyInstance();

    /** deprecated. Use getInstace() instead
     //       * @js NA
     //       * @lua NA
     //       */
//      CC_DEPRECATED_ATTRIBUTE static UserDefault* sharedUserDefault();
//      /**
//       * @js NA
//       */
//      CC_DEPRECATED_ATTRIBUTE static void purgeSharedUserDefault();

    /**
     * @js NA
     */
    @StdString
    public native static String getXMLFilePath();

    /**
     * @js NA
     */
    public native static boolean isXMLFileExist();
}
