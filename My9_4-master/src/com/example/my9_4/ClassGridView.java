package com.example.my9_4;



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ClassGridView extends BaseAdapter {

	private int choose;
	private Context mContext;
	
	private int[] mThumbIDs_one={R.drawable.filter_thumb_sweets,R.drawable.face1,
			R.drawable.face2,R.drawable.face3,R.drawable.face4,
			R.drawable.face5,R.drawable.face6,R.drawable.face7,
			R.drawable.face8,R.drawable.face9,R.drawable.face0,
			R.drawable.glass0,R.drawable.facepig,R.drawable.facet1,
			R.drawable.facet2,R.drawable.facet3,R.drawable.facet4,
			R.drawable.haha,R.drawable.dongjing,R.drawable.face10,R.drawable.face12};
	private int[] mThumbIDs_two={R.drawable.glass0,R.drawable.glass1,
			R.drawable.glass2,R.drawable.g1,R.drawable.g2,
			R.drawable.g3,R.drawable.g4,R.drawable.g6,
			R.drawable.g8,R.drawable.ear1,R.drawable.ear3};
	private int[] mThumbIDs_three={R.drawable.hat1,R.drawable.hat2,
			R.drawable.hat3,R.drawable.hat5,R.drawable.hat7,
			R.drawable.hat8,R.drawable.hat9,R.drawable.hat10,};
	public ClassGridView(Context c, int i) {
		mContext=c;
		choose=i;
	}


	@Override
	public int getCount() {
		int length=0;
		if(choose==0)
			length=mThumbIDs_one.length;
		else if(choose == 1 )
			length=mThumbIDs_two.length;
		else 
			length = mThumbIDs_three.length;
		return length;
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
        if(choose==0)
		   imageView.setImageResource(mThumbIDs_one[position]);
        else if(choose == 1)
           imageView.setImageResource(mThumbIDs_two[position]);
        else
        	imageView.setImageResource(mThumbIDs_three[position]);
		return imageView;
	}


}
