/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCMenuItem.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MenuItemLabel
    extends MenuItem
{

    public MenuItemLabel(Pointer p)
    {
        super(p);
    }
    /** creates a MenuItemLabel with a Label and a callback */
//     public native   static MenuItemLabel * create(Node*label, const ccMenuCallback& callback);

    /**
     * creates a MenuItemLabel with a Label. Target and selector will be nil
     */
    public native static MenuItemLabel create(Node label);

    /**
     * sets a new string to the inner label
     */
    public native void setString(String label);

    /** Gets the color that will be used to disable the item */
//    public native  const Color3B& getDisabledColor() const { return _disabledColor; };

    /** Sets the color that will be used to disable the item */
//       public native  void setDisabledColor(const Color3B& color) { _disabledColor = color; };

    /**
     * Gets the label that is rendered.
     */
    public native Node getLabel();

    /**
     * Sets the label that is rendered.
     */
    public native void setLabel(Node node);

    // Overrides
    public native void activate();

    public native void selected();

    public native void unselected();

    public native void setEnabled(@Cast("bool") boolean enabled);
}
