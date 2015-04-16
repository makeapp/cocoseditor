/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.base.Value;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 15:55 $
 *          $Id$
 */
@Platform(include = "CCConfiguration.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Configuration extends Ref
{
    /**
     * returns a shared instance of Configuration
     */
    public native static Configuration getInstance();

    /**
     * purge the shared instance of Configuration
     */
    public native static void destroyInstance();

    /**
     * OpenGL Max texture size.
     */
    public native int getMaxTextureSize();

    /**
     * OpenGL Max Modelview Stack Depth.
     */
    public native int getMaxModelviewStackDepth();

    /**
     * returns the maximum texture units
     *
     * @since v2.0.0
     */
    public native int getMaxTextureUnits();

    /**
     * Whether or not the GPU supports NPOT (Non Power Of Two) textures.
     * OpenGL ES 2.0 already supports NPOT (iOS).
     *
     * @since v0.99.2
     */
    public native boolean supportsNPOT();

    /**
     * Whether or not PVR Texture Compressed is supported
     */
    public native boolean supportsPVRTC();

    /**
     * Whether or not ETC Texture Compressed is supported
     */
    public native boolean supportsETC();

    /**
     * Whether or  not S3TC Texture Compressed is supported
     */
    public native boolean supportsS3TC();

    /**
     * Whether or  not ATITC Texture Compressed is supported
     */
    public native boolean supportsATITC();

    /**
     * Whether or not BGRA8888 textures are supported.
     *
     * @since v0.99.2
     */
    public native boolean supportsBGRA8888();

    /**
     * Whether or not glDiscardFramebufferEXT is supported
     *
     * @since v0.99.2
     */
    public native boolean supportsDiscardFramebuffer();

    /**
     * Whether or not shareable VAOs are supported.
     *
     * @since v2.0.0
     */
    public native boolean supportsShareableVAO();

    /**
     * returns whether or not an OpenGL is supported
     */
    public native boolean checkForGLExtension(@StdString String searchName);

    public native boolean init();

    /**
     * returns the value of a given key as a double
     */
    @Const
    @ByRef
    public native Value getValue(@StdString String key, @Const @ByRef Value defaultValue);

    /**
     * sets a new key/value pair  in the configuration dictionary
     */
    public native void setValue(@StdString String key, @Const @ByRef Value value);

    /**
     * returns the Configuration info
     */
    @StdString
    public native String getInfo();

    /**
     * gathers OpenGL / GPU information
     */
    public native void gatherGPUInfo();

    /**
     * Loads a config file. If the keys are already present, then they are going to be replaced. Otherwise the new keys are added.
     */
    public native void loadConfigFile(@StdString String filename);
}
