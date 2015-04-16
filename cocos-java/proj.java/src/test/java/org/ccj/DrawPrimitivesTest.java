package org.ccj;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class DrawPrimitivesTest extends TestScene {

    public Class[] getLayers() {
        return new Class[]{DrawNewAPITest2.class, DrawNewAPITest.class};
    }

    static public class DrawNewAPITest2 extends TestLayer {

        @Override
        public String getTitle() {
            return "DrawNode";
        }

        @Override
        public String getSubTitle() {
            return "Testing cc.DrawNode API 2";
        }

        @Override
        public void onCreate() {
            super.onCreate();

        /*    DrawNode draw = DrawNode.create();
                this.addChild(draw, 10);
                var winSize = cc.director.getWinSize();
                var centerPos = cc.p(winSize.width / 2, winSize.height / 2);
                //drawSegment
                draw.drawSegment(cc.p(0, 0), cc.p(winSize.width, winSize.height), 1, cc.color(255, 255, 255, 255));
                draw.drawSegment(cc.p(0, winSize.height), cc.p(winSize.width, 0), 5, cc.color(255, 0, 0, 255));

                //drawDot
                draw.drawDot(cc.p(winSize.width / 2, winSize.height / 2), 40, cc.color(0, 0, 255, 128));
                var points = [cc.p(60, 60), cc.p(70, 70), cc.p(60, 70), cc.p(70, 60)];
                for (var i = 0; i < points.length; i++) {
                    var p = points[i];
                    draw.drawDot(p, 4, cc.color(0, 255, 255, 255));
                }
                //drawCircle
                draw.drawCircle(cc.p(winSize.width / 2, winSize.height / 2), 100, 0, 10, false, 6, cc.color(0, 255, 0, 255));
                draw.drawCircle(cc.p(winSize.width / 2, winSize.height / 2), 50, cc.DEGREES_TO_RADIANS(90), 50, true, 2, cc.color(0, 255, 255, 255));

                //draw poly
                //not fill
                var vertices = [cc.p(0, 0), cc.p(50, 50), cc.p(100, 50), cc.p(100, 100), cc.p(50, 100) ];
                draw.drawPoly(vertices, null, 5, cc.color(255, 255, 0, 255));
                var vertices2 = [cc.p(30, 130), cc.p(30, 230), cc.p(50, 200)];
                draw.drawPoly(vertices2, null, 2, cc.color(255, 0, 255, 255));
                //fill
                var vertices3 = [cc.p(60, 130), cc.p(60, 230), cc.p(80, 200)];
                draw.drawPoly(vertices3, cc.color(0, 255, 255, 50), 2, cc.color(255, 0, 255, 255));

                //draw rect
                //not fill
                draw.drawRect(cc.p(120, 120), cc.p(200, 200), null, 2, cc.color(255, 0, 255, 255));
                //fill
                draw.drawRect(cc.p(120, 220), cc.p(200, 300), cc.color(0, 255, 255, 50), 2, cc.color(255, 0, 255, 255));

                // draw quad bezier path
                draw.drawQuadBezier(cc.p(0, winSize.height), cc.p(centerPos.x, centerPos.y), cc.p(winSize.width, winSize.height), 50, 2, cc.color(255, 0, 255, 255));

                // draw cubic bezier path
                draw.drawCubicBezier(cc.p(winSize.width / 2, winSize.height / 2), cc.p(winSize.width / 2 + 30, winSize.height / 2 + 50),
                        cc.p(winSize.width / 2 + 60, winSize.height / 2 - 50), cc.p(winSize.width, winSize.height / 2), 100, 2, cc.color(255, 0, 255, 255));

                //draw cardinal spline
                var vertices4 = [
                cc.p(centerPos.x - 130, centerPos.y - 130),
                        cc.p(centerPos.x - 130, centerPos.y + 130),
                        cc.p(centerPos.x + 130, centerPos.y + 130),
                        cc.p(centerPos.x + 130, centerPos.y - 130),
                        cc.p(centerPos.x - 130, centerPos.y - 130)
                ];
                draw.drawCardinalSpline(vertices4, 0.5, 100, 2, cc.color(255, 255, 255, 255));
            }*/

        }
    }

    static public class DrawNewAPITest extends TestLayer {
        @Override
        public void onCreate() {
            super.onCreate();


        }
    }
}
