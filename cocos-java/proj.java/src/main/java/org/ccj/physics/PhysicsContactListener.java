/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.event.EventListener;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 20:37 $
 *          $Id$
 */

@Platform(include = "JavaPhysicsContactListener.h")
@Name("ccj::JavaPhysicsContactListener")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsContactListener extends EventListener
{
    public native void regContactBegin();

    public native void regContactPreSolve();

    public native void regContactPostSolve();

    public native void regContactSeperate();

    public PhysicsContactListener(Pointer p)
    {
        super(p);
    }

    public PhysicsContactListener()
    {
        allocate();
        putRef(this);
    }

    @Allocator
    @NoDeallocator
    @Name("ccj::JavaPhysicsContactListener::create")
    public native void allocate();

    private static boolean onContactBegin(long address, long contactAddress)
    {
        PhysicsContactListener listener = (PhysicsContactListener) getRef(address);
        if (listener != null) {
            PhysicsContact physicsContact = new PhysicsContact();
            physicsContact.init(contactAddress, 0, 0);
            return listener.onContactBegin(physicsContact);
        }
        return false;
    }

    public boolean onContactBegin(PhysicsContact contact)
    {
        return false;
    }

    private static boolean onContactPreSolve(long address, long contactAddress, long solveAddress)
    {
        PhysicsContactListener listener = (PhysicsContactListener) getRef(address);
        if (listener != null) {
            PhysicsContact physicsContact = new PhysicsContact();
            physicsContact.init(contactAddress, 0, 0);

            PhysicsContactPreSolve preSolve = new PhysicsContactPreSolve();
            preSolve.init(solveAddress, 0, 0);

            return listener.onContactPreSolve(physicsContact, preSolve);
        }
        return false;
    }

    public boolean onContactPreSolve(PhysicsContact contact, PhysicsContactPreSolve solve)
    {
        return false;
    }

    public static void onContactPostSolve(long address, long contactAddress, long solveAddress)
    {
        PhysicsContactListener listener = (PhysicsContactListener) getRef(address);
        if (listener != null) {
            PhysicsContact physicsContact = new PhysicsContact();
            physicsContact.init(contactAddress, 0, 0);

            PhysicsContactPostSolve preSolve = new PhysicsContactPostSolve();
            preSolve.init(solveAddress, 0, 0);

            listener.onContactPostSolve(physicsContact, preSolve);
        }
        return;
    }

    public void onContactPostSolve(PhysicsContact contact, PhysicsContactPostSolve solve)
    {

    }

    private static void onContactSeperate(long address, long contactAddress)
    {
        PhysicsContactListener listener = (PhysicsContactListener) getRef(address);
        if (listener != null) {
            PhysicsContact physicsContact = new PhysicsContact();
            physicsContact.init(contactAddress, 0, 0);
            listener.onContactSeperate(physicsContact);
        }
    }

    public void onContactSeperate(PhysicsContact contact)
    {

    }
}
