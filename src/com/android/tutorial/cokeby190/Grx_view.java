package com.android.tutorial.cokeby190;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class Grx_view extends View{

	Bitmap gBall;
	float changingY;
	
	Typeface font;
	
	public Grx_view(Context context) {
		super(context);

		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.angry_bird_128);
		changingY = 0;
		
		//createFromAsset(Assetmanager, path)
			//path put the font name
		font = Typeface.createFromAsset(context.getAssets(), "handsean.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//setting background to white
		canvas.drawColor(Color.WHITE);
		
		//setting text
		Paint textpaint = new Paint();
		//set ARGB (alpha, red, green, blue)
		textpaint.setARGB(50, 50, 50, 50);
		textpaint.setTextAlign(Align.CENTER);	//center alignment
		textpaint.setTextSize(50);				//set textsize
		
		textpaint.setTypeface(font);
		
		//drawText(text, x, y, paint)
		canvas.drawText("Angry Bird", (canvas.getWidth()/2), 200, textpaint);
		
		
		//draw image to animate
		//drawBitmap(bitmap to draw, how much from the left, how much from the top, paint);
		canvas.drawBitmap(gBall, (canvas.getWidth()/2), changingY, null);
		
		if(changingY < canvas.getHeight()) {
			changingY+= 10;
		} else {
			changingY = 0;
		}		
			
		//will check and then restart the onDraw 
		//so it will go into a loop and keep running onDraw 
		invalidate();
	}

	
}
