package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Android_TutorialActivity extends Activity {
	/** Called when the activity is first created. */

	int counter;
	Button but_add, but_sub, but_reset;
	TextView display;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		counter = 0;

		display = (TextView) findViewById(R.id.display);
		but_add = (Button) findViewById(R.id.b_add);
		but_sub = (Button) findViewById(R.id.b_sub);
		but_reset = (Button) findViewById(R.id.b_reset);

		but_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter++;
				display.setText("Now it is : " + counter);
			}
		});

		but_sub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter--;
				display.setText("Now it is : " + counter);
			}
		});
		
		but_reset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter=0;
				display.setText("Lets Start Again!(: Now it is : " + counter);
			}
		});
	}
}