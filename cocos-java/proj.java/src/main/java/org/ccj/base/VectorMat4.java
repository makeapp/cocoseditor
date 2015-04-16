/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Mat4;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("std::vector<Mat4*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorMat4<T>
    extends Pointer
{
    public native long size();

    private native Mat4 at(long i);

    public Mat4 get(long i)
    {
        return at(i);
    }


}
