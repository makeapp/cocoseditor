/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:46 $
 *          $Id$
 */

@Platform(include = "ZipUtils.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ZipUtils extends Pointer
{
    /**
     * Inflates either zlib or gzip deflated memory. The inflated memory is
     * expected to be freed by the caller.
     *
     * It will allocate 256k for the destination buffer. If it is not enough it will multiply the previous buffer size per 2, until there is enough memory.
     * @returns the length of the deflated buffer
     *
     @since v0.8.1
     */
//            static ssize_t inflateMemory(unsigned char *in, ssize_t inLength, unsigned char **out);

    /**
     * Inflates either zlib or gzip deflated memory. The inflated memory is
     * expected to be freed by the caller.
     *
     * outLenghtHint is assumed to be the needed room to allocate the inflated buffer.
     *
     * @returns the length of the deflated buffer
     *
     @since v1.0.0
     */
//            static ssize_t inflateMemoryWithHint(unsigned char *in, ssize_t inLength, unsigned char **out, ssize_t outLengthHint);

    /** inflates a GZip file into memory
     *
     * @returns the length of the deflated buffer
     *
     * @since v0.99.5
     */
//            static int inflateGZipFile(const char *filename, unsigned char **out);

    /**
     * test a file is a GZip format file or not
     *
     * @returns true is a GZip format file. false is not
     * @since v3.0
     */
    public native static boolean isGZipFile(String filename);

    /** test the buffer is GZip format or not
     *
     * @returns true is GZip format. false is not
     *
     * @since v3.0
     */
//            static bool isGZipBuffer(const unsigned char *buffer, ssize_t len);

    /** inflates a CCZ file into memory
     *
     * @returns the length of the deflated buffer
     *
     * @since v0.99.5
     */
//            static int inflateCCZFile(const char *filename, unsigned char **out);

    /** inflates a buffer with CCZ format into memory
     *
     * @returns the length of the deflated buffer
     *
     * @since v3.0
     */
//            static int inflateCCZBuffer(const unsigned char *buffer, ssize_t len, unsigned char **out);

    /** test a file is a CCZ format file or not
     *
     * @returns true is a CCZ format file. false is not
     *
     * @since v3.0
     */
//            static bool isCCZFile(const char *filename);

    /** test the buffer is CCZ format or not
     *
     * @returns true is CCZ format. false is not
     *
     * @since v3.0
     */
//            static bool isCCZBuffer(const unsigned char *buffer, ssize_t len);

    /**
     * Sets the pvr.ccz encryption key parts separately for added
     * security.
     * <p/>
     * Example: If the key used to encrypt the pvr.ccz file is
     * 0xaaaaaaaabbbbbbbbccccccccdddddddd you will call this function 4
     * different times, preferably from 4 different source files, as follows
     * <p/>
     * ZipUtils::setPvrEncryptionKeyPart(0, 0xaaaaaaaa);
     * ZipUtils::setPvrEncryptionKeyPart(1, 0xbbbbbbbb);
     * ZipUtils::setPvrEncryptionKeyPart(2, 0xcccccccc);
     * ZipUtils::setPvrEncryptionKeyPart(3, 0xdddddddd);
     * <p/>
     * Splitting the key into 4 parts and calling the function
     * from 4 different source files increases the difficulty to
     * reverse engineer the encryption key. Be aware that encrpytion
     * is *never* 100% secure and the key code can be cracked by
     * knowledgable persons.
     * <p/>
     * IMPORTANT: Be sure to call setPvrEncryptionKey or
     * setPvrEncryptionKeyPart with all of the key parts *before* loading
     * the spritesheet or decryption will fail and the spritesheet
     * will fail to load.
     *
     * @param index part of the key [0..3]
     * @param value value of the key part
     */
    public native static void setPvrEncryptionKeyPart(int index, @Cast("unsigned int") int value);

    /**
     * Sets the pvr.ccz encryption key.
     * <p/>
     * Example: If the key used to encrypt the pvr.ccz file is
     * 0xaaaaaaaabbbbbbbbccccccccdddddddd you will call this function with
     * the key split into 4 parts as follows
     * <p/>
     * ZipUtils::setPvrEncryptionKey(0xaaaaaaaa, 0xbbbbbbbb, 0xcccccccc, 0xdddddddd);
     * <p/>
     * Note that using this function makes it easier to reverse engineer and
     * discover the complete key because the key parts are present in one
     * function call.
     * <p/>
     * IMPORTANT: Be sure to call setPvrEncryptionKey or
     * setPvrEncryptionKeyPart with all of the key parts *before* loading
     * the spritesheet or decryption will fail and the spritesheet
     * will fail to load.
     *
     * @param keyPart1 the key value part 1.
     * @param keyPart2 the key value part 2.
     * @param keyPart3 the key value part 3.
     * @param keyPart4 the key value part 4.
     */
    public native static void setPvrEncryptionKey(@Cast("unsigned int") int keyPart1, @Cast("unsigned int") int keyPart2, @Cast("unsigned int") int keyPart3, @Cast("unsigned int") int keyPart4);
}
