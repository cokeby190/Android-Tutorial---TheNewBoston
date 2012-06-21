package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class Graphics extends Activity{

	Grx_view g_view; 
	WakeLock wl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//WAKElock
		PowerManager powMan = (PowerManager) getSystemService(Context.POWER_SERVICE);
		//newWakeLock(flags, tag) - tag can be anything
		wl = powMan.newWakeLock(PowerManager.FULL_WAKE_LOCK, "wake_lock");
		
		//start wakelock
		wl.acquire();
		
		//create a new view class and setContentView to this view
		g_view = new Grx_view(this);
		setContentView(g_view);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		//stop wakelock
		wl.release();
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		//restart wakelock
		wl.acquire();
	}

}
