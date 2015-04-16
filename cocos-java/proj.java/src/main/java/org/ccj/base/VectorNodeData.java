/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d3.NodeData;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("std::vector<NodeData*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorNodeData
    extends Pointer
{
    public native long size();

    private native NodeData at(long i);

    public NodeData get(long i)
    {
        return at(i);
    }

}
