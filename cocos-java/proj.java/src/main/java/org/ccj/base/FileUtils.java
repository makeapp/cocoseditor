/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/17 17:02 $
 *          $Id$
 */

@Platform(include = "CCFileUtils.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class FileUtils extends Pointer
{
    /**
     * Gets the instance of FileUtils.
     */
    public native static FileUtils getInstance();

    /**
     * Destroys the instance of FileUtils.
     */
    public native static void destroyInstance();

    /** @deprecated Use getInstance() instead */
//       CC_DEPRECATED_ATTRIBUTE static FileUtils* sharedFileUtils() { return getInstance(); }

    /** @deprecated Use destroyInstance() instead */
//       CC_DEPRECATED_ATTRIBUTE static void purgeFileUtils() { destroyInstance(); }

    /**
     *  The destructor of FileUtils.
     * @js NA
     * @lua NA
     */
//       virtual ~FileUtils();

    /**
     * Purges the file searching cache.
     *
     * @note It should be invoked after the resources were updated.
     * For instance, in the CocosPlayer sample, every time you run application from CocosBuilder,
     * All the resources will be downloaded to the writable folder, before new js app launchs,
     * this method should be invoked to clean the file search cache.
     */
    public native void purgeCachedEntries();

    /**
     * Gets string from a file.
     */
    @StdString
    @Const
    public native String getStringFromFile(@StdString String filename);

    /**
     *  Creates binary data from a file.
     *  @return A data object.
     */
//       public native Data getDataFromFile(@StdString String  filename);

    /**
     *  Gets resource file data
     *
     *  @param[in]  filename The resource file name which contains the path.
     *  @param[in]  pszMode The read mode of the file.
     *  @param[out] pSize If the file read operation succeeds, it will be the data size, otherwise 0.
     *  @return Upon success, a pointer to the data is returned, otherwise NULL.
     *  @warning Recall: you are responsible for calling free() on any Non-NULL pointer returned.
     */
//       CC_DEPRECATED_ATTRIBUTE public native unsigned char* getFileData(@StdString String  filename, const char* mode, ssize_t *size);

    /**
     *  Gets resource file data from a zip file.
     *
     *  @param[in]  filename The resource file name which contains the relative path of the zip file.
     *  @param[out] size If the file read operation succeeds, it will be the data size, otherwise 0.
     *  @return Upon success, a pointer to the data is returned, otherwise nullptr.
     *  @warning Recall: you are responsible for calling free() on any Non-nullptr pointer returned.
     */
//       public native String getFileDataFromZip(@StdString String  zipFilePath, @StdString String  filename, int size);


    /**
     * Returns the fullpath for a given filename.
     * <p/>
     * First it will try to get a new filename from the "filenameLookup" dictionary.
     * If a new filename can't be found on the dictionary, it will use the original filename.
     * Then it will try to obtain the full path of the filename using the FileUtils search rules: resolutions, and search paths.
     * The file search is based on the array element order of search paths and resolution directories.
     * <p/>
     * For instance:
     * <p/>
     * We set two elements("/mnt/sdcard/", "internal_dir/") to search paths vector by setSearchPaths,
     * and set three elements("resources-ipadhd/", "resources-ipad/", "resources-iphonehd")
     * to resolutions vector by setSearchResolutionsOrder. The "internal_dir" is relative to "Resources/".
     * <p/>
     * If we have a file named 'sprite.png', the mapping in fileLookup dictionary contains `key: sprite.png -> value: sprite.pvr.gz`.
     * Firstly, it will replace 'sprite.png' with 'sprite.pvr.gz', then searching the file sprite.pvr.gz as follows:
     * <p/>
     * /mnt/sdcard/resources-ipadhd/sprite.pvr.gz      (if not found, search next)
     * /mnt/sdcard/resources-ipad/sprite.pvr.gz        (if not found, search next)
     * /mnt/sdcard/resources-iphonehd/sprite.pvr.gz    (if not found, search next)
     * /mnt/sdcard/sprite.pvr.gz                       (if not found, search next)
     * internal_dir/resources-ipadhd/sprite.pvr.gz     (if not found, search next)
     * internal_dir/resources-ipad/sprite.pvr.gz       (if not found, search next)
     * internal_dir/resources-iphonehd/sprite.pvr.gz   (if not found, search next)
     * internal_dir/sprite.pvr.gz                      (if not found, return "sprite.png")
     * <p/>
     * If the filename contains relative path like "gamescene/uilayer/sprite.png",
     * and the mapping in fileLookup dictionary contains `key: gamescene/uilayer/sprite.png -> value: gamescene/uilayer/sprite.pvr.gz`.
     * The file search order will be:
     * <p/>
     * /mnt/sdcard/gamescene/uilayer/resources-ipadhd/sprite.pvr.gz      (if not found, search next)
     * /mnt/sdcard/gamescene/uilayer/resources-ipad/sprite.pvr.gz        (if not found, search next)
     * /mnt/sdcard/gamescene/uilayer/resources-iphonehd/sprite.pvr.gz    (if not found, search next)
     * /mnt/sdcard/gamescene/uilayer/sprite.pvr.gz                       (if not found, search next)
     * internal_dir/gamescene/uilayer/resources-ipadhd/sprite.pvr.gz     (if not found, search next)
     * internal_dir/gamescene/uilayer/resources-ipad/sprite.pvr.gz       (if not found, search next)
     * internal_dir/gamescene/uilayer/resources-iphonehd/sprite.pvr.gz   (if not found, search next)
     * internal_dir/gamescene/uilayer/sprite.pvr.gz                      (if not found, return "gamescene/uilayer/sprite.png")
     * <p/>
     * If the new file can't be found on the file system, it will return the parameter filename directly.
     * <p/>
     * This method was added to simplify multiplatform support. Whether you are using cocos2d-js or any cross-compilation toolchain like StellaSDK or Apportable,
     * you might need to load different resources for a given file in the different platforms.
     *
     * @since v2.1
     */
    @StdString
    @Const
    public native String fullPathForFilename(@StdString String filename);

    /**
     * Loads the filenameLookup dictionary from the contents of a filename.
     *
     * @param filename The plist file name.
     *
     * @note The plist file name should follow the format below:
     * @code <?xml version="1.0" encoding="UTF-8"?>
     * <!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
     * <plist version="1.0">
     * <dict>
     * <key>filenames</key>
     * <dict>
     * <key>sounds/click.wav</key>
     * <string>sounds/click.caf</string>
     * <key>sounds/endgame.wav</key>
     * <string>sounds/endgame.caf</string>
     * <key>sounds/gem-0.wav</key>
     * <string>sounds/gem-0.caf</string>
     * </dict>
     * <key>metadata</key>
     * <dict>
     * <key>version</key>
     * <integer>1</integer>
     * </dict>
     * </dict>
     * </plist>
     * @endcode
     * @js loadFilenameLookup
     * @lua loadFilenameLookup
     * @since v2.1
     */
    public native void loadFilenameLookupDictionaryFromFile(@StdString String filename);

    /**
     *  Sets the filenameLookup dictionary.
     *
     *  @param pFilenameLookupDict The dictionary for replacing filename.
     *  @since v2.1
     */
//       public native void setFilenameLookupDictionary(const ValueMap& filenameLookupDict);

    /**
     * Gets full path from a file name and the path of the reletive file.
     *
     * @param filename     The file name.
     * @param relativeFile The path of the relative file.
     *
     * @return The full path.
     * e.g. filename: hello.png, pszRelativeFile: /User/path1/path2/hello.plist
     * Return: /User/path1/path2/hello.pvr (If there a a key(hello.png)-value(hello.pvr) in FilenameLookup dictionary. )
     */
    @StdString
    public native String fullPathFromRelativeFile(@StdString String filename, @StdString String relativeFile);

    /**
     * Sets the array that contains the search order of the resources.
     *
     * @param searchResolutionsOrder The source array that contains the search order of the resources.
     *
     * @lua NA
     * @since v2.1
     * In js:var setSearchResolutionsOrder(var jsval)
     */
    public native void setSearchResolutionsOrder(@ByRef VectorString searchResolutionsOrder);

    /**
     * Append search order of the resources.
     *
     * @since v2.1
     */
    public native void addSearchResolutionsOrder(@StdString String order);

    /**
     * Gets the array that contains the search order of the resources.
     *
     * @lua NA
     * @since v2.1
     */
    @ByRef
    @Const
    public native VectorString getSearchResolutionsOrder();

    /**
     * Sets the array of search paths.
     * <p/>
     * You can use this array to modify the search path of the resources.
     * If you want to use "themes" or search resources in the "cache", you can do it easily by adding new entries in this array.
     *
     * @param searchPaths The array contains search paths.
     *
     * @note This method could access relative path and absolute path.
     * If the relative path was passed to the vector, FileUtils will add the default resource directory before the relative path.
     * For instance:
     * On Android, the default resource root path is "assets/".
     * If "/mnt/sdcard/" and "resources-large" were set to the search paths vector,
     * "resources-large" will be converted to "assets/resources-large" since it was a relative path.
     * @lua NA
     * @since v2.1
     * In js:var setSearchPaths(var jsval);
     */
    public native void setSearchPaths(@ByRef VectorString searchPaths);

    /**
     * Add search path.
     *
     * @since v2.1
     */
    public native void addSearchPath(@StdString String path);

    /**
     * Gets the array of search paths.
     *
     * @return The array of search paths.
     *
     * @lua NA
     */
    @ByRef
    @Const
    public native VectorString getSearchPaths();

    /**
     * Gets the writable path.
     *
     * @return The path that can be write/read a file in
     */
    @StdString
    @Const
    public native String getWritablePath();

    /**
     * Checks whether a file exists.
     *
     * @return true if the file exists, otherwise it will return false.
     *
     * @note If a relative path was passed in, it will be inserted a default root path at the beginning.
     */
    public native boolean isFileExist(@StdString String filename);

    /**
     * Checks whether the path is an absolute path.
     *
     * @return true if it's an absolute path, otherwise it will return false.
     *
     * @note On Android, if the parameter passed in is relative to "assets/", this method will treat it as an absolute path.
     * Also on Blackberry, path starts with "app/native/Resources/" is treated as an absolute path.
     */
    public native boolean isAbsolutePath(@StdString String path);


    /**
     * Sets/Gets whether to pop-up a message box when failed to load an image.
     */
    public native void setPopupNotify(@Cast("bool") boolean notify);

    public native boolean isPopupNotify();

    /**
     *  Converts the contents of a file to a ValueMap.
     *  @note This method is used internally.
     */
//       public native ValueMap getValueMapFromFile(@StdString String  filename);

    /**
     *  Write a ValueMap to a plist file.
     *  @note This method is used internally.
     */
//       public native bool writeToFile(ValueMap& dict, @StdString String  fullPath);

    /**
     *  Converts the contents of a file to a ValueVector.
     *  @note This method is used internally.
     */
//       public native ValueVector getValueVectorFromFile(@StdString String  filename);

    /** Returns the full path cache */
//       const std::unordered_map<std::string, std::string>& getFullPathCache() const { return _fullPathCache; }

}
