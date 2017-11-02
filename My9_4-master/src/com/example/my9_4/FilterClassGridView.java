package com.example.my9_4;



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FilterClassGridView extends BaseAdapter {

	private Context mContext;
	
	private int[] mThumbIDs={R.drawable.filter_thumb_original,R.drawable.filter_thumb_beauty,
			R.drawable.filter_thumb_cool,R.drawable.filter_thumb_brannan,R.drawable.filter_thumb_amoro,
			R.drawable.filter_thumb_sketch,R.drawable.filter_thumb_1977,R.drawable.threshold,
			R.drawable.filter_thumb_romance,R.drawable.hsv};
	
	public FilterClassGridView(Context c) {
		mContext=c;
	}


	@Override
	public int getCount() {
		return mThumbIDs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){
        	imageView=new ImageView(mContext);
        	imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        	imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        	imageView.setPadding(8,8,8,8);
        }else{
        	imageView=(ImageView) convertView;
        }
        imageView.setImageResource(mThumbIDs[position]);
		return imageView;
	}


}
