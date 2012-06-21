package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		
		TabHost tb = (TabHost)findViewById(R.id.tabhost);
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
		
	}

}
