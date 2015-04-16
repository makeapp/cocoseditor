/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:37 $
 *          $Id$
 */

@Platform(include = "ui/UIRichText.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class RichText extends Widget
{
    public RichText(Pointer p)
    {
        super(p);
    }

    public native static RichText create();

    public native void insertElement(RichElement element, int index);

    public native void pushBackElement(RichElement element);

    public native void removeElement(int index);

    public native void removeElement(RichElement element);

    //      virtual void visit(cocos2d::Renderer *renderer, const Mat4 &parentTransform, bool parentTransformUpdated) override;
    public native void setVerticalSpace(float space);

    @ByRef
    @Const
    public native Size getVirtualRendererSize();

    public native void formatText();

    public native void ignoreContentAdaptWithSize(boolean ignore);
}
