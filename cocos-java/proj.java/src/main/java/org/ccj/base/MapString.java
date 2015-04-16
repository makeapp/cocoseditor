/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

import java.nio.Buffer;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<map>"})
@Name("std::map<std::string,std::string>")
@com.googlecode.javacpp.annotation.Opaque
public class MapString
        extends Pointer {
    public MapString() {
        allocate();
    }

    public MapString(Buffer b) {
        super(b);
    }

    public MapString(Pointer p) {
        super(p);
    }

    private native void allocate();

    public native long size();

    @StdString
    private native String at(@StdString String i);

    //  ptr->insert(pair <std::string, std::string> ((std::string&)adapter0, (std::string&)adapter1));
    private native void insert(@StdString String k, @StdString String i);

    private native void clear();

    public void put(String k, String v) {
        insert(k, v);
    }

    public String get(String k) {
        if (size() > 0) {
            return at(k);
        }
        return null;
    }
}
