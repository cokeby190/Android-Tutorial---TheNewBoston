package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener{

	TabHost tb;
	TextView showResults;
	long start, stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		
		tb = (TabHost)findViewById(R.id.tabhost);
		
		//setting up buttons 
		Button newTab = (Button) findViewById(R.id.b_add_tab);
		Button b_start = (Button) findViewById(R.id.b_start);
		Button b_stop = (Button) findViewById(R.id.b_stop);
		showResults = (TextView) findViewById(R.id.textView1);
		
		newTab.setOnClickListener(this);
		b_start.setOnClickListener(this);
		b_stop.setOnClickListener(this);
		
		
		//get the initialization
		tb.setup();
		
		//newTabSpec(tag)
		TabSpec ts = tb.newTabSpec("tag");
		//setContent(linearlayout) for tab1
		ts.setContent(R.id.tab1);
		ts.setIndicator("StopWatch");
		tb.addTab(ts);
		
		//newTabSpec(tag)
		TabSpec ts2 = tb.newTabSpec("tag2");
		//setContent(linearlayout) for tab1
		ts2.setContent(R.id.tab2);
		ts2.setIndicator("Tab 2");
		tb.addTab(ts2);
		
		//newTabSpec(tag)
		TabSpec ts3 = tb.newTabSpec("tag3");
		//setContent(linearlayout) for tab1
		ts3.setContent(R.id.tab3);
		ts3.setIndicator("Tab 3");
		tb.addTab(ts3);
		
		//get time from system
		start = 0;
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()) {
			//adding new tab based on user pressing button
			case R.id.b_add_tab:
				
				TabSpec newSpec = tb.newTabSpec("new tag");
				newSpec.setContent(new TabHost.TabContentFactory() {
					
					@Override
					public View createTabContent(String tag) {
						TextView text = new TextView(Tabs.this);
						text.setText("Creating new tab...");
						return (text);
						//return null;
					}
				});
				
				newSpec.setIndicator("New");
				tb.addTab(newSpec);
				
				break;
				
			//start button	
			case R.id.b_start:
				start = System.currentTimeMillis();
				break;
			
			//stop button
			case R.id.b_stop:
				stop = System.currentTimeMillis();
				if(start != 0) {
					long time_dur = (stop-start);
					int millis = (int) time_dur;
					int sec = millis / 1000; 
					int min = sec / 60;
					int hour = min / 60;
					
					int r_millis = millis % 100;
					int r_sec = sec % 60;
					int r_min = min %60;
					showResults.setText("The time duration is " + String.format("%d:%02d:%02d:%02d", hour, r_min, r_sec, r_millis) + " millisecs. ");
				}
				break;
		}
		
	}

}
