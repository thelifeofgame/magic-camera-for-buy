package android.support.v4.view;


/**
 * DatasetObserver主要是当注册它的cursor中发生变动时会调用其中的方法，让用户做一些界面刷新等操作。
         首先cursor通过registerDataSetObserver()注册DatasetObserver   当cursor数据有变动时，
         例如调用了cursor的requery()，会调用cursor的onChanged通知用户cursor中的内容有变动，用户可以在
   onChanged里做一些刷新界面的操作。一般会在onChanged里调用notifyDataSetChanged通知framework，
   framework收到通知会调用CursorAdapter的getView来做界面刷新等工作。
        用途：cursor中的数据有变动时通知用户刷新界面。


 * @author Eddie
 *
 */
public final class VerticalViewPagerCompat {
    private VerticalViewPagerCompat() {}

    public interface DataSetObserver extends PagerAdapter.DataSetObserver {}

    public static void setDataSetObserver(PagerAdapter adapter, DataSetObserver observer) {
        adapter.setDataSetObserver(observer);
    }
}
