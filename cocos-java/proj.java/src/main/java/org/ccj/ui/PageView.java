/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Parent;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Target;
import com.googlecode.javacpp.annotation.Type;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UIPageView.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class PageView
    extends Layout
{
    public PageView(Pointer p)
    {
        super(p);
    }

    public static PageView cast(Ref ref)
    {
        return cast(ref, PageView.class);
    }

    /**
     * Allocates and initializes.
     */
    public native static PageView create();

    /**
     * Add a widget to a page of pageview.
     *
     * @param widget      widget to be added to pageview.
     * @param pageIdx     index of page.
     * @param forceCreate if force create and there is no page exsit, pageview would create a default page for adding widget.
     */
    public native void addWidgetToPage(Widget widget, int pageIdx, boolean forceCreate);

    /**
     * Push back a page to pageview.
     *
     * @param page page to be added to pageview.
     */
    public native void addPage(Layout page);

    /**
     * Inert a page to pageview.
     *
     * @param page page to be added to pageview.
     */
    public native void insertPage(Layout page, int idx);

    /**
     * Remove a page of pageview.
     *
     * @param page page which will be removed.
     */
    public native void removePage(Layout page);

    /**
     * Remove a page at index of pageview.
     *
     * @param index index of page.
     */
    public native void removePageAtIndex(int index);

    public native void removeAllPages();

    /**
     * scroll pageview to index.
     *
     * @param idx index of page.
     */
    public native void scrollToPage(int idx);

    /**
     * Gets current page index.
     *
     * @return current page index.
     */
    public native int getCurPageIndex();

    @ByRef
    public native LayoutVector getPages();

    public native Layout getPage(int index);


//        public native bool onTouchBegan(Touch *touch, Event *unusedEvent) override;
//        public native void onTouchMoved(Touch *touch, Event *unusedEvent) override;
//        public native void onTouchEnded(Touch *touch, Event *unusedEvent) override;
//        public native void onTouchCancelled(Touch *touch, Event *unusedEvent) override;

    //override "update" method of widget.
//        public native void update(float dt) override;

    /**
     * Sets LayoutType.
     *
     * @param LayoutType
     *
     * @see LayoutType
     */
//    public native void setLayoutType(@Cast("cocos2d::ui::Layout::Type") int type);


    /**
     * Gets LayoutType.
     *
     * @return LayoutType
     *
     * @see LayoutType
     */
//    @Cast("int")
//    public native int getLayoutType();


    // event
    public void addEventListenerPageView(PageViewListener selector)
    {
        PageViewCallback callback = new PageViewCallback(selector);
        addEventListenerPageView(callback, callback);
    }


    private native void addEventListenerPageView(@Target @Cast("cocos2d::Ref *") PageViewCallback target, PageViewCallback selector);


    public interface PageViewListener
    {
        public void onTurn(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_PageViewEvent")
    @Parent("cocos2d::Ref")
    private static class PageViewCallback
        extends FunctionPointer
    {
        PageViewListener listener;

        public PageViewCallback(PageViewListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::PageViewEventType") int eventType)
        {
            if (listener != null) {
                listener.onTurn(ref, eventType);
            }
        }
    }
}
