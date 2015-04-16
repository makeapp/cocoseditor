/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Color4B;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:34 $
 *          $Id$
 */
@Platform(include = "CCLabel.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Label
    extends Node
{

    public static final int TEXTVALIGNMENT_TOP = 0;
    public static final int TEXTVALIGNMENT_CENTER = 1;
    public static final int TEXTVALIGNMENT_BOTTOM = 2;

    public static final int TEXTHALIGNMENT_LEFT = 0;
    public static final int TEXTHALIGNMENT_CENTER = 1;
    public static final int TEXTHALIGNMENT_RIGHT = 2;

    public Label()
    {
    }

    public Label(Pointer p)
    {
        super(p);
    }

    public static Label cast(Node node)
    {
        return cast(node, Label.class);
    }


    public native static Label create();

    /**
     * Creates a label with an initial string,font[font name or font file],font size, dimension in points, horizontal alignment and vertical alignment.
     *
     * @warning It will generate texture by the platform-dependent code
     */
    public native static Label createWithSystemFont(@StdString String text, @StdString String font, float fontSize,
                                                    @Const @ByRef Size dimensions, @Cast("cocos2d::TextHAlignment") int hAlignment, @Cast("cocos2d::TextVAlignment") int vAlignment);

    public native static Label createWithSystemFont(@StdString String text, @StdString String font, float fontSize);

    /**
     * Creates a label with an initial string,font file,font size, dimension in points, horizontal alignment and vertical alignment.
     *
     * @warning Not support font name.
     */
    public native static Label createWithTTF(@StdString String text, @StdString String fontFile, float fontSize,
                                             @Const @ByRef Size dimensions, @Cast("cocos2d::TextHAlignment") int hAlignment, @Cast("cocos2d::TextVAlignment") int vAlignment);

    /**
     * Create a label with TTF configuration
     *
     * @warning Not support font name.
     */
//    public native static Label createWithTTF(@Const @ByRef TTFConfig ttfConfig, @StdString String text, @Cast("cocos2d::TextHAlignment") int alignment, int maxLineWidth);

    /* Creates a label with an FNT file,an initial string,horizontal alignment,max line width and the offset of image*/
    public native static Label createWithBMFont(@StdString String bmfontFilePath, @StdString String text,
                                                @Cast("cocos2d::TextHAlignment") int alignment, int maxLineWidth, @Const @ByRef Vec2 imageOffset);

    public native static Label createWithCharMap(@StdString String charMapFile, int itemWidth, int itemHeight, int startCharMap);

    public native static Label createWithCharMap(Texture2D texture, int itemWidth, int itemHeight, int startCharMap);

    public native static Label createWithCharMap(@StdString String plistFile);

    /**
     * set TTF configuration for Label
     */
//    public native boolean setTTFConfig(@Const @ByRef TTFConfig ttfConfig);

//    @Const
//       @ByRef
//    public native TTFConfig getTTFConfig();
    public native boolean setBMFontFilePath(@StdString String bmfontFilePath, @Const @ByRef Vec2 imageOffset);

    @StdString
    public native String getBMFontFilePath();

    public native boolean setCharMap(@StdString String charMapFile, int itemWidth, int itemHeight, int startCharMap);

    public native boolean setCharMap(Texture2D texture, int itemWidth, int itemHeight, int startCharMap);

    public native boolean setCharMap(@StdString String plistFile);

    /* Sets the system font[font name or font file] of label*/
    public native void setSystemFontName(@StdString String systemFont);

    @StdString
    public native String getSystemFontName();

    /* Sets the system font size of label.*/
    public native void setSystemFontSize(float fontSize);

    public native float getSystemFontSize();

    /**
     * changes the string to render
     *
     * @warning It is as expensive as changing the string if you haven't set up TTF/BMFont/CharMap for the label.
     */
    public native void setString(@StdString String text);

    @StdString
    public native String getString();

    /**
     * Enable shadow for the label
     *
     * @todo support blur for shadow effect
     */
    public native void enableShadow(@Const @ByRef Color4B shadowColor, @Const @ByRef Size offset, int blurRadius);

    /**
     * only support for TTF
     */
    public native void enableOutline(@Const @ByRef Color4B outlineColor, int outlineSize);

    /**
     * only support for TTF
     */
    public native void enableGlow(@Const @ByRef Color4B glowColor);

    /**
     * disable shadow/outline/glow rendering
     */
    public native void disableEffect();

    public native void setAlignment(@Cast("cocos2d::TextHAlignment") int hAlignment);

    @Cast("int")
    public native int getTextAlignment();

    public native void setAlignment(@Cast("cocos2d::TextHAlignment") int hAlignment, @Cast("cocos2d::TextVAlignment") int vAlignment);

    public native void setHorizontalAlignment(@Cast("cocos2d::TextHAlignment") int hAlignment);

    @Cast("int")
    public native int getHorizontalAlignment();

    public native void setVerticalAlignment(@Cast("cocos2d::TextVAlignment") int vAlignment);

    @Cast("int")
    public native int getVerticalAlignment();

    public native void setLineBreakWithoutSpace(boolean breakWithoutSpace);

    /**
     * Sets the max line width of the label.
     * The label's max line width be used for force line breaks if the set value not equal zero.
     * The label's width and max line width has not always to be equal.
     */
    public native void setMaxLineWidth(int maxLineWidth);

    public native int getMaxLineWidth();

    /**
     * Sets the untransformed size of the label.
     * The label's width be used for text align if the set value not equal zero.
     * The label's max line width will be equal to the same value.
     */
    public native void setWidth(int width);
//    public native   int getWidth() const { return _labelWidth; }

    /**
     * Sets the untransformed size of the label.
     * The label's height be used for text align if the set value not equal zero.
     * The text will display of incomplete when the size of label not enough to support display all text.
     */
    public native void setHeight(int height);

//        public native  int getHeight() ;

    /**
     * Sets the untransformed size of the label in a more efficient way.
     */
    public native void setDimensions(int width, int height);

    @ByRef
    @Const
    public native Size getDimensions();

    /**
     * update content immediately.
     */
    public native void updateContent();

    /**
     * Sets the text color
     */
    public native void setTextColor(@ByRef @Const Color4B color);

    @ByRef
    @Const
    public native Color4B getTextColor();

    public native Sprite getLetter(int lettetIndex);

    /**
     * clip upper and lower margin for reduce height of label.
     */
    public native void setClipMarginEnabled(boolean clipEnabled);

    public native boolean isClipMarginEnabled();

    // font related stuff
    public native int getCommonLineHeight();

    // string related stuff
    public native int getStringNumLines();

    public native int getStringLength();

//        FontAtlas* getFontAtlas() { return _fontAtlas; }

//        public native void setBlendFunc(const BlendFunc &blendFunc) override;

//        public native void updateDisplayedColor(const Color3B& parentColor) override;
//        public native void updateDisplayedOpacity(GLubyte parentOpacity) override;


    /*@Name("cocos2d::TTFConfig")
    public class TTFConfig extends Pointer
    {
//        String fontFilePath;
//        int fontSize;
//        GlyphCollection glyphs;
//        const char *customGlyphs;
//        bool distanceFieldEnabled;
//        int outlineSize;

        @Name("TTFConfig")
        public native void allocate(@StdString String fontFilePath,int size);
    }*/
}
