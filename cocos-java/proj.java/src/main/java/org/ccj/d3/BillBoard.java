package org.ccj.d3;

import com.googlecode.javacpp.annotation.*;
import org.ccj.d2.Sprite;
import org.ccj.d2.Texture2D;
import org.ccj.math.Rect;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCBillBoard.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class BillBoard extends Sprite {

      public static final int   VIEW_POINT_ORIENTED=0, // orient to the camera
        VIEW_PLANE_ORIENTED=1; // orient to the XOY plane of camera

    /**
     * Creates an empty BillBoard without texture. You can call setTexture method subsequently.
     *
     * @return An autoreleased BillBoard object.
     */
   public native static BillBoard create(@Cast("cocos2d::BillBoard::Mode")int mode );

    /**
     * Creates a BillBoard with an image filename.
     *
     * After creation, the rect of BillBoard will be the size of the image,
     * and the offset will be (0,0).
     *
     * @param   filename A path to image file, e.g., "scene1/monster.png"
     * @return  An autoreleased BillBoard object.
     */
    public native  static BillBoard create(String filename,@Cast("cocos2d::BillBoard::Mode") int mode);

    /**
     * Creates a BillBoard with an image filename and a rect.
     *
     * @param   filename A path to image file, e.g., "scene1/monster.png"
     * @param   rect     A subrect of the image file
     * @return  An autoreleased BillBoard object
     */
    public native static BillBoard create(String filename, @Const @ByRef Rect rect,@Cast("cocos2d::BillBoard::Mode") int mode );

    /**
     * Creates a BillBoard with a Texture2D object.
     *
     * After creation, the rect will be the size of the texture, and the offset will be (0,0).
     *
     * @param   texture    A pointer to a Texture2D object.
     * @return  An autoreleased BillBoard object
     */
    public native  static BillBoard createWithTexture(Texture2D texture,@Cast("cocos2d::BillBoard::Mode") int mode);

    /** Set the billboard rotation mode. */
    public native void setMode(@Cast("cocos2d::BillBoard::Mode")int mode);

    /** Get the billboard rotation mode. */
    @Cast("int")
    public native   int getMode() ;

}
