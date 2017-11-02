package com.example.my9_4;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MyItemClickListener implements OnItemClickListener {
    private int choose;
	public MyItemClickListener(int i) {
		choose=i;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if(choose==0){
			switch(position){
			case 0:
				MainActivity.mActivity.setStart(false);
				break;
			case 1:
				//Toast.makeText( MainActivity.mActivity, "one_two", Toast.LENGTH_SHORT).show();
				MainActivity.mActivity.setId(R.drawable.face1);
				MainActivity.mActivity.setStart(true);
				break;
			case 2:
				//Toast.makeText( MainActivity.mActivity, "one_three", Toast.LENGTH_SHORT).show();
				MainActivity.mActivity.setId(R.drawable.face2);
				MainActivity.mActivity.setStart(true);
				break;
			case 3:
				//Toast.makeText( MainActivity.mActivity, "one_three", Toast.LENGTH_SHORT).show();
				MainActivity.mActivity.setId(R.drawable.face3);
				MainActivity.mActivity.setStart(true);
				break;
			case 4:
				MainActivity.mActivity.setId(R.drawable.face4);
				MainActivity.mActivity.setStart(true);
				break;
			case 5:
				MainActivity.mActivity.setId(R.drawable.face5);
				MainActivity.mActivity.setStart(true);
				break;
			case 6:
				MainActivity.mActivity.setId(R.drawable.face6);
				MainActivity.mActivity.setStart(true);
				break;
			case 7:
				MainActivity.mActivity.setId(R.drawable.face7);
				MainActivity.mActivity.setStart(true);
				break;
			case 8:
				MainActivity.mActivity.setId(R.drawable.face8);
				MainActivity.mActivity.setStart(true);
				break;
			case 9:
				MainActivity.mActivity.setId(R.drawable.face9);
				MainActivity.mActivity.setStart(true);
				break;
			case 10:
				MainActivity.mActivity.setId(R.drawable.face0);
				MainActivity.mActivity.setStart(true);
				break;
			case 11:
				MainActivity.mActivity.setId(R.drawable.glass0);
				MainActivity.mActivity.setStart(true);
				break;
			case 12:
				MainActivity.mActivity.setId(R.drawable.facepig);
				MainActivity.mActivity.setStart(true);
				break;
			case 13:
				MainActivity.mActivity.setId(R.drawable.facet1);
				MainActivity.mActivity.setStart(true);
				break;
			case 14:
				MainActivity.mActivity.setId(R.drawable.facet2);
				MainActivity.mActivity.setStart(true);
				break;
			case 15:
				MainActivity.mActivity.setId(R.drawable.facet3);
				MainActivity.mActivity.setStart(true);
				break;
			case 16:
				MainActivity.mActivity.setId(R.drawable.facet4);
				MainActivity.mActivity.setStart(true);
				break;
			case 17:
				MainActivity.mActivity.setId(R.drawable.haha);
				MainActivity.mActivity.setStart(true);
				break;
			case 18:
				MainActivity.mActivity.setId(R.drawable.dongjing);
				MainActivity.mActivity.setStart(true);
				break;
			case 19:
				MainActivity.mActivity.setId(R.drawable.face10);
				MainActivity.mActivity.setStart(true);
				break;
			case 20:
				MainActivity.mActivity.setId(R.drawable.face12);
				MainActivity.mActivity.setStart(true);
				break;
			default:
				Toast.makeText(MainActivity.mActivity, "one_others", Toast.LENGTH_SHORT).show();
				break;
			}
		//	Toast.makeText( face.ItsFace, "one", Toast.LENGTH_SHORT).show();
			//MainActivity.mActivity.setDetectType(1);
		}else if(choose == 1){
			switch(position){
			case 0:
				MainActivity.mActivity.setId(R.drawable.glass0);
				MainActivity.mActivity.setStart(true);
				break;
			case 1:
				MainActivity.mActivity.setId(R.drawable.glass1);
				MainActivity.mActivity.setStart(true);
				break;
			case 2:
				MainActivity.mActivity.setId(R.drawable.glass2);
				MainActivity.mActivity.setStart(true);
				break;
			case 3:
				MainActivity.mActivity.setId(R.drawable.g1);
				MainActivity.mActivity.setStart(true);
				break;
			case 4:
				MainActivity.mActivity.setId(R.drawable.g2);
				MainActivity.mActivity.setStart(true);
				break;
			case 5:
				MainActivity.mActivity.setId(R.drawable.g3);
				MainActivity.mActivity.setStart(true);
				break;
			case 6:
				MainActivity.mActivity.setId(R.drawable.g4);
				MainActivity.mActivity.setStart(true);
				break;
			case 7:
				MainActivity.mActivity.setId(R.drawable.g6);
				MainActivity.mActivity.setStart(true);
				break;
			case 8:
				MainActivity.mActivity.setId(R.drawable.g8);
				MainActivity.mActivity.setStart(true);
				break;
			case 9:
				MainActivity.mActivity.setId(R.drawable.ear1);
				MainActivity.mActivity.setStart(true);
				break;
			case 10:
				MainActivity.mActivity.setId(R.drawable.ear3);
				MainActivity.mActivity.setStart(true);
				break;
			default:
				Toast.makeText( MainActivity.mActivity, "two_one", Toast.LENGTH_SHORT).show();
				break;
			}
		}
			else{
				switch(position){
				case 0:
					MainActivity.mActivity.setId(R.drawable.hat1);
					MainActivity.mActivity.setStart(true);
					break;
				case 1:
					MainActivity.mActivity.setId(R.drawable.hat2);
					MainActivity.mActivity.setStart(true);
					break;
				case 2:
					MainActivity.mActivity.setId(R.drawable.hat3);
					MainActivity.mActivity.setStart(true);
					break;
				case 3:
					MainActivity.mActivity.setId(R.drawable.hat5);
					MainActivity.mActivity.setStart(true);
					break;
				case 4:
					MainActivity.mActivity.setId(R.drawable.hat7);
					MainActivity.mActivity.setStart(true);
					break;
				case 5:
					MainActivity.mActivity.setId(R.drawable.hat8);
					MainActivity.mActivity.setStart(true);
					break;
				case 6:
					MainActivity.mActivity.setId(R.drawable.hat9);
					MainActivity.mActivity.setStart(true);
					break;
				case 7:
					MainActivity.mActivity.setId(R.drawable.hat10);
					MainActivity.mActivity.setStart(true);
					break;
				default:
					Toast.makeText( MainActivity.mActivity, "two_one", Toast.LENGTH_SHORT).show();
					break;
			}
		//	Toast.makeText( ContextID, "two", Toast.LENGTH_SHORT).show();
			//MainActivity.mActivity.setDetectType(2);
		}
	
	}
}
