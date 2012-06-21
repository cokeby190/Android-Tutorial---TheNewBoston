package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

//touch the screen, will have an event, one when the finger is moving around
	//and release when the finger has lifted off the screen
public class Graphics_surface extends Activity implements OnTouchListener{

	Grx_view_surf g_surf;
	float x,y;	//get x and y values when touched
	float sx, sy, fx, fy; //s - starting, f - ending
	float dx, dy, ax, ay; //d - change in direction, a - animate
	float scale_x, scale_y;
	
	Bitmap test, plus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		g_surf = new Grx_view_surf(this);
		//set the touchlistener here since the View encompasses the full screen
		g_surf.setOnTouchListener(this);

		initialise();
		test = BitmapFactory.decodeResource(getResources(), R.drawable.angry_bird_128);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_icon);
		setContentView(g_surf);
	}
	
	private void initialise() {
		x = 0; y = 0;
		sx = 0; sy = 0;
		fx = 0; fy = 0;
		dx = 0; dy = 0;
		ax = 0; ay = 0;
		scale_x = 0; scale_y = 0;
	}


	@Override
	protected void onPause() {
		super.onPause();
		
		//own methods from Grx_view_surf class
		g_surf.pause();
	}


	@Override
	protected void onResume() {
		super.onResume();
		
		//own methods from Grx_view_surf class
		g_surf.resume();
	}


	//call this method when the View is touched
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		
		//sleep, to set FPS frame rate
		//i.e. 60fps, 1000ms/60fps = 16.6667 sleep time
		try {
			Thread.sleep(50);		//roughly 20fps
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		x = event.getX();
		y = event.getY();
		
		switch(event.getAction()) {
		
			//when press down, initial starting location
			case MotionEvent.ACTION_DOWN:
				sx = event.getX();
				sy = event.getY();
				
				fx = 0; fy = 0;
				dx = 0; dy = 0;
				ax = 0; ay = 0;
				scale_x = 0; scale_y = 0;
				break;
			//final position when finger lifts off screen
			case MotionEvent.ACTION_UP:
				fx = event.getX();
				fy = event.getY();
				dx = fx-sx;
				dy = fy-sy;
				
				scale_x = dx/30;
				scale_y = dy/30;
				
				x=0;
				y=0;
				break;
		}
		
		//return false;
		return true;
	}

	//---------------------------NEW CLASS WITHIN CLASS------------------------------------------//
	//instead of using invalidate() to loop the onDraw, we will now use a thread to 
		//handle the animation, i.e. Runnable
	public class Grx_view_surf extends SurfaceView implements Runnable{

		//we now need a surfaceholder, since we have a surface of a view, we need
			//a surfaceholder to handle that surface
		SurfaceHolder holder;
		Thread run_thread = null;
		boolean isRunning = false;

		public Grx_view_surf(Context context) {
			super(context);
			
			//holder can tell us if surface is valid
				//if its not valid, will not be able to display on the surface
				//and allow us to lock the canvas so no other threads can touch the canvas
			holder = getHolder();
		}

		public void pause() {
			//isRunning become false, then it will stop looping
			isRunning = false;
			
			//destroy the thread onPause, because everytime onResume is called 
				//it will call a new thread
			while(true) {
				//Blocks the current Thread (Thread.currentThread()) 
					//until the receiver finishes its execution and dies
				try {
					run_thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			run_thread = null;
		}
		
		public void resume() {
			// when isRunning becomes true, it will start looping again
			isRunning = true;
			
			//only create the thread in onResume
			run_thread = new Thread(this);
			run_thread.start();
		}
		
		@Override
		public void run() {
			while(isRunning) {
				if(!holder.getSurface().isValid())
					continue;
					
				//lock canvas
				Canvas canvas = holder.lockCanvas();
				//RGB (r,g,b) background color
				canvas.drawRGB(0, 0, 50);
				
				//on User TOUCH
				if(x != 0 && y != 0){
					//Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.angry_bird_128);
					//drawBitmap(bitmap, left, top, paint)
					//canvas.drawBitmap(test, x, y, null);
					canvas.drawBitmap(test, (x-(test.getWidth()/2)), (y-(test.getHeight()/2)), null);
				}
				
				//on User TOUCH STARTING POSITION
				if(sx != 0 && sy != 0){
					canvas.drawBitmap(plus, (sx-(plus.getWidth()/2)), (sy-(plus.getHeight()/2)), null);
				}
				
				//on User TOUCH ENDING POSITION
				if(fx != 0 && fy != 0){
					canvas.drawBitmap(test, (fx-(test.getWidth()/2))-ax, (fy-(test.getHeight()/2))-ay, null);
					canvas.drawBitmap(plus, (fx-(plus.getWidth()/2)), (fy-(plus.getHeight()/2)), null);
				}
				
				ax = ax + scale_x;
				ay = ay + scale_y;
				
				//unlock canvas since drawing is done
				holder.unlockCanvasAndPost(canvas);
			}
		}

	}

}
