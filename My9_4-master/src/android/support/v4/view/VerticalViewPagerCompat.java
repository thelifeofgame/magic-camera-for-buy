package android.support.v4.view;


/**
 * DatasetObserver��Ҫ�ǵ�ע������cursor�з����䶯ʱ��������еķ��������û���һЩ����ˢ�µȲ�����
         ����cursorͨ��registerDataSetObserver()ע��DatasetObserver   ��cursor�����б䶯ʱ��
         ���������cursor��requery()�������cursor��onChanged֪ͨ�û�cursor�е������б䶯���û�������
   onChanged����һЩˢ�½���Ĳ�����һ�����onChanged�����notifyDataSetChanged֪ͨframework��
   framework�յ�֪ͨ�����CursorAdapter��getView��������ˢ�µȹ�����
        ��;��cursor�е������б䶯ʱ֪ͨ�û�ˢ�½��档


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
