package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener{

	EditText url;
	WebView browser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		browser = (WebView) findViewById(R.id.wv_browser);
		Button go_url = (Button) findViewById(R.id.b_url);
		Button go_back = (Button) findViewById(R.id.b_Back);
		Button go_forward = (Button) findViewById(R.id.b_Forward);
		Button refresh = (Button) findViewById(R.id.b_Refresh);
		Button hist = (Button) findViewById(R.id.b_History);
		url = (EditText) findViewById(R.id.et_URL);
		
		go_url.setOnClickListener(this);
		go_back.setOnClickListener(this);
		go_forward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		hist.setOnClickListener(this);
		
		//load the url for the web view
		browser.loadUrl("http://www.mybringback.com");
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.b_url:
				String user_url = url.getText().toString();
				browser.loadUrl(user_url);
				break;
			case R.id.b_Back:
				if(browser.canGoBack()) {
					browser.goBack();
				}
				break;
			case R.id.b_Forward:
				if(browser.canGoForward()) {
					browser.goForward();
				}
				break;
			case R.id.b_Refresh:
				browser.reload();
				break;
			case R.id.b_History:
				browser.clearHistory();
				break;
		}
		
	}

}
