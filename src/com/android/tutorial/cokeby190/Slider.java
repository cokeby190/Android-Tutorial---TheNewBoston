package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnDrawerOpenListener{

	SlidingDrawer sd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		
		Button search = (Button) findViewById(R.id.b_search_test);
		Button dir = (Button) findViewById(R.id.b_dir_test);
		Button crowd = (Button) findViewById(R.id.b_crowd_test);
		Button nearby = (Button) findViewById(R.id.b_nearby_test);
		
		Button test1 = (Button) findViewById(R.id.b_sd_test1);
		Button test2 = (Button) findViewById(R.id.b_sd_test2);
		Button test3 = (Button) findViewById(R.id.b_sd_test3);
		
		sd = (SlidingDrawer) findViewById(R.id.slidingDraw);
		sd.setOnDrawerOpenListener(this);
		
		search.setOnClickListener(this);
		dir.setOnClickListener(this);
		crowd.setOnClickListener(this);
		nearby.setOnClickListener(this);
		
		test1.setOnClickListener(this);
		test2.setOnClickListener(this);
		test3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.b_search_test:
				Intent search = new Intent(Slider.this, Camera_class.class);
				startActivity(search);
				break;
			case R.id.b_dir_test:
				Intent dir = new Intent(Slider.this, Data.class);
				startActivity(dir);
				break;
			case R.id.b_crowd_test:
				Intent crowd = new Intent(Slider.this, Graphics.class);
				startActivity(crowd);
				break;
			case R.id.b_nearby_test:
				Intent nearby = new Intent(Slider.this, Email_class.class);
				startActivity(nearby);
				break;
				
			case R.id.b_sd_test1:
				sd.open();
				break;
			case R.id.b_sd_test2:
				sd.close();
				break;
			case R.id.b_sd_test3:
				sd.lock();
				break;
		}
		
	}

	@Override
	public void onDrawerOpened() {
		MediaPlayer mp = MediaPlayer.create(this, R.raw.avengers);
		mp.start();
	}

}
