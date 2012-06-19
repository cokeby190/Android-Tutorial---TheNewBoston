package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email_class extends Activity implements OnClickListener{

	EditText et_mail, et_intro, et_name;
	Button send_email;
	String et_mail_str, et_intro_str, et_name_str;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.email);
		
		initialise_xml();
		
		send_email.setOnClickListener(this);
	}

	private void initialise_xml() {
		et_mail = (EditText) findViewById(R.id.editText1);
		et_intro = (EditText) findViewById(R.id.editText2);
		et_name = (EditText) findViewById(R.id.editText3);
		
		send_email = (Button) findViewById(R.id.button1);
	}
	
	private void change_toString() {
		et_mail_str = et_mail.getText().toString();
		et_intro_str = et_intro.getText().toString();
		et_name_str = et_name.getText().toString();
	}

	@Override
	public void onClick(View v) {
		change_toString();
		
		String email_add[] = { et_mail_str };
		String message = "Well hello "
				+ et_name_str
				+ " I just wanted to say "
				+ et_intro_str
				+ "."
				+ '\n' + "PS. I think I love you...   (: ";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, email_add);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Moomoo!(:");
		emailIntent.setType("plain/text");	//set type of message
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
