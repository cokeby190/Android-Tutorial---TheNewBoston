package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

//public accessible by other classes, Private cannot be accessible by other classes.
public class Splash_class extends Activity{
	
	MediaPlayer splash_sound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_display);
		
		splash_sound = MediaPlayer.create(Splash_class.this, R.raw.pikachu_splash_sound);
		
		//check from preferences if it is checked or not
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean check_splash_sound = getPrefs.getBoolean("checkbox", true);  //true, playing the sound unless specified
		
		if(check_splash_sound) {
			splash_sound.start();	
		}
		
		//USING THREADS - DOING THINGS ALMOST SIMULTANEOUSLY
		Thread timer = new Thread() {
			public void run () {
				try {
					 sleep(3000); //sleep in terms of ms
				} catch(InterruptedException e) {	
					// catch type of exception InterruptedException (For debugging purpose)
					e.printStackTrace();
				} finally {		// do something FINALLY
					Intent start_main = new Intent("com.android.tutorial.cokeby190.MENU");
					startActivity(start_main);
				}
			}
		};
		
		timer.start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		finish();
		splash_sound.release();
	}
}
