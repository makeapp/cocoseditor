/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("std::vector<std::string>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorString<T>
    extends Pointer
{
    public native long size();

    @StdString
    private native String at(long i);

    public String get(long i)
    {
        return at(i);
    }

}
