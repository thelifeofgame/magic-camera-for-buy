package com.example.my9_4;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListPopupWindowAdapter extends BaseAdapter {  
    private List<String> mStringList = new ArrayList<>();  
    private Context mContext;  
    private String nowSeleteName;  
    private int itemHeight;  
  
    public ListPopupWindowAdapter(Context context,List<String> list,String selectName,float height){  
        mContext = context;  
        mStringList = list;  
        nowSeleteName = selectName;  
        itemHeight = (int)height;  
    }  
  
    @Override  
    public int getCount() {  
        return mStringList.size();  
    }  
  
    @Override  
    public Object getItem(int i) {  
        return mStringList.get(i);  
    }  
  
    @Override  
    public long getItemId(int i) {  
        return i;  
    }  
  
    @Override  
    public View getView(int i, View view, ViewGroup viewGroup) {  
        ViewHolder lViewHolder = null;  //一开始为null  
        if(view  == null){  
            lViewHolder = new ViewHolder();  
            view = View.inflate(mContext, R.layout.list_item_rank_title_content,null);  
            lViewHolder.itemTextView = (TextView) view.findViewById(R.id.tv_ranking_title_item);  
            view.setTag(lViewHolder);  
        }else {  
            lViewHolder = (ViewHolder) view.getTag();  
        }  
        //文字内容设置  
        lViewHolder.itemTextView.setText(mStringList.get(i));  
        LinearLayout.LayoutParams lp;  
        lp= (LinearLayout.LayoutParams) lViewHolder.itemTextView.getLayoutParams();  
        lp.height=itemHeight;  
        lViewHolder.itemTextView.setLayoutParams(lp);  
  
        if(mStringList.get(i).equals(nowSeleteName)){  //判断选中项  
            lViewHolder.itemTextView.setTextColor(mContext.getResources().getColor(R.color.contents_text));  
            lViewHolder.itemTextView.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_camera_alt_white_24dp));  
        }else {  
            lViewHolder.itemTextView.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_camera_alt_white_24dp));  
            lViewHolder.itemTextView.setTextColor(mContext.getResources().getColor(R.color.contents_text));  
        }  
        return view;  
    }  
  
    private class ViewHolder {  
        TextView itemTextView;  
  
    }           }  
