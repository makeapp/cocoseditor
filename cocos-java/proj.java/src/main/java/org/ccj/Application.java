/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.util.StringUtil;
import org.fun.Function;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-27 下午11:00 $
 *          $Id$
 */

@Platform(include = "CCApplication.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Application
    extends Pointer
{
    static {
        String jvmName = System.getProperty("java.vm.name", "");
        String osName = System.getProperty("os.name", "");
        String osArch = System.getProperty("os.arch", "");
        String cocosjdkHome = System.getProperty("CDK_HOME", "");
        String javaLibPath = System.getProperty("java.library.path");

        if (osName.startsWith("Windows")) {
            if (StringUtil.isValid(cocosjdkHome)) {
                javaLibPath = cocosjdkHome + "/bin";
            }
            if (StringUtil.isValid(javaLibPath)) {
                System.load(javaLibPath + "/zlib1.dll");
                System.load(javaLibPath + "/libcurl.dll");
                System.load(javaLibPath + "/glew32.dll");
                System.load(javaLibPath + "/msvcr110.dll");
                System.load(javaLibPath + "/msvcr110d.dll");
                System.load(javaLibPath + "/msvcp110d.dll");
                System.load(javaLibPath + "/sqlite3.dll");
                System.load(javaLibPath + "/libmpg123.dll");
                System.load(javaLibPath + "/libogg.dll");
                System.load(javaLibPath + "/libvorbis.dll");
                System.load(javaLibPath + "/libvorbisfile.dll");
                System.load(javaLibPath + "/OpenAL32.dll");
                System.load(javaLibPath + "/websockets.dll");
                System.load(javaLibPath + "/libcocos2d.dll");
                System.load(javaLibPath + "/cocosjava.dll");
            }
            else {
                System.err.println("Can't find dll path in CDK_HOME or java.library.path");
            }
        }
        else if (osName.startsWith("Mac")) {
            if (StringUtil.isValid(cocosjdkHome)) {
                javaLibPath = cocosjdkHome + "/bin";
            }
            if (StringUtil.isValid(javaLibPath)) {
                System.load(javaLibPath + "/libcocosjava.dylib");
            }
        }
    }

    public static final int OS_WINDOWS = 0,
        OS_LINUX = 1,
        OS_MAC = 2,
        OS_ANDROID = 3,
        OS_IPHONE = 4,
        OS_IPAD = 4,
        OS_BLACKBERRY = 5,
        OS_NACL = 6,
        OS_EMSCRIPTEN = 7,
        OS_TIZEN = 8,
        OS_WINRT = 9,
        OS_WP8 = 10;


    public static final int ENGLISH = 0,
        CHINESE = 1,
        FRENCH = 2,
        ITALIAN = 3,
        GERMAN = 4,
        SPANISH = 5,
        DUTCH = 6,
        RUSSIAN = 7,
        KOREAN = 8,
        JAPANESE = 9,
        HUNGARIAN = 10,
        PORTUGUESE = 11,
        ARABIC = 12,
        NORWEGIAN = 13,
        POLISH = 14;

    Engine engine;

    /**
     * @brief Run the message loop.
     */
    public native int run();

    public Application()
    {
        engine = Engine.getInstance();
        engine.addFunction("applicationDidFinishLaunching", new Function<String, String>()
        {
            public String apply(String aVoid)
            {
                applicationDidFinishLaunching();
                return null;
            }
        });

        engine.addFunction("applicationDidEnterBackground", new Function<String, String>()
        {
            public String apply(String aVoid)
            {
                applicationDidEnterBackground();
                return null;
            }
        });
        engine.addFunction("applicationWillEnterForeground", new Function<String, String>()
        {
            public String apply(String aVoid)
            {
                applicationWillEnterForeground();
                return null;
            }
        });
        allocate();
    }

    @Name("cocos2d::Application::getInstance")
    @Allocator
    @NoDeallocator
    native void allocate();

    /**
     * @return Current application instance pointer.
     *
     * @brief Get current applicaiton instance.
     */
    public native static Application getInstance();


    /**
     * @return false   Initialize failed, app terminate.
     *
     * @brief Implement Director and Scene init code here.
     */
    public boolean applicationDidFinishLaunching()
    {
        return false;
    }

    /**
//     * @param  pointer of the application
     *
     * @brief The function be called when the application enter background
     */
    public boolean applicationDidEnterBackground()
    {
        return false;
    }

    /**
//     * @param the pointer of the application
     *
     * @brief The function be called when the application enter foreground
     */
    public boolean applicationWillEnterForeground()
    {
        return false;
    }


    /**
     * @param interval The time, expressed in seconds, between current frame and next.
     *
     * @brief Callback by Director for limit FPS.
     * @js NA
     * @lua NA
     */
    public native void setAnimationInterval(double interval);

    /**
     * @return Current language config
     *
     * @brief Get current language config
     * @js NA
     * @lua NA
     */
    @Cast("int")
    public native int getCurrentLanguage();

    /**
     * @return Current language iso 639-1 code
     *
     * @brief Get current language iso 639-1 code
     * @js NA
     * @lua NA
     */
    public native String getCurrentLanguageCode();

    /**
     * @brief Get target platform
     * @js NA
     * @lua NA
     */
    @Cast("int")
    public native int getTargetPlatform();

    /**
     @brief Open url in default browser
     @param String with url to open.
     @return true if the resource located by the URL was successfully opened; otherwise false.
      * @js NA
     * @lua NA
     */
    public native  boolean openURL(@StdString String url);
}
