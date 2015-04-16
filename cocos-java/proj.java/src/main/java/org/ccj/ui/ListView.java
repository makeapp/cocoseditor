/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UIListView.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class ListView
    extends ScrollView
{
    public ListView(Pointer p)
    {
        super(p);
    }

    public static final int LISTVIEW_GRAVITY_LEFT = 0,
        LISTVIEW_GRAVITY_RIGHT = 1,
        LISTVIEW_GRAVITY_CENTER_HORIZONTA = 2,
        LISTVIEW_GRAVITY_TOP = 3,
        LISTVIEW_GRAVITY_BOTTOM = 4,
        LISTVIEW_GRAVITY_CENTER_VERTICAL = 5;


    public static final int LISTVIEW_ONSELECTEDITEM_START = 0,
        LISTVIEW_ONSELECTEDITEM_END = 1;

    /**
     * Allocates and initializes.
     */
    public native static ListView create();

    /**
     * Sets a item model for listview
     * <p/>
     * A model will be cloned for adding default item.
     *
     * @param model item model for listview
     */
    public native void setItemModel(Widget model);

    /**
     * Push back a default item(create by a cloned model) into listview.
     */
    public native void pushBackDefaultItem();

    /**
     * Insert a default item(create by a cloned model) into listview.
     */
    public native void insertDefaultItem(int index);

    /**
     * Push back custom item into listview.
     */
    public native void pushBackCustomItem(Widget item);

    /**
     * Insert custom item into listview.
     */
    public native void insertCustomItem(Widget item, int index);

    /**
     * Removes the last item of listview.
     */
    public native void removeLastItem();

    /**
     * Removes a item whose index is same as the parameter.
     *
     * @param index of item.
     */
    public native void removeItem(int index);

    public native void removeAllItems();

    /**
     * Returns a item whose index is same as the parameter.
     *
     * @param index of item.
     *
     * @return the item widget.
     */
    public native Widget getItem(int index);

    /**
     * Returns the item container.
     */
//    public native Vector<Widget*>& getItems();

    /**
     * Returns the index of item.
     *
     * @param item the item which need to be checked.
     *
     * @return the index of item.
     */
    public native int getIndex(Widget item);

    /**
     * Changes the gravity of listview.
     *
     * @see ListViewGravity
     */
    public native void setGravity(@Cast("cocos2d::ui::ListView::Gravity") int gravity);

    /**
     * Changes the margin between each item.
     *
     * @param margin
     */
    public native void setItemsMargin(float margin);

//    public native void sortAllChildren();

    public native int getCurSelectedIndex();

    /**
     * Changes scroll direction of scrollview.
     *
     * @param SCROLLVIEW_DIR
     *
     * @see SCROLLVIEW_DIR      SCROLLVIEW_DIR_VERTICAL means vertical scroll, SCROLLVIEW_DIR_HORIZONTAL means horizontal scroll
     */
//    public native void setDirection(@Cast("cocos2d::ui::ScrollView::Direction") int dir);

//    @StdString
//    @Const
//    public native String getDescription();

    public native void requestRefreshView();

    public static ListView cast(Ref ref)
    {
        return cast(ref, ListView.class);
    }

    public void addEventListenerListView(ListViewListener listener)
    {
        ListViewCallback callback = new ListViewCallback(listener);
        addEventListenerListView(callback, callback);
    }

    private native void addEventListenerListView(@Target @Cast("cocos2d::Ref *") ListViewCallback target, ListViewCallback selector);

    public interface ListViewListener
    {
        public void onItemSelected(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_ListViewEvent")
    @Parent("cocos2d::Ref")
    private static class ListViewCallback
        extends FunctionPointer
    {
        ListViewListener listener;

        public ListViewCallback(ListViewListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::ListViewEventType") int eventType)
        {
            if (listener != null) {
                listener.onItemSelected(ref, eventType);
            }
        }
    }
}
