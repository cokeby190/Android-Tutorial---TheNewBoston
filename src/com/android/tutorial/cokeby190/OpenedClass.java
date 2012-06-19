package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{

	Button returnData;
	TextView question, test;
	RadioGroup select;
	String getMsg, sendData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.send);
		
		initialise();
		
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "heeheehee.(:");
		String values = getData.getString("list", "2");
		
		if(values.equals("1")) {
			question.setText(et);
		}
		
		getData();
	}

	private void initialise() {
		returnData = (Button) findViewById(R.id.b_returnData);
		question = (TextView) findViewById(R.id.textView1);
		test = (TextView) findViewById(R.id.textView2);
		select = (RadioGroup) findViewById(R.id.rg_send);
		
		select.setOnCheckedChangeListener(this);
		
		returnData.setOnClickListener(this);
	}
	
	private void getData() {
		Bundle getMessage = getIntent().getExtras();
		getMsg = getMessage.getString("passing_msg");
		question.setText(getMsg);
	}

	@Override
	public void onClick(View v) {
		Intent receive = new Intent();
		Bundle packet_receive = new Bundle();
		packet_receive.putString("answer", sendData);
		receive.putExtras(packet_receive);
		setResult(RESULT_OK, receive);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId) {
			case R.id.r_send1:
				sendData = "Moooooo. (:";
				break;
			case R.id.r_send2:
				sendData = "Dwarf 4 (:";
				break;
			case R.id.r_send3:
				sendData = "Dwarf 5 (:";
				break;
		}
		test.setText(sendData);
	}
}
