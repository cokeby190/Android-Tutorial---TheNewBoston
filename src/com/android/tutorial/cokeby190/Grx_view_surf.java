//package com.android.tutorial.cokeby190;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//
////instead of using invalidate() to loop the onDraw, we will now use a thread to 
//	//handle the animation, i.e. Runnable
//public class Grx_view_surf extends SurfaceView implements Runnable{
//
//	//we now need a surfaceholder, since we have a surface of a view, we need
//		//a surfaceholder to handle that surface
//	SurfaceHolder holder;
//	Thread run_thread = null;
//	boolean isRunning = false;
//
//	public Grx_view_surf(Context context) {
//		super(context);
//		
//		//holder can tell us if surface is valid
//			//if its not valid, will not be able to display on the surface
//			//and allow us to lock the canvas so no other threads can touch the canvas
//		holder = getHolder();
//	}
//
//	public void pause() {
//		//isRunning become false, then it will stop looping
//		isRunning = false;
//		
//		//destroy the thread onPause, because everytime onResume is called 
//			//it will call a new thread
//		while(true) {
//			//Blocks the current Thread (Thread.currentThread()) 
//				//until the receiver finishes its execution and dies
//			try {
//				run_thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			break;
//		}
//		run_thread = null;
//	}
//	
//	public void resume() {
//		// when isRunning becomes true, it will start looping again
//		isRunning = true;
//		
//		//only create the thread in onResume
//		run_thread = new Thread(this);
//		run_thread.start();
//	}
//	
//	@Override
//	public void run() {
//		while(isRunning) {
//			if(!holder.getSurface().isValid())
//				continue;
//				
//			//lock canvas
//			Canvas canvas = holder.lockCanvas();
//			//RGB (r,g,b) background color
//			canvas.drawRGB(0, 0, 50);
//			//unlock canvas since drawing is done
//			holder.unlockCanvasAndPost(canvas);
//		}
//	}
//
//}
