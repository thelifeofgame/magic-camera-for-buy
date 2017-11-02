package com.example.my9_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class ImageView extends View{
	private Paint paint = null; //  画笔  
    private Bitmap bitmap = null;   //  图片位图  
    private Bitmap bitmapDisplay = null;  
    private Matrix matrix = null;  
    private int nBitmapWidth = 0;   //  图片的宽度  
    private int nBitmapHeight = 0;  //  图片的高度  
    private int nPosX = 120;    //  图片所在的位置X  
    private int nPosY = 120; //  图片所在的位置Y  
    private float fAngle = 0.0f;    //  图片旋转  
    private float fScaleX = 1f;    //  图片缩放 1.0表示为原图  
    private float fScaleY = 1f;
      
    public ImageView(Context context, int glass) {  
        super(context);  
          
        paint = new Paint();  
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);  
          
        //  加载需要操作的图片  
        bitmap = BitmapFactory.decodeResource(getResources(), glass);  
        bitmapDisplay = bitmap;  
          
        matrix = new Matrix();  
        //  获取图片高度和宽度  
        nBitmapWidth = bitmap.getWidth();  
        nBitmapHeight = bitmap.getHeight();
    }  
     
    public void setXY(int nPosX,int nPosY){
    	this.nPosX=nPosX;
    	this.nPosY=nPosY;
    }
    //  向左移动  
    public void setPosLeft() {  
        nPosX -= 10;   
    }  
    //  向右移动  
    public void setPosRight() {  
        nPosX += 10;  
    }  
      
    //  向左旋转  
    public void setRotationLeft() {  
        fAngle--;  
        setAngle();  
    }  
    //  向右旋转  
    public void setRotationRight() {  
        fAngle++;  
        setAngle();  
    }  
      
    //  图片放大  
    public void setEnlarge() {  
        if (fScaleX < 2) {  
            fScaleX += 0.1f;  
            setScale();  
        }  
    }  
    //  图片缩小  
    public void setNarrow(float fScaleX,float fScaleY) {  
  //      if (fScale > 0.5) {  
   //         fScale -= 0.1f;  
   //         setScale();  
  //      }  
    	this.fScaleX=fScaleX;
    	this.fScaleY = fScaleY;
    	setScale();
    }  
      
    //  设置旋转比例  
    private void setAngle() {  
        matrix.reset();  
        matrix.setRotate(fAngle);  
        bitmapDisplay = Bitmap.createBitmap(bitmap,0,0,nBitmapWidth,nBitmapHeight,matrix,true);  
    }  
      
    //  设置缩放比例  
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
