/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("std::vector<int>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorInt<T>
    extends Pointer
{
    public native long size();

    private native char at(long i);

    public char get(long i)
    {
        return at(i);
    }

    public char[] getChars()
    {
        char[] chars = new char[(int) size()];
        for (int i = 0; i < size(); i++) {
            chars[i] = get(i);
        }
        return chars;
    }

    public byte[] getBytes()
    {
        byte[] chars = new byte[(int) size()];
        for (int i = 0; i < size(); i++) {
            chars[i] = (byte) get(i);
        }
        return chars;
    }
}
