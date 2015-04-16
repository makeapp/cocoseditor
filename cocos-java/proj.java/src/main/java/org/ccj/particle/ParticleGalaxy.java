/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.particle;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-9 下午4:19 $
 *          $Id$
 */

@Platform(include = "CCParticleExamples.h")
@Namespace("cocos2d")

@com.googlecode.javacpp.annotation.Opaque
public class ParticleGalaxy extends ParticleSystemQuad
{
    public native static ParticleGalaxy create();

    public native static ParticleGalaxy createWithTotalParticles(int numberOfParticles);


}
