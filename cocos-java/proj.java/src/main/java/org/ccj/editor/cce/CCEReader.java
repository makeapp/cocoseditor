/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.editor.cce;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.Component;
import org.ccj.Director;
import org.ccj.Logger;
import org.ccj.Scene;
import org.ccj.base.Ref;
import org.ccj.base.VectorNode;
import org.ccj.base.VectorString;
import org.ccj.d2.Label;
import org.ccj.d2.Layer;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.Node;
import org.ccj.d2.Sprite;
import org.ccj.physics.*;
import org.ccj.ui.Widget;
import org.ccj.util.StringUtil;
import org.fun.Function;
import org.fun.FunctionFactory;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCEReader.h")
@Name("cce::CCEReader")
@com.googlecode.javacpp.annotation.Opaque
public class CCEReader
        extends org.ccj.base.Ref {
    Map<String, Component> components = new HashMap();

    static {
        FunctionFactory.registerFunction("runScene", new Function<String, String>() {
            @Override
            public String apply(String s) {
                Scene scene = getTransitionScene(s);
                if (scene != null) {
                    Director.getInstance().runWithScene(scene);
                }
                return "";
            }
        });

        FunctionFactory.registerFunction("replaceScene", new Function<String, String>() {
            @Override
            public String apply(String s) {
                Scene scene = getTransitionScene(s);
                if (scene != null) {
                    Director.getInstance().replaceScene(scene);
                }
                return "";
            }
        });

        FunctionFactory.registerFunction("pushScene", new Function<String, String>() {
            @Override
            public String apply(String s) {
                Scene scene = getTransitionScene(s);
                if (scene != null) {
                    Director.getInstance().pushScene(scene);
                }
                return "";
            }
        });
    }

    public CCEReader() {

    }

    private static Scene getTransitionScene(String param) {
        String[] args = param.split(" ");
        CCEReader reader = create();
        Scene scene = null;
        if (args.length > 0) {
            scene = reader.readScene(args[0]);
        }
        if(args.length > 1){
//            TransitionJumpZoom
        }
        return scene;
    }

    public native static CCEReader create();

    /**
     * Creates a sprite with an image filename and a rect.
     *
     * @param filename The string wich indicates a path to image file, e.g., "scene1/monster.png"
     * @return A valid sprite object that is marked as autoreleased.
     */
    private native org.ccj.base.Ref read(@StdString String filename);

    @ByVal
    public native VectorString getComponentNames();

    @ByRef
    public native VectorNode getComponentNodes(@StdString String name);

    public native org.ccj.d2.Node getNode(int tag);

    public native Sprite getSprite(int tag);

    public native Sprite getSprite(@StdString String name);

    public native Layer getLayer(int tag);

    public native Layer getLayer(@StdString String name);

    public native Scene getScene(int tag);

    public native Scene getScene(@StdString String name);

    public native Menu getMenu(int tag);

    public native Menu getMenu(@StdString String name);

    public native CCEAnimation getAnimation(int tag);

    public native CCEAnimation getAnimation(@StdString String name);

    public native Label getLabel(int tag);

    public native Label getLabel(@StdString String name);

    public native MenuItem getMenuItem(int tag);

    public native MenuItem getMenuItem(@StdString String name);

    public native Widget getWidget(int tag);

    public native Widget getWidget(@StdString String name);

//    public native CCEReader getNodeReader(int tag);

//    public native CCEReader getNodeReader(@StdString String name);

    public native org.ccj.base.Ref getRef(int tag);

    public native org.ccj.base.Ref getRef(@StdString String tag);

    public native PhysicsBody getPhysicsBody(int tag);

    public native PhysicsJoint getPhysicsJoint(int tag);

    public native PhysicsShape getPhysicsShape(int tag);

    public native PhysicsJointDistance getPhysicsJointDistance(int tag);

    public native PhysicsJointFixed getPhysicsJointFixed(int tag);

    public native PhysicsJointGear getPhysicsJointGear(int tag);

    public native PhysicsJointGroove getPhysicsJointGroove(int tag);

    public native PhysicsJointLimit getPhysicsJointLimit(int tag);

    public native PhysicsJointMotor getPhysicsJointMotor(int tag);

    public native PhysicsJointPin getPhysicsJointPin(int tag);

    public native PhysicsJointRatchet getPhysicsJointRatchet(int tag);

    public native PhysicsJointRotaryLimit getPhysicsJointRotaryLimit(int tag);

    public native PhysicsJointRotarySpring getPhysicsJointRotarySpring(int tag);

    public native PhysicsJointSpring getPhysicsJointSpring(int tag);

    public native PhysicsShapeBox getPhysicsShapeBox(int tag);

    public native PhysicsShapeCircle getPhysicsShapeCircle(int tag);

    public native PhysicsShapeEdgeBox getPhysicsShapeEdgeBox(int tag);

    public native PhysicsShapeEdgeChain getPhysicsShapeEdgeChain(int tag);

    public native PhysicsShapeEdgePolygon getPhysicsShapeEdgePolygon(int tag);

    public native PhysicsShapeEdgeSegment getPhysicsShapeEdgeSegment(int tag);

    public native PhysicsShapePolygon getPhysicsShapePolygon(int tag);

    public native void playAutoAnimations();

    public native void playAnimation(@StdString String name);

    public native void playAnimation(int tag);

    public native void stopAnimation(int tag);

    /**
     * Stop the action.
     */
    public native void stopAnimation(@StdString String name);

    public native void stopAllAnimation();

    public Layer readLayer(@StdString String filename) {
        return Layer.cast(readNode(filename));
    }

    public Scene readScene(@StdString String filename) {
        return Scene.cast(readNode(filename));
    }

    public Menu readMenu(@StdString String filename) {
        return Menu.cast(readNode(filename));
    }

    public Widget readWidget(@StdString String filename) {
        return Widget.cast(readNode(filename));
    }

    public Label readLabel(@StdString String filename) {
        return Label.cast(readNode(filename));
    }

    public Sprite readSprite(@StdString String filename) {
        Node node = readNode(filename);
        Sprite sprite = Sprite.cast(node);
        //Logger.log("Sprite "+sprite);
        return sprite;
    }

    public CCEAnimation readAnimation(@StdString String filename, int size) {
        CCEAnimation nodeAnimation = readAnimation(filename);
        if (nodeAnimation != null) {
            nodeAnimation.createPooledActions(size);
        }
        return nodeAnimation;
    }

    public CCEAnimation readAnimation(@StdString String filename) {
        return CCEAnimation.cast(read(filename));
    }

    public org.ccj.d2.Node readNode(@StdString String filename) {
        Ref ref = read(filename);
        //Logger.log("ref "+ref);
        org.ccj.d2.Node rootNode = Node.cast(ref);
        //Logger.log("Node "+rootNode);
        readComponents();
        playAutoAnimations();
        //Logger.log("Node "+rootNode);
        return rootNode;
    }

    private void readComponents() {
        VectorString names = getComponentNames();
        components = new HashMap();
        boolean avianVm = System.getProperty("avian.version") != null;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            VectorNode nodes = getComponentNodes(name);
            for (int j = 0; j < nodes.size(); j++) {
                org.ccj.d2.Node node = nodes.get(j);
                final Component javaCom = newInstance(name);
                if (javaCom != null) {
                    components.put(name, javaCom);
                    javaCom.setName(name);
                    javaCom.onCreate();
                    if (javaCom instanceof CCEController) {
                        ((CCEController) javaCom).setReader(this);
                    }

                    if (avianVm) {
                        bindAvianFields(javaCom);
                        bindAvianActionMethods(javaCom);
                    } else {
                        bindFields(javaCom);
                        bindActionMethods(javaCom);
                    }

                    node.addComponent(javaCom);
                }
            }
        }
    }

    private void bindActionMethods(final Component javaCom) {
        Method[] methods = javaCom.getClass().getMethods();
        for (final Method method : methods) {
            CCEBind bind = method.getAnnotation(CCEBind.class);
            CCEAction action = method.getAnnotation(CCEAction.class);
            if (action != null && bind != null) {
                if (CCEAction.ActionType.WidgetTouch.equals(action.value())) {
                    Widget widget = getBindWidget(bind);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                try {
                                    method.invoke(javaCom, ref, action);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } else if (CCEAction.ActionType.WidgetTouchDown.equals(action.value())) {
                    Widget widget = getBindWidget(bind);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 0) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if (CCEAction.ActionType.WidgetTouchUp.equals(action.value())) {
                    Widget widget = getBindWidget(bind);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 2) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if (CCEAction.ActionType.WidgetTouchMove.equals(action.value())) {
                    Widget widget = getBindWidget(bind);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 1) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if (CCEAction.ActionType.MenuItemClicked.equals(action.value())) {
                    MenuItem menuItem = this.getBindMenuItem(bind);
                    if (menuItem != null) {
                        menuItem.setOnClickListener(new MenuItem.MenuItemListener() {
                            public void onClicked(MenuItem item) {
                                try {
                                    method.invoke(javaCom, item);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }
    }


    private void bindAvianActionMethods(final Component javaCom) {
        Method[] methods = javaCom.getClass().getMethods();
        for (final Method method : methods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
//            Logger.log(method.toString());
            String desc = method.toString();
            String[] anns = StringUtil.toStringArray(desc, '|');
            int bindTag = 0;
            String bindName = null, action = null;
            for (String ann : anns) {
                String[] values = StringUtil.toStringArray(ann, ',');
                if (values.length > 1) {
                    for (int i = 0; i < values.length; i++) {
                        if (i > 1) {
                            if (values[1].indexOf(CCEBind.class.getName()) > 0) {
                                if ("value".equalsIgnoreCase(values[i - 1])) {
                                    bindName = values[i];
                                } else if ("tag".equalsIgnoreCase(values[i - 1])) {
                                    bindTag = Integer.parseInt(values[i]);
                                }
                            } else if (values[1].indexOf(CCEAction.class.getName()) > 0) {
                                if ("value".equalsIgnoreCase(values[i - 1])) {
                                    action = values[i];
                                }
                            }
                        }
                    }
                }
            }
//            Logger.log("bind method " + action + " " + bindName + " " + bindTag);
            if (action != null) {
                if ("WidgetTouch".equals(action)) {
                    Widget widget = getBindWidget(bindTag, bindName);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                try {
                                    method.invoke(javaCom, ref, action);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } else if ("WidgetTouchDown".equals(action)) {
                    Widget widget = getBindWidget(bindTag, bindName);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 0) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if ("WidgetTouchUp".equals(action)) {
                    Widget widget = getBindWidget(bindTag, bindName);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 2) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if ("WidgetTouchMove".equals(action)) {
                    Widget widget = getBindWidget(bindTag, bindName);
                    if (widget != null) {
                        widget.addTouchEventListener(new Widget.TouchEventListener() {
                            public void onTouch(org.ccj.base.Ref ref, int action) {
                                if (action == 1) {
                                    try {
                                        method.invoke(javaCom, ref);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                } else if ("MenuItemClicked".equals(action)) {
                    MenuItem menuItem = this.getBindMenuItem(bindTag, bindName);
                    if (menuItem != null) {
                        menuItem.setOnClickListener(new MenuItem.MenuItemListener() {
                            public void onClicked(MenuItem item) {
                                try {
                                    method.invoke(javaCom, item);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void bindFields(Component javaCom) {
        Field[] fields = javaCom.getClass().getFields();
        for (Field filed : fields) {
            CCEBind bind = filed.getAnnotation(CCEBind.class);
            if (bind != null) {
                try {
                    Ref node = getBindRef(bind, filed.getName());
                    if (node != null) {
                        Class clazz = filed.getType();
                        node = (org.ccj.base.Ref) org.ccj.base.Ref.cast(node, clazz);
                        filed.set(javaCom, node);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void bindAvianFields(Component javaCom) {
        Field[] fields = javaCom.getClass().getFields();
        for (Field filed : fields) {

//            Logger.log("" + filed);
            String filedDesc = filed.toString();
            String[] anns = StringUtil.toStringArray(filedDesc, '|');
            for (String ann : anns) {
                String[] values = StringUtil.toStringArray(ann, ',');
                String value = null, name = null;
                int tag = 0;

                for (int i = 0; i < values.length; i++) {
                    if (i == 1) {
                        name = values[i];
                    } else if (i > 1) {
                        if ("value".equalsIgnoreCase(values[i - 1])) {
                            value = values[i];
                        } else if ("tag".equalsIgnoreCase(values[i - 1])) {
                            tag = Integer.parseInt(values[i]);
                        }
                    }
                }
                if (name != null && name.indexOf(CCEBind.class.getName()) > 0) {
                    try {
                        Ref node = getBindRef(tag, value, filed.getName());
                        if (node != null) {
//                            Logger.log("Bind field value " + node);
                            Class clazz = filed.getType();
                            node = (Ref) Ref.cast(node, clazz);
                            filed.set(javaCom, node);
                        } else {
                            Logger.log("invalid Bind  " + tag + " " + value + " " + filed.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            Logger.log(filed.toString());
        }
    }

    private Ref getBindRef(CCEBind bind, String defName) {
        int tag = bind.tag();
        Ref node = null;
        if (tag > 0) {
            node = this.getRef(tag);
        }
        if (node == null) {
            String name = bind.value();
            if (name != null && name.length() > 0) {
                node = this.getRef(name);
            } else {
                node = this.getRef(defName);
            }
        }
        return node;
    }

    private Ref getBindRef(int tag, String name, String defName) {
        Ref node = null;
        if (tag > 0) {
            node = this.getRef(tag);
        }
        if (node == null) {
            if (name != null && name.length() > 0) {
                node = this.getRef(name);
            } else {
                node = this.getRef(defName);
            }
        }
        return node;
    }

    private Widget getBindWidget(CCEBind bind) {
        int tag = bind.tag();
        Widget node = null;
        if (tag > 0) {
            node = this.getWidget(tag);
        }
        String name = bind.value();
        if (name != null && name.length() > 0) {
            node = this.getWidget(name);
        }
        return node;
    }

    private Widget getBindWidget(int tag, String name) {
        Widget node = null;
        if (tag > 0) {
            node = this.getWidget(tag);
        }
        if (name != null && name.length() > 0) {
            node = this.getWidget(name);
        }
        return node;
    }

    private MenuItem getBindMenuItem(CCEBind bind) {
        int tag = bind.tag();
        MenuItem node = null;
        if (tag > 0) {
            node = this.getMenuItem(tag);
        }
        String name = bind.value();
        if (name != null && name.length() > 0) {
            node = this.getMenuItem(name);
        }
        return node;
    }

    private MenuItem getBindMenuItem(int tag, String name) {
        MenuItem node = null;
        if (tag > 0) {
            node = this.getMenuItem(tag);
        }
        if (name != null && name.length() > 0) {
            node = this.getMenuItem(name);
        }
        return node;
    }

    private static Component newInstance(String name) {
        try {
            Class clazz = Class.forName(name);
            if (clazz != null) {
                return (Component) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Component getComponent(String name) {
        return components.get(name);
    }

    public <T extends Component> T getComponent(Class<T> tClass) {
        return (T) getComponent(tClass.getName());
    }

    public static CCEReader cast(org.ccj.base.Ref node) {
        return cast(node, CCEReader.class);
    }


    public CCEController showNode(Node parent, String file, String componentName) {
        Node root = readNode(file);
        if (parent != null) {
            root.setLocalZOrder(1000);
            parent.addChild(root);
        }
        return (CCEController) getComponent(componentName);
    }

    public CCEController showNode(Node parent, String file) {
        Node root = readNode(file);
        if (parent != null) {
            root.setLocalZOrder(1000);
            parent.addChild(root);
        }
        return (CCEController) components.values().iterator().next();
    }
}
