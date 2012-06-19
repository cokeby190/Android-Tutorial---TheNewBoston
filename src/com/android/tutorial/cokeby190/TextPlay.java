package com.android.tutorial.cokeby190;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity{

	Button check_command;
	ToggleButton check_password;
	EditText input;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		
		initialise_view();

		check_password.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(check_password.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT  | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		check_command.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String check = input.getText().toString();
				
				if(check.equals("left")) {
					display.setGravity(Gravity.LEFT);
				} else if(check.equals("center")) {
					display.setGravity(Gravity.CENTER);
				} else if(check.equals("right")) {
					display.setGravity(Gravity.RIGHT);
				} else if(check.equals("blue")) {
					display.setBackgroundColor(Color.BLUE);
				} else if(check.equals("domokun")) {
					Random movable = new Random();
					display.setText("Domokun!");
					display.setTextSize(movable.nextInt(75));
					display.setTextColor(Color.rgb(movable.nextInt(265), movable.nextInt(265), movable.nextInt(265)));
					display.setBackgroundColor(Color.rgb(movable.nextInt(265), movable.nextInt(265), movable.nextInt(265)));
					
					//nextInt(number) --> number gives us how many numbers we want to random.
					//setting it as 3 will mean it will random 0,1,2
					switch(movable.nextInt(3)) {
						case 0:
							display.setGravity(Gravity.LEFT);
							break;
						case 1: 
							display.setGravity(Gravity.CENTER);
							break;
						case 2:
							display.setGravity(Gravity.RIGHT);
							break;
					}
				} else {
					display.setText("invalid");
					display.setGravity(Gravity.CENTER);
					display.setTextColor(Color.WHITE);
				}
			}
		});
	}
	
	private void initialise_view() {
		check_command = (Button) findViewById(R.id.button_results);
		check_password = (ToggleButton) findViewById(R.id.toggle_button);
		input = (EditText) findViewById (R.id.edit_text);
		display = (TextView) findViewById (R.id.text_results);
	}

}
