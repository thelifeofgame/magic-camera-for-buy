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
		//���ó���ʽ�˵���
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			 WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//			 local LayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//			}

		wv = (WebView) findViewById(R.id.web);
		//back = (ImageView) findViewById(R.id.back);
		wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//����js����ֱ�Ӵ򿪴��ڣ���window.open()��Ĭ��Ϊfalse
		wv.getSettings().setJavaScriptEnabled(true);//�Ƿ�����ִ��js��Ĭ��Ϊfalse������trueʱ�������ѿ������XSS©��
		wv.getSettings().setSupportZoom(true);//�Ƿ�������ţ�Ĭ��true
		wv.getSettings().setBuiltInZoomControls(true);//�Ƿ���ʾ���Ű�ť��Ĭ��false
		wv.getSettings().setUseWideViewPort(true);//���ô����ԣ�������������š�����ͼģʽ
		wv.getSettings().setLoadWithOverviewMode(true);//��setUseWideViewPort(true)һ������ҳ����Ӧ����
		wv.getSettings().setAppCacheEnabled(true);//�Ƿ�ʹ�û���
		wv.getSettings().setDomStorageEnabled(true);//DOM Storage 
		wv.setScrollBarStyle(0);  
		WebSettings webSettings = wv.getSettings();  
		webSettings.setAllowFileAccess(true);  
		webSettings.setBuiltInZoomControls(true);  
		final Intent intent = getIntent();
	    String address = intent.getStringExtra("address");
		wv.loadUrl(address);  
		
		
		//��������  
		wv.setWebChromeClient(new WebChromeClient() {  
		@Override  
		public void onProgressChanged(WebView view, int newProgress) {  
		if (newProgress == 100) {  
		Browser.this.setTitle("�̵�");  
		} else {  
		Browser.this.setTitle("Ϊ��Ŭ��������...");  
		  
		}  
		}  
		});  
		//����ǵ���ҳ�ϵ����ӱ������ʱ��  
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
		// TODO �Զ����ɵķ������
		
	}
	public boolean onKeyDown(int keyCoder, KeyEvent event) {  
		if (wv.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK) {  
		wv.goBack();  
		return true;  
	  }  
		else{
			Toast.makeText(this, "���ڷ���ħ������",Toast.LENGTH_SHORT).show();
			finish();
		}
		return false;  
     }  
	


	
    public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,1, 1, "�ص�ħ��");// ���menu�˵�һ��item 		
		//��һ�������ǲ˵�����������֣����id���ڶ�����item��id ����������item
		//���һ����item��ʾ�����ݡ�
		return super.onCreateOptionsMenu(menu);
	}
    	//�����²˵�ʱ��ѡ������һ��item������º���
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO �Զ����ɵķ������
		switch(item.getItemId()){
		case 1 :Browser.this.finish();
		}
		return super.onOptionsItemSelected(item);
	}

    


}
