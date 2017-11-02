package com.example.my9_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class ImageView extends View{
	private Paint paint = null; //  ����  
    private Bitmap bitmap = null;   //  ͼƬλͼ  
    private Bitmap bitmapDisplay = null;  
    private Matrix matrix = null;  
    private int nBitmapWidth = 0;   //  ͼƬ�Ŀ��  
    private int nBitmapHeight = 0;  //  ͼƬ�ĸ߶�  
    private int nPosX = 120;    //  ͼƬ���ڵ�λ��X  
    private int nPosY = 120; //  ͼƬ���ڵ�λ��Y  
    private float fAngle = 0.0f;    //  ͼƬ��ת  
    private float fScaleX = 1f;    //  ͼƬ���� 1.0��ʾΪԭͼ  
    private float fScaleY = 1f;
      
    public ImageView(Context context, int glass) {  
        super(context);  
          
        paint = new Paint();  
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);  
          
        //  ������Ҫ������ͼƬ  
        bitmap = BitmapFactory.decodeResource(getResources(), glass);  
        bitmapDisplay = bitmap;  
          
        matrix = new Matrix();  
        //  ��ȡͼƬ�߶ȺͿ��  
        nBitmapWidth = bitmap.getWidth();  
        nBitmapHeight = bitmap.getHeight();
    }  
     
    public void setXY(int nPosX,int nPosY){
    	this.nPosX=nPosX;
    	this.nPosY=nPosY;
    }
    //  �����ƶ�  
    public void setPosLeft() {  
        nPosX -= 10;   
    }  
    //  �����ƶ�  
    public void setPosRight() {  
        nPosX += 10;  
    }  
      
    //  ������ת  
    public void setRotationLeft() {  
        fAngle--;  
        setAngle();  
    }  
    //  ������ת  
    public void setRotationRight() {  
        fAngle++;  
        setAngle();  
    }  
      
    //  ͼƬ�Ŵ�  
    public void setEnlarge() {  
        if (fScaleX < 2) {  
            fScaleX += 0.1f;  
            setScale();  
        }  
    }  
    //  ͼƬ��С  
    public void setNarrow(float fScaleX,float fScaleY) {  
  //      if (fScale > 0.5) {  
   //         fScale -= 0.1f;  
   //         setScale();  
  //      }  
    	this.fScaleX=fScaleX;
    	this.fScaleY = fScaleY;
    	setScale();
    }  
      
    //  ������ת����  
    private void setAngle() {  
        matrix.reset();  
        matrix.setRotate(fAngle);  
        bitmapDisplay = Bitmap.createBitmap(bitmap,0,0,nBitmapWidth,nBitmapHeight,matrix,true);  
    }  
      
    //  �������ű���  
    private void setScale() {  
        matrix.reset();  
        matrix.postScale(fScaleX, fScaleY);  
        bitmapDisplay = Bitmap.createBitmap(bitmap,0,0,nBitmapWidth,nBitmapHeight,matrix,true);  
    }  
      
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);  
        canvas.drawBitmap(bitmapDisplay, nPosX, nPosY, paint);  
        invalidate();  
    }  
}
