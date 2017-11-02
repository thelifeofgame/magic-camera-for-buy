package com.example.my9_4;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Browser extends Activity {
	

    WebView wv;
    ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON); 
		setContentView(R.layout.browser);
		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, 
                R.drawable.icon_back2); 
		//设置沉浸式菜单栏
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			 WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//			 local LayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//			}

		wv = (WebView) findViewById(R.id.web);
		//back = (ImageView) findViewById(R.id.back);
		wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
		wv.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
		wv.getSettings().setSupportZoom(true);//是否可以缩放，默认true
		wv.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
		wv.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
		wv.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
		wv.getSettings().setAppCacheEnabled(true);//是否使用缓存
		wv.getSettings().setDomStorageEnabled(true);//DOM Storage 
		wv.setScrollBarStyle(0);  
		WebSettings webSettings = wv.getSettings();  
		webSettings.setAllowFileAccess(true);  
		webSettings.setBuiltInZoomControls(true);  
		final Intent intent = getIntent();
	    String address = intent.getStringExtra("address");
		wv.loadUrl(address);  
		
		
		//加载数据  
		wv.setWebChromeClient(new WebChromeClient() {  
		@Override  
		public void onProgressChanged(WebView view, int newProgress) {  
		if (newProgress == 100) {  
		Browser.this.setTitle("商店");  
		} else {  
		Browser.this.setTitle("为亲努力加载中...");  
		  
		}  
		}  
		});  
		//这个是当网页上的连接被点击的时候  
		wv.setWebViewClient(new WebViewClient(){  
		    @Override  
		    public void onPageStarted(WebView view, String url, Bitmap favicon) {  
		        super.onPageStarted(view, url, favicon);  
		       // Log.d(TAG,"onPageStarted");  
		    }  
		  
		    @Override  
		    public void onPageFinished(WebView view, String url) {  
		        super.onPageFinished(view, url);  
		      //  Log.d(TAG,"onPageFinished");  
		    }  
		});   

		//back.bringToFront();
    }
	private void Back() {
		// TODO 自动生成的方法存根
		
	}
	public boolean onKeyDown(int keyCoder, KeyEvent event) {  
		if (wv.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK) {  
		wv.goBack();  
		return true;  
	  }  
		else{
			Toast.makeText(this, "正在返回魔镜。。",Toast.LENGTH_SHORT).show();
			finish();
		}
		return false;  
     }  
	


	
    public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,1, 1, "回到魔镜");// 添加menu菜单一个item 		
		//第一个参数是菜单所在组的名字，组的id，第二个是item的id ，第三个是item
		//最后一个是item显示的内容。
		return super.onCreateOptionsMenu(menu);
	}
    	//当按下菜单时，选择其中一个item会调用下函数
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		switch(item.getItemId()){
		case 1 :Browser.this.finish();
		}
		return super.onOptionsItemSelected(item);
	}

    


}
