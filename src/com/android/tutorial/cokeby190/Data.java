package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{

	Button start, startFor;
	EditText send_et;
	TextView get_answer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.get_data);
		initialise();
	}
	
	private void initialise() {
		start = (Button) findViewById(R.id.b_start);
		startFor = (Button) findViewById(R.id.b_start_result);
		send_et = (EditText) findViewById(R.id.et_send);
		get_answer = (TextView) findViewById(R.id.tv_got);
		
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.b_start:
				String message = send_et.getText().toString();
				Bundle sending = new Bundle();
				sending.putString("passing_msg", message);
				Intent send_intent = new Intent(Data.this, OpenedClass.class);
				send_intent.putExtras(sending);
				startActivity(send_intent);
				break;
			case R.id.b_start_result:
				String message1 = send_et.getText().toString();
				Bundle sending1 = new Bundle();
				sending1.putString("passing_msg", message1);
				
				
				Intent getData = new Intent(Data.this, OpenedClass.class);
				getData.putExtras(sending1);
				startActivityForResult(getData, 0);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK) {
			Bundle extra = data.getExtras();
			String str = extra.getString("answer");
			get_answer.setText(str);
			
		}
	}
	
	

}
