package com.example.my9_4;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class FilterItemClickListener implements OnItemClickListener {
	private int choose;
	public FilterItemClickListener(int i) {
		choose = i;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			switch(position){
			case 0:
				
				MainActivity.mActivity.setCameraIndex(0);
				break;
			case 1:
				
				MainActivity.mActivity.setCameraIndex(1);
				break;
			case 2:
				
				MainActivity.mActivity.setCameraIndex(2);
				break;
			case 3:
				MainActivity.mActivity.setCameraIndex(3);
				break;
            case 4:
				
				MainActivity.mActivity.setCameraIndex(4);
				break;
            case 5:
				
				MainActivity.mActivity.setCameraIndex(5);
				break;
            case 6:
				MainActivity.mActivity.setCameraIndex(6);
				break;
            case 7:
				MainActivity.mActivity.setCameraIndex(7);
				break;
            case 8:
				MainActivity.mActivity.setCameraIndex(8);
				break;
            case 9:
				MainActivity.mActivity.setCameraIndex(9);
				break;
			}
		//	Toast.makeText( face.ItsFace, "one", Toast.LENGTH_SHORT).show();
			//MainActivity.mActivity.setDetectType(1);
		
	}

}
