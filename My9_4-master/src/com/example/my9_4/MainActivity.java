package com.example.my9_4;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import com.example.cruve.CrossProcessCurveFilter;
import com.example.cruve.PortraCurveFilter;
import com.example.cruve.ProviaCurveFilter;
import com.example.cruve.VelviaCurveFilter;
import com.example.ercode.android.CaptureActivity;
import com.example.filter.Filter;
import com.example.filter.NoneFilter;
import com.example.mixer.RecolorCMVFilter;
import com.example.mixer.RecolorRCFilter;
import com.example.mixer.RecolorRGVFilter;
import com.example.my9_4.R.layout;
import com.example.myPathbutton.composerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.ImageView;
public class MainActivity extends Activity implements CvCameraViewListener2, OnClickListener{
	static MainActivity mActivity;
	MySurfaceView mGLSurfaceView;
	RelativeLayout mRelativeLayout;
	

String g1 = "https://item.taobao.com/item.htm?id=524776721500&ali_trackid=2:mm_29924319_9258288_31180758:1507879275_280_1924951694&spm=a311n.8189758%2Fa.90200000.2.6267a9fcQv40kA#";
String g2 = "https://detail.tmall.com/item.htm?id=546698151129&ali_trackid=2:mm_26632402_0_0:1507879492_279_2105698925&spm=a231o.7712113/a.1004.366&pvid=200_11.227.218.20_1412_1507879250533";
String g3 = "https://item.taobao.com/item.htm?id=41784799993&ali_trackid=2:mm_26632402_0_0:1507879618_202_1611016269&spm=a231o.7712113%2Fa.1004.162&pvid=200_11.227.218.20_1412_1507879250533";
String g4 = "https://item.taobao.com/item.htm?id=528679095771&ali_trackid=2:mm_26632402_0_0:1507879732_278_1150964998&spm=a231o.7712113%2Fa.1004.211&pvid=200_11.227.218.20_1412_1507879250533";
String g5 = "https://detail.tmall.com/item.htm?spm=a230r.1.14.99.7fc71d28oeuS9f&id=539105002690&ns=1&abbucket=2";
String g6 = "https://item.taobao.com/item.htm?spm=a230r.1.14.26.7fc71d28oeuS9f&id=559717476098&ns=1&abbucket=2#detail ";
String g7 = "https://item.taobao.com/item.htm?spm=a230r.1.14.46.7fc71d28oeuS9f&id=559833505075&ns=1&abbucket=2#detail";
String g8 = "https://item.taobao.com/item.htm?spm=a230r.1.14.26.7fc71d28oeuS9f&id=559717476098&ns=1&abbucket=2#detail";
String ear1 = "https://detail.tmall.com/item.htm?spm=a230r.1.14.210.386b652f5dcyKs&id=552681922777&ns=1&abbucket=2&sku_properties=5919063:6536025";
String ear2 = "https://detail.tmall.com/item.htm?spm=a230r.1.14.224.386b652f5dcyKs&id=548288426878&ns=1&abbucket=2&sku_properties=5919063:6536025";
String ear3 = "https://detail.tmall.com/item.htm?spm=a230r.1.14.155.386b652f5dcyKs&id=35543745350&ns=1&abbucket=2&sku_properties=5919063:6536025";
String hat1 = "https://item.taobao.com/item.htm?spm=a230r.1.14.34.5f8cd4407rCScL&id=529453952623&ns=1&abbucket=2#detail"; 
String hat2 = "https://item.taobao.com/item.htm?spm=a230r.1.14.158.5f8cd4407rCScL&id=529288723682&ns=1&abbucket=2#detail";
String hat3 = "https://item.taobao.com/item.htm?spm=a230r.1.14.158.5f8cd4407rCScL&id=529288723682&ns=1&abbucket=2#detail";
String hat4 = "https://item.taobao.com/item.htm?spm=a230r.1.14.289.5f8cd4407rCScL&id=553099501970&ns=1&abbucket=2#detail";
String hat5 = "https://item.taobao.com/item.htm?spm=a230r.1.14.289.5f8cd4407rCScL&id=553099501970&ns=1&abbucket=2#detail";
String hat6 = "https://item.taobao.com/item.htm?spm=a230r.1.14.289.5f8cd4407rCScL&id=553099501970&ns=1&abbucket=2#detail";
String hat7 = "https://detail.tmall.com/item.htm?spm=a220o.1000855.w5003-15716766292.15.3029556evfonzt&id=538580482023&scene=taobao_shop";
String hat8 = "https://detail.tmall.com/item.htm?spm=a230r.1.14.258.5f8cd4407rCScL&id=557538238189&ns=1&abbucket=2#"; 
String hat9 = "https://item.taobao.com/item.htm?spm=a230r.1.14.258.5f8cd4407rCScL&id=554372409812&ns=1&abbucket=2#detail";
String hat10 ="https://detail.tmall.com/item.htm?spm=a230r.1.14.232.5f8cd4407rCScL&id=527703639002&ns=1&abbucket=2&sku_properties=20509:4054751";
String face0 ="https://item.taobao.com/item.htm?id=557570519773&ali_trackid=2:mm_26632402_0_0:1507880484_2k4_296273937&spm=a231o.7712113%2Fa.1004.310&pvid=200_10.177.88.114_321_1507880440695";
String face6 ="https://item.taobao.com/item.htm?id=42568089221&ali_trackid=2:mm_26632402_0_0:1507880451_3k8_451048595&spm=a231o.7712113%2Fa.1004.109&pvid=200_10.177.88.114_321_1507880440695";
String faceT = "https://item.taobao.com/item.htm?id=524091533304&ali_trackid=2:mm_26632402_0_0:1507880549_241_1219774572&spm=a231o.7712113%2Fa.1004.284&pvid=200_10.177.88.114_321_1507880440695";
String face3 = "https://detail.tmall.com/item.htm?id=524998726648&ali_trackid=2:mm_26632402_0_0:1507880847_250_299725378&spm=a231o.7712113/a.1004.468&pvid=200_10.177.88.114_321_1507880440695";
String face4 = "https://detail.tmall.com/item.htm?id=524998726648&ali_trackid=2:mm_26632402_0_0:1507880847_250_299725378&spm=a231o.7712113/a.1004.468&pvid=200_10.177.88.114_321_1507880440695";
String face5 = "https://detail.tmall.com/item.htm?id=524998726648&ali_trackid=2:mm_26632402_0_0:1507880847_250_299725378&spm=a231o.7712113/a.1004.468&pvid=200_10.177.88.114_321_1507880440695";
String face7 = "https://item.taobao.com/item.htm?id=35109570211&ali_trackid=2:mm_26632402_0_0:1507881804_3k7_1429825292&spm=a231o.7712113%2Fa.1004.217&pvid=200_11.224.194.87_11082_1507881793429";
String face12 = "https://item.taobao.com/item.htm?id=520471491256&ali_trackid=2:mm_26632402_0_0:1507880986_210_1010840808&spm=a231o.7712113%2Fa.1004.750&pvid=200_10.177.88.114_321_1507880440695";
String face8 = "https://detail.tmall.com/item.htm?id=550601799624&ali_trackid=2:mm_26632402_0_0:1507881034_3k3_1164035181&spm=a231o.7712113%2Fa.1004.699&pvid=200_10.177.88.114_321_1507880440695";
String face10 = "https://detail.tmall.com/item.htm?id=550601799624&ali_trackid=2:mm_26632402_0_0:1507881034_3k3_1164035181&spm=a231o.7712113%2Fa.1004.699&pvid=200_10.177.88.114_321_1507880440695";
String glass1 = "https://detail.tmall.com/item.htm?id=13208718522&ali_trackid=2:mm_26632402_0_0:1507881992_3k7_2033546486&spm=a231o.7712113/a.1004.209&pvid=200_11.224.194.90_323_1507881984762";
String glass2 = "https://item.taobao.com/item.htm?id=525932216471&ali_trackid=2:mm_26632402_0_0:1507881186_249_689890870&spm=a231o.7712113%2Fa.1004.1069&pvid=200_10.177.88.114_321_1507880440695";
String facepig = "https://item.taobao.com/item.htm?id=37516844760&ali_trackid=2:mm_26632402_0_0:1507881302_241_679962670&spm=a231o.7712113%2Fa.1004.2032&pvid=200_10.177.88.114_321_1507880440695";
String face9 =  "https://item.taobao.com/item.htm?id=544709802711&ali_trackid=2:mm_26632402_0_0:1507881411_2k4_1541702718&spm=a231o.7712113%2Fa.1004.2284&pvid=200_10.177.88.114_321_1507880440695";
String dongjing = "https://item.taobao.com/item.htm?id=543603035202&ali_trackid=2:mm_26632402_0_0:1507881515_214_841708386&spm=a231o.7712113%2Fa.1004.2585&pvid=200_10.177.88.114_321_1507880440695";
String haha = "https://item.taobao.com/item.htm?id=544181842529&ali_trackid=2:mm_26632402_0_0:1507881661_278_1230328104&spm=a231o.7712113%2Fa.1004.3838&pvid=200_10.177.88.114_321_1507880440695";


	private static final String DECODED_CONTENT_KEY = "codedContent";
	private static final int REQUEST_CODE_SCAN = 0x0000;
	private CameraBridgeViewBase mCameraView;
    private static final String TAG = "CameraActivity";
    private static final double SCALE_FACTOR = 1.2;
    private static final int MIN_NEIGHBORS = 3;
    private static final int FLAGS = Objdetect.CASCADE_SCALE_IMAGE;
    private static final double MIN_SIZE_PROPORTIONAL = 0.25;
    private static final double MAX_SIZE_PROPORTIONAL = 1.0;
    private static final double MASK_PADDING_PROPORTIONAL = 0.15;
    private static final double MIN_SHAKE_DIST_PROPORTIONAL = 0.04;
    private static final double MIN_NOD_DIST_PROPORTIONAL = 0.005;
    private static final double MIN_BACK_AND_FORTH_COUNT = 2;
    private int mImageWidth;
    private int mImageHeight;
    private Mat mGrayUnoriented;
    private Mat mEqualizedGray;
    private Mat mLastEqualizedGray;
    private Mat mMask;
    private Scalar mMaskForegroundColor;
    private Scalar mMaskBackgroundColor;
    private CascadeClassifier mFaceDetector;
    private CascadeClassifier mEyesDetector;
    private CascadeClassifier mMouthDetector;
    private MatOfRect mFaces;
    private MatOfRect mEyes;
    private MatOfRect mMouth;
    private Size mMinSize;
    private Size mMaxSize;
    private Size mMinSize_e;
    private Size mMaxSize_e;
    private Size mMinSize_m;
    private Size mMaxSize_m;
    private MatOfPoint2f mFeatures;
    private MatOfPoint2f mLastFeatures;
 // Whether a face was being tracked last frame.
    private boolean mWasTrackingFace;
    private int Width = 0;
    private int Height = 0;
    // Colors for drawing.
    private Scalar mFaceRectColor;
    private Scalar mEyesRectColor;
    private Scalar mMouthRectColor;
    private Scalar mFeatureColor;
    
    private LinearLayout filterLayout;
    private RelativeLayout pathbutton;
    private LayoutInflater inflater;
    private ImageButton clickAndDoing;
    private LinearLayout bottom;
    private LinearLayout bottom_bar;
    private LinearLayout FilterChoose;
    private ViewPager viewPager;
    private ViewPager FilterViewPaper;
	private ArrayList<View> viewList;
	private ArrayList<View> FilterViewList;
    private PagerAdapter pagerAdapter;
    private PagerAdapter FilterPagerAdapter;
    private static final int[] pages = {R.layout.first_fragment_view,R.layout.second_fragment_view,R.layout.second_fragment_view};
    LayoutParams para = null;  
    private int DetectType = 0;
    private int FrameCount=2;
    private int flag_camId = 0;
    int count1 = 0,count1_1 = 0;
    int count2 = 0,count2_2 
    		= 0;
    int id = 0;
    private boolean start = false;
    int Id = R.drawable.face0;
   // int Id = 0;
    private ImageView imageView = null;
    Matrix matrix = new Matrix();
    private Filter[] mCurveFilters;
    private Filter[] mMixerFilters;
    private int mMixerFilterIndex = 0;
    private int mCurveFilterIndex = 0;
    FrameLayout filterSwitch;
    ImageButton TakePhoto;
    ImageButton browserButton;
    RelativeLayout topButton;
    RelativeLayout topButton1;
    boolean mIsPhotoPending = false;
    boolean mIsMenuLocked = true;
    boolean GoToStore = false;
    int flag_cam = 1;
    private Camera m_Camera = null;  
    private int w_screen;
    private int h_screen;
    private int havaphoto = 0;
    String index = "https://www.baidu.com";
    Uri uri;
    private PopupWindow mPopupWindow;
    private String[] name;
    public void setDetectType(int DetectType){
    	this.DetectType=DetectType;
    }
    public void setId(int Id){
    	this.Id=Id;
    }
    public void setStart(boolean start){
    	this.start = start;
    }
    public void setCameraIndex(int mCurveFilterIndex){
    	this.mCurveFilterIndex = mCurveFilterIndex;
    }
	    
    private BaseLoaderCallback mLoaderCallback =
            new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(final int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                   // Log.d("test", "hello");
                	mCameraView.enableView();
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };    
	private Handler handler =new Handler(){
		public void handleMessage(Message msg){
			
			switch(msg.what){
			case 1:
				id++;
				Bitmap bmp;
				int startX = 0;
				int startY = 0;
				float scaleWidth = 0;
				float scaleHeight = 0;
				bmp = BitmapFactory.decodeResource(getResources(), Id);
				imageView=new ImageView(MainActivity.this,Id);
				int bmpheight = bmp.getHeight();
				int bmpwidth = bmp.getWidth();
				switch (Id) {
				case R.drawable.glass0:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.6);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.glass1:
					scaleWidth = (float) ((float)Width*1.8);
					scaleHeight = (float) ((float)Height*6.8);
					startX = msg.arg1-Width*11/10;
					startY = msg.arg2-Height*5;
					break;
				case R.drawable.glass2:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*3.2);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height;
					break;
				case R.drawable.g1:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.8);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.g2:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.8);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.g3:
					scaleWidth = (float) ((float)Width*1.7);
					scaleHeight = (float) ((float)Height*2.1);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.g4:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.8);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.g6:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.8);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.g8:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*1.8);
					startX = msg.arg1-Width;
					startY = msg.arg2-Height/2;
					break;
				case R.drawable.face0:
					scaleWidth = (float) ((float)Width*2.2);
					scaleHeight = (float) ((float)Height*11.0);
					startX = msg.arg1-Width*26/20;
					startY = msg.arg2-Height*4;
					break;
				case R.drawable.face1:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*20/20;
					startY = msg.arg2-Height*10/3;
					break;
				case R.drawable.face2:
					scaleWidth = (float) ((float)Width*1.8);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*21/20;
					startY = msg.arg2-Height*10/3;
					break;
				case R.drawable.face3:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*7.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*6/3;
					break;
				case R.drawable.face4:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*7.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*6/3;
					break;
				case R.drawable.face5:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*7.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*6/3;
					break;
				case R.drawable.face6:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*7.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*6/3;
					break;
				case R.drawable.face7:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*11/2;
					break;
				case R.drawable.face8:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*8/3;
					break;
				case R.drawable.face9:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*10/3;
					break;
				case R.drawable.face10:
					scaleWidth = (float) ((float)Width*1.6);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*19/20;
					startY = msg.arg2-Height*8/3;
					break;
				case R.drawable.face12:
					scaleWidth = (float) ((float)Width*2.4);
					scaleHeight = (float) ((float)Height*9.0);
					startX = msg.arg1-Width*28/20;
					startY = msg.arg2-Height*12/3;
					break;
					//10.19 13:01
				case R.drawable.haha:
					scaleWidth = (float) ((float)Width*1.9);
					scaleHeight = (float) ((float)Height*8.0); 
					startX = msg.arg1-Width*21/20;
					startY = msg.arg2-Height*8/3;
					break;
				case R.drawable.dongjing:
					scaleWidth = (float) ((float)Width*2.7);
					scaleHeight = (float) ((float)Height*8.0);
					startX = msg.arg1-Width*30/20;
					startY = msg.arg2-Height;
					break;
				case R.drawable.facet1:
					scaleWidth = (float) ((float)Width*2.0);
					scaleHeight = (float) ((float)Height*15.0);
					startX = msg.arg1-Width*23/20;
					startY = msg.arg2-Height*26/3;
					break;
				case R.drawable.facet2:
					scaleWidth = (float) ((float)Width*2.4);
					scaleHeight = (float) ((float)Height*13.0);
					startX = msg.arg1-Width*28/20;
					startY = msg.arg2-Height*20/3;
					break;
				case R.drawable.facet3:
					scaleWidth = (float) ((float)Width*1.75);
					scaleHeight = (float)((float)Height*13.0);
					startX = msg.arg1-Width*21/20;
					startY = msg.arg2-Height*18/3;
					break;
				case R.drawable.facet4:
					scaleWidth = (float) ((float)Width*1.9);
					scaleHeight = (float) ((float)Height*10.0);
					startX = msg.arg1-Width*23/20;
					startY = msg.arg2-Height*16/3;
					break;
				case R.drawable.facepig:
					scaleWidth = (float) ((float)Width*2.2);
					scaleHeight = (float) ((float)Height*12.0);
					startX = msg.arg1-Width*25/20;
					startY = msg.arg2-Height*15/3;
					break;
				case R.drawable.ear1:
					scaleWidth = (float) ((float)Width*2.2);
					scaleHeight = (float) ((float)Height*7.6);
					startX = msg.arg1-Width*25/20;
					startY = msg.arg2-Height*5;
					break;
				case R.drawable.ear3:
					scaleWidth = (float) ((float)Width*2.2);
					scaleHeight = (float) ((float)Height*7.6);
					startX = msg.arg1-Width*25/20;
					startY = msg.arg2-Height*5;
					break;
				case R.drawable.hat1:
					scaleWidth = (float) ((float)Width*2.8);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*32/20;
					startY = msg.arg2-Height*18/3;
					break;
				case R.drawable.hat2:
					scaleWidth = (float) ((float)Width*2.8);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*31/20;
					startY = msg.arg2-Height*11/3;
					break;
				case R.drawable.hat3:
					scaleWidth = (float) ((float)Width*2.9);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*32/20;
					startY = msg.arg2-Height*18/3;
					break;
				case R.drawable.hat5:
					scaleWidth = (float) ((float)Width*1.8);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*21/20;
					startY = msg.arg2-Height*16/3;
					break;
				case R.drawable.hat7:
					scaleWidth = (float) ((float)Width*2.2);
					scaleHeight = (float) ((float)Height*7.0);
					startX = msg.arg1-Width*26/20;
					startY = msg.arg2-Height*16/3;
					break;
				case R.drawable.hat8:
					scaleWidth = (float) ((float)Width*2.8);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*32/20;
					startY = msg.arg2-Height*15/3;
					break;
				case R.drawable.hat9:
					scaleWidth = (float) ((float)Width*2.9);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*32/20;
					startY = msg.arg2-Height*15/3;
					break;
				case R.drawable.hat10:
					scaleWidth = (float) ((float)Width*2.8);
					scaleHeight = (float) ((float)Height*6.0);
					startX = msg.arg1-Width*32/20;
					startY = msg.arg2-Height*16/3;
					break;
				default:
					break;
				}
				
				//imageView.setXY(msg.arg1,msg.arg2);
				imageView.setXY(startX,startY);
		    	imageView.setNarrow(scaleWidth/bmpwidth,scaleHeight/bmpheight);
		    	imageView.setAlpha(0.9f);
		    	//imageView.touch
		    	 
		         mRelativeLayout.addView(imageView);
				
		 
		         break;
			case -1:
				 //count2++;
				 //if(count2 == count2_2)
				 mRelativeLayout.removeView(imageView);
				 break;
			}
	           
		}
	};
	    
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity=this;
		//设置为全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
		mRelativeLayout=(RelativeLayout) findViewById(R.id.mRelativeLayout);
		//pathbutton = (RelativeLayout)findViewById(R.id.pathbutton);
		mGLSurfaceView = new MySurfaceView(this);		
		mGLSurfaceView.getHolder() .setFormat(PixelFormat.TRANSLUCENT);
		mGLSurfaceView.setTranslationX(400);
		mGLSurfaceView.setTranslationX(700);
		mRelativeLayout.addView(mGLSurfaceView);
		mCameraView=(CameraBridgeViewBase)new JavaCameraView(this,98);
		//JavaCameraView mm = new JavaCameraView(this, 98);
	
		mCameraView.setId(R.id.mCameraView);
	    mCameraView.setCvCameraViewListener(this);
	    mRelativeLayout.addView(mCameraView);
	    mGLSurfaceView.requestFocus();
		mGLSurfaceView.setFocusableInTouchMode(true);
		inflater = getLayoutInflater();
		View bottom_layout = inflater.inflate(R.layout.bottom, null);
		View pathB = inflater.inflate(R.layout.pathbutton, null);
		View top = inflater.inflate(R.layout.top, null);
		//View filter = inflater.inflate(R.layout.fragment_image_edit_filter, null);
		RelativeLayout.LayoutParams relLayoutParams=new android.widget.RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		relLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
		bottom_layout.setLayoutParams(relLayoutParams);
		mRelativeLayout.addView(bottom_layout);
		mRelativeLayout.addView(pathB);
		mRelativeLayout.addView(top);
		
		
//		View popupView = getLayoutInflater().inflate(R.layout.popouwindow, null);
//        mPopupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, true);
//        mPopupWindow.setTouchable(true);
//        mPopupWindow.setOutsideTouchable(true);
//        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

	
		
		
		clickAndDoing=(ImageButton) findViewById(R.id.clickandhide);
		filterSwitch = (FrameLayout)findViewById(R.id.videoicon);
		TakePhoto = (ImageButton)findViewById(R.id.btn_shutter_camera);
		browserButton = (ImageButton)findViewById(R.id.btn_switch_mode);
		topButton = (RelativeLayout)findViewById(R.id.topLayout);
		topButton1 = (RelativeLayout)findViewById(R.id.topLayout1);
		clickAndDoing.setOnClickListener(this);
		filterSwitch.setOnClickListener(this);
		TakePhoto.setOnClickListener(this);
		browserButton.setOnClickListener(this);
		//top.setOnClickListener(this);
		topButton.setOnClickListener(this);
		topButton1.setOnClickListener(this);
		bottom=(LinearLayout) findViewById(R.id.bottom);
		bottom_bar=(LinearLayout) findViewById(R.id.camera_bottom_bar);
		FilterChoose=(LinearLayout) findViewById(R.id.filterbottom);
		//filterLayout =(LinearLayout)findViewById(R.id.layout_filter_tab);
		viewPager=(ViewPager) findViewById(R.id.viewpager);
		FilterViewPaper=(ViewPager) findViewById(R.id.filter);
		DisplayMetrics dm =getResources().getDisplayMetrics();  
        w_screen = dm.widthPixels;  
        h_screen = dm.heightPixels;  
		initData();
		initView();
		initPopWindow();
		
		composerLayout clayout = (composerLayout) findViewById(R.id.test);
		clayout.init(new int[] { R.drawable.ic_camera_alt_white_24dp,
				R.drawable.ic_center_focus_strong_white_24dp, R.drawable.ic_tag_faces_white_24dp,
				R.drawable.ic_photo_filter_white_24dp, R.drawable.ic_cancel_white_24dp,
				}, R.drawable.composer_button,
				R.drawable.composer_icn_plus, composerLayout.RIGHTCENTER, 200,
				200);
		
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == 100 + 0) {
					System.out.println("composer_camera");
					flag_cam = -flag_cam;
					mCameraView.disableView();
					if(flag_cam == -1){mCameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_BACK);flag_camId = 1;}
					if(flag_cam == 1){mCameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_FRONT);flag_camId = 0;}
					mCameraView.enableView();
				} else if (v.getId() == 100 + 1) {
					//OpenLightOn();
					// Camera.Parameters params = m_Camera.getParameters();
					//MainActivity.this.onStop();
					
					Intent intent = new Intent(MainActivity.this,
							CaptureActivity.class);
					//startActivity(intent);
					startActivityForResult(intent, REQUEST_CODE_SCAN);
				} else if (v.getId() == 100 + 2) {
					System.out.println("组合");
					Toast.makeText(MainActivity.this, "正在为你寻找最佳商品。。。-", Toast.LENGTH_SHORT).show();
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					java.util.Random r=new java.util.Random(); 
					int rand = r.nextInt(10);
					switch(rand){
					case 1:
						Id = R.drawable.g1;
						break;
					case 2:
						Id = R.drawable.g2;
						break;
					case 3:
						Id = R.drawable.g3;
						break;
					case 4:
						Id = R.drawable.g4;
						break;
					case 5:
						Id = R.drawable.face12;
						break;
					case 6:
						Id = R.drawable.g6;
						break;
					case 7:
						Id = R.drawable.glass1;
						break;
					case 8:
						Id = R.drawable.g8;
						break;
					case 9:
						Id = R.drawable.glass0;
						break;
					default:
						Id = R.drawable.glass2;
						break;
					}
					
					start = true;
					
				} else if (v.getId() == 100 + 3) {
					System.out.println("扩展");
					Toast.makeText(MainActivity.this, "扩展功能尚未开发，敬请期待", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 4) {
					System.out.println("退出");
					MainActivity.this.finish();
				} else if (v.getId() == 100 + 5) {
					System.out.println("composer_with");
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);
		
	}
	private void initPopWindow(){  
        
        View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popouwindow, null);  
        contentView.setBackgroundColor(Color.BLACK);  
          
        mPopupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, true);  
        mPopupWindow.setContentView(contentView);     
        openDir();  
        ListView listView = (ListView) contentView.findViewById(R.id.list);  
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);  
        listView.setAdapter(adapter);  
        //RecyclerView list = (RecyclerView)findViewById(R.id.list_recyclerview);
        //GridLayoutManager layoutmanager = new GridLayoutManager(mActivity, name.length);
        //list.setLayoutManager(layoutmanager);
        //RecyclerView.Adapter adapter = new MyAd6apter(getData());
        //list.setAdapter(adapter);
        mPopupWindow.setFocusable(true);  
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        
    }                                                      
	private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }

    private void openDir()  
     {  
         String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();  
         File file  = new File(rootPath);  
         File[] files = file.listFiles();  
         name = new String[files.length];  
         for(int i=0;i<files.length;i++){  
             name[i]=files[i].getName();  
             System.out.println(name[i]);  
         }  
     }  
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
			if (data != null) {

				final String content = data.getStringExtra(DECODED_CONTENT_KEY);
				//Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
				new AlertDialog.Builder(MainActivity.this).setTitle("访问网址")//设置对话框标题  
			     .setMessage("确认访问"+content+"？")//设置显示的内容  
			     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
			         @Override  
			         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
			             // TODO Auto-generated method stub  
			             GotoStore(content);
			         }  
			  
			     }).setNegativeButton("取消",new DialogInterface.OnClickListener() {//添加返回按钮  
			         @Override  
			         public void onClick(DialogInterface dialog, int which) {//响应事件  
			             // TODO Auto-generated method stub  
			             
			         }  
			     }).show();//在按键响应事件中显示此对话框  
			}
		}
	}
	private void initView() {
		pagerAdapter = new ViewPagerAdapter(viewList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = (Integer) v.getTag();
				setCurView(position);
			}
 
			private void setCurView(int position) {
		if (position < 0 || position >= viewList.size()) {
			return;
		}
		viewPager.setCurrentItem(position);
	}
		});
     //   viewPager.setOnPageChangeListener(new MyViewPaperChangeListener(button_layout_glass,button_layout_ring));
        FilterPagerAdapter = new ViewPagerAdapter(FilterViewList);
        FilterViewPaper.setAdapter(FilterPagerAdapter);
	}
	private void initData() {
		
		viewList = new ArrayList<View>();
		for (int i = 0; i < pages.length; i++) {
			final GridView gridView=(GridView) View.inflate(this, pages[i], null);
			gridView.setAdapter(new ClassGridView(this,i));
			gridView.setOnItemClickListener(new MyItemClickListener(i));
			viewList.add(gridView);
		}
		
		FilterViewList = new  ArrayList<View>();
		final GridView gridview_filter=(GridView) View.inflate(this, R.layout.filter,null);
		gridview_filter.setAdapter(new FilterClassGridView(this));
		gridview_filter.setOnItemClickListener(new FilterItemClickListener(mCurveFilterIndex));
		FilterViewList.add(gridview_filter);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.clickandhide:
			bottom.setVisibility(View.VISIBLE);
			bottom_bar.setVisibility(View.INVISIBLE);
			break;
		case R.id.videoicon:	
	            
//	         filterLayout.setVisibility(View.VISIBLE);
	         FilterChoose.setVisibility(View.VISIBLE);
	         bottom_bar.setVisibility(View.INVISIBLE);
	        break;
		case R.id.btn_shutter_camera:
			//mIsMenuLocked = true;
		    mIsPhotoPending = true;
		    Toast.makeText(this, "save photo..", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_switch_mode:
			switch (Id) {
			case R.drawable.filter_thumb_original:
				Toast.makeText(this, "请选择商品", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face1:
				Toast.makeText(this, "尚未更新，请选择其他", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face2:
				Toast.makeText(this, "尚未更新，请选择其他", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face4:
				index = face4;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face5:
				index = face5;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face6:
				index = face6;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face7:
				index = face7;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face8:
				index = face8;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face9:
				index = face9;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.facepig:
				index = facepig;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.glass0:
				Toast.makeText(this, "测试商品无商店", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.facet1:
				index = faceT;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.facet2:
				index = faceT;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face3:
				index = faceT;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.facet4:
				index = faceT;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.haha:
				index = haha;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.dongjing:
				index = dongjing;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face10:
				index = face10;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.face12:
				index = face12;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.glass1:
				index = glass1;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.glass2:
				index = glass2;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g1:
				index = g1;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g2:
				index = g2;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g3:
				index = g3;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g4:
				index = g4;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g6:
				index = g6;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.g8:
				index = g8;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.ear1:
				index = ear1;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.ear2:
				index = ear2;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat1:
				index = hat1;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat2:
				index = hat2;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat3:
				index = hat3;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat5:
				index = hat5;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat7:
				index = hat8;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat8:
				index = hat8;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat9:
				index = hat9;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			case R.drawable.hat10:
				index = hat10;
				GoToStore = true;
				Toast.makeText(this, "正在进入商店...", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
			
			break;
		case R.id.topLayout:
			flag_cam = -flag_cam;
			mCameraView.disableView();
			if(flag_cam == -1){mCameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_BACK);flag_camId = 1;}
			if(flag_cam == 1){mCameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_FRONT);flag_camId = 0;}
			mCameraView.enableView();
	    	//mPopupWindow.showAsDropDown(v);
			break;
		case R.id.topLayout1:
			if(havaphoto == 1){
		        final Intent intentPhoto = new Intent(Intent.ACTION_VIEW
			               );
			        if (Build.VERSION.SDK_INT >= 25) {
			        	intentPhoto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
			        }
			        intentPhoto.setData(uri);
			        
			        runOnUiThread(new Runnable() {
			            @Override
			            public void run() {
			                startActivity(intentPhoto);
			            }
			        }); 
			}
			break;
		}
		
	}
	@Override
	public void onBackPressed() {
		 if(bottom.getVisibility()==0||FilterChoose.getVisibility()==View.VISIBLE){
			    bottom_bar.setVisibility(0);
				bottom.setVisibility(4);
				FilterChoose.setVisibility(View.GONE);
		 }else{
			 finish();
		 }
	 }
	public void onPause() {
	        super.onPause();
			   mGLSurfaceView.onPause();
		        if (mCameraView != null) {
		            mCameraView.disableView();
		        }
	    }
	    
	    @Override
	public void onResume() {
	        super.onResume();
	        mGLSurfaceView.onResume();
	        //mCameraView.enableView();
	        if (!OpenCVLoader.initDebug()) {  
	            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");  
	            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_11, this, mLoaderCallback);  
	        } else {  
	            Log.d(TAG, "OpenCV library found inside package. Using it!");  
	            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);  
	        }  
	    }

	    
	    @Override
	public void onDestroy() {
	        super.onDestroy();
	        if (mCameraView != null) {
	            mCameraView.disableView();
	        }
	        
	    }

 
		@Override
	public void onCameraViewStopped() {
	    }


	    @SuppressWarnings("null")
		@Override
	public Mat onCameraFrame(final CvCameraViewFrame inputFrame) {
	    	
	    	
	    	 
	    	  Mat rgba = inputFrame.rgba();
	    	  if(start)
	    		{
	         Imgproc.cvtColor(rgba, mGrayUnoriented,
	                          Imgproc.COLOR_RGBA2GRAY);
	         Core.transpose(mGrayUnoriented, mEqualizedGray);
	        if(flag_camId == 0) Core.flip(mEqualizedGray, mEqualizedGray, -1);
	        else{ 
	        	 Core.flip(mEqualizedGray, mEqualizedGray, 1);
	        }
	         Imgproc.equalizeHist(mEqualizedGray, mEqualizedGray); 
	         
	         final List<Point> featuresList;
	         if(DetectType == 0){
	         	mFaceDetector.detectMultiScale(
	                     mEqualizedGray, mFaces, 1.2, 3,
	                     FLAGS, new Size((double)mImageHeight/4.0,(double)mImageWidth/23.0), new Size((double)mImageHeight,(double)mImageWidth/10));
	             if (mFaces.rows() > 0) {
	             	 Rect[] facesArray = mFaces.toArray();  
	                for (int i = 0; i <1; i++)  {//facesArray.length
	                      
	             	     int minX = facesArray[i].x;
	                     int minY = facesArray[i].y;
	                     int width = facesArray[i].width;
	                     int height = facesArray[i].height;
	                     int maxX = minX + width;
	                     int maxY = minY + height;
                       //final int centerX=((int)mImageWidth-minY+(int)mImageWidth-maxY)/2;
                      // final int centerY=((int)mImageHeight-minX+(int)mImageHeight-maxX)/2;
                       final int centerX =minY;//control height
                       final int centerY = maxX-height;//control width
//	                    Core.rectangle(
//	                            rgba, new Point(mImageWidth-minY, mImageHeight-minX),
//	                            new Point(mImageWidth-maxY, mImageHeight-maxX),
//	                            mFaceRectColor);
	                    Height = height*w_screen/mImageHeight;
	                    Width = width*h_screen/mImageWidth;
	                   //1024*576
	                  
	                    //Core.circle(rgba, new Point(centerX,centerY), 5, mFeatureColor);
	                   
	                   
	                    	
	           	    	 new Thread(new Runnable() {
	           					
	           					@Override
	           					public void run() {
	           						
	           					 if(FrameCount==3){
	           						Message msg=new Message();
	           						msg.what=-1;
	           						handler.sendMessage(msg);
	           					 }
	           					FrameCount = 3;
	           					Message msg=new Message();
								msg.arg1=centerY*h_screen/mImageWidth;//width
								msg.arg2=centerX*w_screen/mImageHeight;//height
								
								msg.what=1;
								handler.sendMessage(msg);
	           					
	           					
	           					
	           					}
	           				}).start();
	           	    	 
	                    
	              
	                    
	                }
	              
	             }
	             else{
	            	 new Thread(new Runnable() {
      					
      					@Override
      					public void run() {
      						Message msg=new Message();
      						msg.what=-1;
      						handler.sendMessage(msg);
      						
      					}
      				}).start();
	             }
	         }
	         
	         if(DetectType == 1){
	         	mFaceDetector.detectMultiScale(
	                     mEqualizedGray, mFaces, SCALE_FACTOR, MIN_NEIGHBORS,
	                     FLAGS, mMinSize, mMaxSize);
	            
	             mEyesDetector.detectMultiScale(mEqualizedGray, mEyes, SCALE_FACTOR, MIN_NEIGHBORS, FLAGS, mMinSize_e, mMaxSize_e);
	   
	             if (mFaces.rows() > 0) {
	             	 Rect[] facesArray = mFaces.toArray();  
	                for (int i = 0; i <facesArray.length; i++)  {
	                      
	                	 int minX = facesArray[i].x;
	                     int minY = facesArray[i].y;
	                     int width = facesArray[i].width;
	                     int height = facesArray[i].height;
	                     int maxX = minX + width;
	                     int maxY = minY + height;


//	                    Core.rectangle(
//	                            rgba, new Point(mImageWidth-minY, mImageHeight-minX),
//	                            new Point(mImageWidth-maxY, mImageHeight-maxX),
//	                            mFaceRectColor);
	                    
	                    //eyes
	                
	                 if(mEyes.rows() > 0)
	                 {
	                 	Rect[] eyesArray = mEyes.toArray();  
	                 	for(int j = 0;j<eyesArray.length;j++){
//	                 	final double[] eyes = mEyes.get(0, 0);
	                 	 int minX_e = eyesArray[j].x;
	                     int minY_e = eyesArray[j].y;
	                     int width_e = eyesArray[j].width;
	                     int height_e = eyesArray[j].height;
	                     int maxX_e = minX_e + width_e;
	                     int maxY_e = minY_e + height_e;

	                    if(minY_e<(minY+0.3*width)){
	                     Core.rectangle(
	                             rgba, new Point(mImageWidth-minY_e, mImageHeight-minX_e),
	                             new Point(mImageWidth-maxY_e, mImageHeight-maxX_e),
	                             mEyesRectColor);
	                    }
	                     
	                 }
	                 }
	                 
	                 //mouth
	                
	                 
	             } 
	             }
	         }
	         if(DetectType == 2){
	         	 mFaceDetector.detectMultiScale(
	                      mEqualizedGray, mFaces, SCALE_FACTOR, MIN_NEIGHBORS,
	                      FLAGS, mMinSize, mMaxSize);
	             
	         
	              mMouthDetector.detectMultiScale(mEqualizedGray, mMouth, SCALE_FACTOR, MIN_NEIGHBORS, FLAGS, mMinSize_m, mMaxSize_m);
	              if (mFaces.rows() > 0) {
	              	 Rect[] facesArray = mFaces.toArray();  
	                 for (int i = 0; i <facesArray.length; i++)  {
	                       
	              	   int minX = facesArray[i].x;
	                     int minY = facesArray[i].y;
	                     int width = facesArray[i].width;
	                     int height = facesArray[i].height;
	                     int maxX = minX + width;
	                     int maxY = minY + height;


	                     Core.rectangle(
	                             rgba, new Point(mImageWidth-minY, mImageHeight-minX),
	                             new Point(mImageWidth-maxY, mImageHeight-maxX),
	                             mFaceRectColor);
	                    
	                  
	                  
	                  //mouth
	                 
	                  if(mMouth.rows() > 0)
	                  {
	                  	Rect[] mouthArray = mMouth.toArray();  
	                  	for(int m = 0;m<mouthArray.length;m++){

	                  	int minX_m = mouthArray[m].x;
	                      int minY_m = mouthArray[m].y;
	                      int width_m = mouthArray[m].width;
	                      int height_m= mouthArray[m].height;
	                      int maxX_m= minX_m + width_m;
	                      int maxY_m = minY_m + height_m;
	                      int center_x = minX_m+width_m/2;
	                      int center_y = minY_m+height_m/2;
	                      
	                     if(center_y>(minY+width/2)&&center_y<maxY&&center_x>(minX+width/3)&&center_x<(maxX-width/3)){
	                      Core.rectangle(
	                              rgba, new Point(mImageWidth-minY_m, mImageHeight-minX_m),
	                              new Point(mImageWidth-maxY_m, mImageHeight-maxX_m),
	                              mMouthRectColor);
	                     }
	                  }
	                  }
	                  // Create a mask for the face region.
	                  double smallerSide;
	                  if (height < width) {
	                      smallerSide = height;
	                  } else {
	                      smallerSide = width;
	                  }
	                  double maskPadding =
	                          smallerSide * MASK_PADDING_PROPORTIONAL;
	                  mMask.setTo(mMaskBackgroundColor);
	                  Core.rectangle(
	                          mMask,
	                          new Point(minX + maskPadding,
	                                    minY + maskPadding),
	                          new Point(maxX - maskPadding,
	                                    maxY - maskPadding),
	                          mMaskForegroundColor, -1);
	                  

	                  mWasTrackingFace = true;
	                  
	              } 
	              }
	         }
	         if(DetectType == 4){
	         mFaceDetector.detectMultiScale(
	                 mEqualizedGray, mFaces, SCALE_FACTOR, MIN_NEIGHBORS,
	                 FLAGS, mMinSize, mMaxSize);
	        
	         mEyesDetector.detectMultiScale(mEqualizedGray, mEyes, SCALE_FACTOR, MIN_NEIGHBORS, FLAGS, mMinSize_e, mMaxSize_e);
	         mMouthDetector.detectMultiScale(mEqualizedGray, mMouth, SCALE_FACTOR, MIN_NEIGHBORS, FLAGS, mMinSize_m, mMaxSize_m);
	         if (mFaces.rows() > 0) {
	         	 Rect[] facesArray = mFaces.toArray();  
	            for (int i = 0; i <facesArray.length; i++)  {
	                  
	         	   int minX = facesArray[i].x;
	                int minY = facesArray[i].y;
	                int width = facesArray[i].width;
	                int height = facesArray[i].height;
	                int maxX = minX + width;
	                int maxY = minY + height;


	                Core.rectangle(
	                        rgba, new Point(mImageWidth-minY, mImageHeight-minX),
	                        new Point(mImageWidth-maxY, mImageHeight-maxX),
	                        mFaceRectColor);
	                
	                //eyes
	            
	             if(mEyes.rows() > 0)
	             {
	             	Rect[] eyesArray = mEyes.toArray();  
	             	for(int j = 0;j<eyesArray.length;j++){
//	             	final double[] eyes = mEyes.get(0, 0);
	             	int minX_e = eyesArray[j].x;
	                 int minY_e = eyesArray[j].y;
	                 int width_e = eyesArray[j].width;
	                 int height_e = eyesArray[j].height;
	                 int maxX_e = minX_e + width_e;
	                 int maxY_e = minY_e + height_e;

	                if(minY_e<(minY+0.3*width)){
	                 Core.rectangle(
	                         rgba, new Point(mImageWidth-minY_e, mImageHeight-minX_e),
	                         new Point(mImageWidth-maxY_e, mImageHeight-maxX_e),
	                         mEyesRectColor);
	                }
	                 
	             }
	             }
	             
	             //mouth
	            
	             if(mMouth.rows() > 0)
	             {
	             	Rect[] mouthArray = mMouth.toArray();  
	             	for(int m = 0;m<mouthArray.length;m++){

	             	int minX_m = mouthArray[m].x;
	                 int minY_m = mouthArray[m].y;
	                 int width_m = mouthArray[m].width;
	                 int height_m= mouthArray[m].height;
	                 int maxX_m= minX_m + width_m;
	                 int maxY_m = minY_m + height_m;
	                 int center_x = minX_m+width_m/2;
	                 int center_y = minY_m+height_m/2;
	                 
	                if(center_y>(minY+width/2)&&center_y<maxY&&center_x>(minX+width/3)&&center_x<(maxX-width/3)){
	                 Core.rectangle(
	                         rgba, new Point(mImageWidth-minY_m, mImageHeight-minX_m),
	                         new Point(mImageWidth-maxY_m, mImageHeight-maxX_m),
	                         mMouthRectColor);
	                }
	             }
	             }
	             // Create a mask for the face region.
	             double smallerSide;
	             if (height < width) {
	                 smallerSide = height;
	             } else {
	                 smallerSide = width;
	             }
	             double maskPadding =
	                     smallerSide * MASK_PADDING_PROPORTIONAL;
	             mMask.setTo(mMaskBackgroundColor);
	             Core.rectangle(
	                     mMask,
	                     new Point(minX + maskPadding,
	                               minY + maskPadding),
	                     new Point(maxX - maskPadding,
	                               maxY - maskPadding),
	                     mMaskForegroundColor, -1);
	             

	             mWasTrackingFace = true;
	             
	         } 
	         }
	         }
	    }
	         // Draw the current features.
//	         for (int i = 0; i< featuresList.size(); i++) {
//	             final Point p = featuresList.get(i);
//	             final Point pTrans = new Point(
//	                     mImageWidth - p.y,
//	                     mImageHeight - p.x);
//	             Core.circle(rgba, pTrans, 8, mFeatureColor);
//	         }
	         
	         // Swap the references to the current and previous images.
//	         final Mat swapEqualizedGray = mLastEqualizedGray;
//	         mLastEqualizedGray = mEqualizedGray;
//	         mEqualizedGray = swapEqualizedGray;
//	         
//	         // Swap the references to the current and previous features.
//	         final MatOfPoint2f swapFeatures = mLastFeatures;
//	         mLastFeatures = mFeatures;
//	         mFeatures = swapFeatures;
	         
	         // Mirror (horizontally flip) the preview.
	         if(flag_camId == 0)
	         Core.flip(rgba, rgba, 1);
	         
	        switch(mCurveFilterIndex){
	        case 0:
	        	break;
	        case 5:
	        	Imgproc.Canny(rgba, rgba, 20.0, 80.0);
	        	Core.bitwise_not(rgba, rgba);
	        	break;
	        case 6:
	        	Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_BGR2GRAY);
	        	break;
	        case 7:
	        	Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_BGR2GRAY);
	        	Imgproc.threshold(rgba, rgba, 80.0, 255.0, Imgproc.THRESH_BINARY);
	        	break;
	        case 8:
	        	Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_BGR2RGB);
	        	break;
	        case 9: 
	        	Imgproc.cvtColor(rgba, rgba,Imgproc.COLOR_RGB2HSV);
	        	break;
	        default:
	        	mCurveFilters[mCurveFilterIndex].apply(rgba, rgba);
	        	break;
	        }
	        
	         
	         if (mIsPhotoPending) {
	             mIsPhotoPending = false;
	             int r = takePhoto(rgba);
	         }
	         if(GoToStore){
	        	 GoToStore = false;
	        	
	        	 GotoStore(index);
	         }
	         return rgba;
	     }
	    private void GotoStore(String index){
	    	final Intent intent = new Intent();
	    	intent.setClass(MainActivity.this, Browser.class);
	    	intent.putExtra("address", index);
	    	runOnUiThread(new Runnable() {
	            @Override
	            public void run() {
	                startActivity(intent);
	            }
	        }); 
	    }
	    private int takePhoto(final Mat rgbas) {
	        
	        // Determine the path and metadata for the photo.
	        final long currentTimeMillis = System.currentTimeMillis();
	        final String appName = getString(R.string.app_name);
	        final String galleryPath =
	                Environment.getExternalStoragePublicDirectory(
	                        Environment.DIRECTORY_PICTURES).toString();
	        final String albumPath = galleryPath + File.separator +
	                appName;
	        final String photoPath = albumPath + File.separator +
	                currentTimeMillis + ".png";
	        final ContentValues values = new ContentValues();
	        values.put(MediaStore.MediaColumns.DATA, photoPath);
	        values.put(Images.Media.MIME_TYPE,
	        		"image/png");
	        values.put(Images.Media.TITLE, appName);
	        values.put(Images.Media.DESCRIPTION, appName);
	        values.put(Images.Media.DATE_TAKEN, currentTimeMillis);
	        
	        // Ensure that the album directory exists.
	        File album = new File(albumPath);
	        if (!album.isDirectory() && !album.mkdirs()) {
	            Log.e(TAG, "Failed to create album directory at " +
	                    albumPath);
	            onTakePhotoFailed();
	            return 0;
	        }
	        Mat result = new Mat();
	        // Try to create the photo.
	       
	        
	        Core.transpose(rgbas, result);
	        Core.flip(result, result, 1);
	        if(mCurveFilterIndex<5){
	        Imgproc.cvtColor(result, mGrayUnoriented, Imgproc.COLOR_RGBA2BGR, 3);
	        if (!Highgui.imwrite(photoPath, mGrayUnoriented)) {
	            Log.e(TAG, "Failed to save photo to " + photoPath);
	            onTakePhotoFailed();
	        }
	        Log.d(TAG, "Photo saved successfully to " + photoPath);
	       // Toast.makeText(this, "successful save", Toast.LENGTH_SHORT).show();
	        havaphoto = 1;
	        }
	        else if(mCurveFilterIndex == 8){
	        	Imgproc.cvtColor(result, mGrayUnoriented, Imgproc.COLOR_BGR2RGB, 3);
	        	if (!Highgui.imwrite(photoPath, result)) {
		            Log.e(TAG, "Failed to save photo to " + photoPath);
		            onTakePhotoFailed();
		        }
		        Log.d(TAG, "Photo saved successfully to " + photoPath);
		     //   Toast.makeText(this, "successful save", Toast.LENGTH_SHORT).show();
		        havaphoto = 1;
	        }
	        else{
	        	if (!Highgui.imwrite(photoPath, result)) {
		            Log.e(TAG, "Failed to save photo to " + photoPath);
		            onTakePhotoFailed();
		        }
		        Log.d(TAG, "Photo saved successfully to " + photoPath);
		     //   Toast.makeText(this, "successful save", Toast.LENGTH_SHORT).show();
		        havaphoto = 1;
	        }
	        
	       
	        try {
	            uri = getContentResolver().insert(
	                    Images.Media.EXTERNAL_CONTENT_URI, values);
	           // if (Build.VERSION.SDK_INT >= 25)
	            	//uri = Provider.getUriForFile(MainActivity.this, "com.zz.fileprovider", values);//通过FileProvider创建一个content类型的Uri
	        } catch (final Exception e) {
	            Log.e(TAG, "Failed to insert photo into MediaStore");
	            e.printStackTrace();
	            
	            // Since the insertion failed, delete the photo.
	            File photo = new File(photoPath);
	            if (!photo.delete()) {
	                Log.e(TAG, "Failed to delete non-inserted photo");
	            }
	            
	            onTakePhotoFailed();
	            return 0;
	        }
	        return 1;
	        // Open the photo in LabActivity.

	    }
	    
	    private void onTakePhotoFailed() {
	        mIsMenuLocked = false;
	        
	        // Show an error message.
	        final String errorMessage =
	                getString(R.string.photo_error_message);
	        runOnUiThread(new Runnable() {
	            @Override
	            public void run() {
	             //   Toast.makeText(MainActivity.this, errorMessage,
	                 //       Toast.LENGTH_SHORT).show();
	            }
	        });
	    }
	    @Override
	    public void onCameraViewStarted(final int width,
	            final int height) {
	        
	        mImageWidth = width;
	        mImageHeight = height;
	        Point pt1 = null,pt2 = null;
	        initFaceDetector();
	        mFaces = new MatOfRect();
	        mEyes = new MatOfRect();
	        mMouth = new MatOfRect();
	        final int smallerSide;
	        if (height < width) {
	            smallerSide = height;
	        } else {
	            smallerSide = width;
	        }
	        
	        final double minSizeSide =
	                MIN_SIZE_PROPORTIONAL * smallerSide;
	        double minSizeSide_e = minSizeSide*0.5;
	        double minSizeSide_m = minSizeSide*0.25;
	        mMinSize = new Size(minSizeSide, minSizeSide);
	        mMinSize_e = new Size(minSizeSide_e,minSizeSide_e);
	        mMinSize_m = new Size(minSizeSide_m,minSizeSide_m);
	        final double maxSizeSide =
	                MAX_SIZE_PROPORTIONAL * smallerSide;
	        double maxSizeSide_e = maxSizeSide*0.5;
	        double maxSizeSide_m = maxSizeSide*0.8;
	        mMaxSize = new Size(maxSizeSide, maxSizeSide);
	        
	        mMaxSize_m = new Size(maxSizeSide_m,maxSizeSide_m);
	        mMaxSize_e = new Size(maxSizeSide_e,maxSizeSide_e);
	   //     mInitialFeatures = new MatOfPoint();
	        mFeatures = new MatOfPoint2f(new Point());
	        mLastFeatures = new MatOfPoint2f(new Point());
	    //    mFeatureStatuses = new MatOfByte();
	    //    mFeatureErrors = new MatOfFloat();
	        
	        mFaceRectColor = new Scalar(255.0, 0.0, 0.0);
	        mEyesRectColor = new Scalar(0.0,255.0,0.0);
	        mMouthRectColor = new Scalar(255.0,0.0,0.0);
	        mFeatureColor = new Scalar(0.0, 255.0, 0.0);
	        
	    
	        
	        mGrayUnoriented = new Mat(height, width, CvType.CV_8UC1);
	        
	        // The rest of the matrices are transposed.
	        
	        mEqualizedGray = new Mat(width, height, CvType.CV_8UC1);
	        mLastEqualizedGray = new Mat(width, height, CvType.CV_8UC1);
	        
	        mMask = new Mat(width, height, CvType.CV_8UC1);
	        mMaskForegroundColor = new Scalar(255.0);
	        mMaskBackgroundColor = new Scalar(0.0);
	        mCurveFilters = new Filter[] {
                    new NoneFilter(),
                    new PortraCurveFilter(),
                    new ProviaCurveFilter(),
                    new VelviaCurveFilter(),
                    new CrossProcessCurveFilter()
            };
	        mMixerFilters = new Filter[] {
                    new NoneFilter(),
                    new RecolorRCFilter(),
                    new RecolorRGVFilter(),
                    new RecolorCMVFilter()
            };
	       
	        
	    }
		private void initFaceDetector() {
	        try {
	            // Load cascade file from application resources.
	            
	            InputStream is = getResources().openRawResource(
	                    R.raw.haarcascade_mcs_eyepair_big);
	            File cascadeDir = getDir(
	                    "cascade", Context.MODE_PRIVATE);
	            File cascadeFile = new File(
	                    cascadeDir, "haarcascade_mcs_eyepair_big.xml");
	            FileOutputStream os = new FileOutputStream(cascadeFile);
	            
	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            while ((bytesRead = is.read(buffer)) != -1) {
	                os.write(buffer, 0, bytesRead);
	            }
	            is.close();
	            os.close();
	            
	            mFaceDetector = new CascadeClassifier(
	                    cascadeFile.getAbsolutePath());
	            if (mFaceDetector.empty()) {
	                Log.e(TAG, "Failed to load cascade");
	                finish();
	            } else {
	                Log.i(TAG, "Loaded cascade from " +
	                      cascadeFile.getAbsolutePath());
	            }

	            cascadeDir.delete();
	            
	            
	            
	            //load eyes
	            InputStream is_e = getResources().openRawResource(
	                    R.raw.haarcascade_eye);
	            File cascadeDir_e = getDir(
	                    "cascade", Context.MODE_PRIVATE);
	            File cascadeFile_e = new File(
	                    cascadeDir_e, "haarcascade_eye.xml");
	            FileOutputStream os_e = new FileOutputStream(cascadeFile_e);
	            
	            byte[] buffer_e = new byte[4096];
	            int bytesRead_e;
	            while ((bytesRead_e = is_e.read(buffer_e)) != -1) {
	                os_e.write(buffer_e, 0, bytesRead_e);
	            }
	            is_e.close();
	            os_e.close();
	            
	            mEyesDetector = new CascadeClassifier(
	                    cascadeFile_e.getAbsolutePath());
	            if (mEyesDetector.empty()) {
	                Log.e(TAG, "Failed to load cascade e");
	                finish();
	            } else {
	                Log.i(TAG, "Loaded cascade from " +
	                      cascadeFile_e.getAbsolutePath());
	            }

	            cascadeDir_e.delete();
	            
	            //load mouth
	            InputStream is_m = getResources().openRawResource(
	                    R.raw.haarcascade_mcs_nose);
	            File cascadeDir_m = getDir(
	                    "cascade", Context.MODE_PRIVATE);
	            File cascadeFile_m = new File(
	                    cascadeDir_m, "haarcascade_mcs_nose.xml");
	            FileOutputStream os_m = new FileOutputStream(cascadeFile_m);
	            
	            byte[] buffer_m = new byte[4096];
	            int bytesRead_m;
	            while ((bytesRead_m = is_m.read(buffer_m)) != -1) {
	                os_m.write(buffer_m, 0, bytesRead_m);
	            }
	            is_m.close();
	            os_m.close();
	            
	            mMouthDetector = new CascadeClassifier(
	                    cascadeFile_m.getAbsolutePath());
	            if (mMouthDetector.empty()) {
	                Log.e(TAG, "Failed to load cascade m");
	                finish();
	            } else {
	                Log.i(TAG, "Loaded cascade from " +
	                      cascadeFile_m.getAbsolutePath());
	            }

	            cascadeDir_m.delete();
	            
	            //load left ear
	            InputStream is_le = getResources().openRawResource(
	                    R.raw.haarcascade_mcs_nose);
	            File cascadeDir_le = getDir(
	                    "cascade", Context.MODE_PRIVATE);
	            File cascadeFile_le = new File(
	                    cascadeDir_le, "haarcascade_mcs_nose.xml");
	            FileOutputStream os_le = new FileOutputStream(cascadeFile_le);
	            
	            byte[] buffer_le = new byte[4096];
	            int bytesRead_le;
	            while ((bytesRead_le = is_le.read(buffer_le)) != -1) {
	                os_le.write(buffer_le, 0, bytesRead_le);
	            }
	            is_le.close();
	            os_le.close();
	            
	            mMouthDetector = new CascadeClassifier(
	                    cascadeFile_le.getAbsolutePath());
	            if (mMouthDetector.empty()) {
	                Log.e(TAG, "Failed to load cascade m");
	                finish();
	            } else {
	                Log.i(TAG, "Loaded cascade from " +
	                      cascadeFile_le.getAbsolutePath());
	            }

	            cascadeDir_le.delete();
	            
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            Log.e(TAG, "Failed to load cascade. Exception thrown: "
	                  + e);
	            finish();
	        }
	    }




}
