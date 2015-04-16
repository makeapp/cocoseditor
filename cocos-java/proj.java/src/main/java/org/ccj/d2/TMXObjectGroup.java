/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.math.Vec2;
import org.ccj.base.Ref;
import org.ccj.base.Value;
import org.ccj.base.ValueMap;
import org.ccj.base.VectorValue;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:55 $
 *          $Id$
 */

@Platform(include = "CCTMXObjectGroup.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TMXObjectGroup extends Ref
{
    @StdString
    @Const
    public native String getGroupName();

    public native void setGroupName(@StdString String groupName);

    /**
     * return the value for the specific property name
     */
    @ByVal
    @Const
    public native Value getProperty(@StdString String propertyName);

//       CC_DEPRECATED_ATTRIBUTE Value propertyNamed(@StdString  String  propertyName) const { return getProperty(propertyName); };

    /**
     * return the dictionary for the specific object name.
     * It will return the 1st object found on the array for the given name.
     */
    @ByVal
    public native ValueMap getObject(@StdString String objectName);

//       CC_DEPRECATED_ATTRIBUTE ValueMap objectNamed(@StdString  String  objectName) const { return getObject(objectName); };

    /**
     * Gets the offset position of child objects
     */
    @ByRef
    @Const
    public native Vec2 getPositionOffset();

    /**
     * Sets the offset position of child objects
     */
    public native void setPositionOffset(@ByRef @Const Vec2 offset);

    /**
     * Gets the list of properties stored in a dictionary
     */
    @ByRef
    @Const
    public native ValueMap getProperties();

//       public native ValueMap& getProperties();

    /**
     * Sets the list of properties
     */
    public native void setProperties(@ByRef @Const ValueMap properties);

    /**
     * Gets the array of the objects
     */
    @ByRef
    @Const
    public native VectorValue getObjects();
//       public native ValueVector& getObjects() ;

    /**
     * Sets the array of the objects
     */
    public native void setObjects(@ByRef @Const VectorValue objects);

}
