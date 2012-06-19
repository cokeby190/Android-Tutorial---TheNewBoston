package com.android.tutorial.cokeby190;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu_class extends ListActivity{

	String list[] = {"Android_TutorialActivity","Splash_class","TextPlay", "TextPlay_2", "Email_class", "Camera_class", "Data"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//trying to set up ListView in java and not in XML. 
		//ArrayAdapter constructor : ArrayAdapter <String> (Context, int, String)
		//using android's prior defined layout instead of setting a new XML
		ArrayAdapter list_adapter = new ArrayAdapter <String>(Menu_class.this, android.R.layout.simple_list_item_1,list);
		setListAdapter(list_adapter);
	}

	@Override
	//which ListView is clicked, which View is clicked, give us position of the ListView that was clicked
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String list_clicked = list[position];
		
		//in case there isnt such a class name, it will throw an error instead of crashing...
		try {
			Class set_class = Class.forName("com.android.tutorial.cokeby190." + list_clicked);
			Intent change_act = new Intent(Menu_class.this, set_class);
			startActivity(change_act);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		MenuInflater menu_inflate = getMenuInflater();
		menu_inflate.inflate(R.menu.menu_xml, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()) {
			case R.id.aboutUs:
				Intent about = new Intent(Menu_class.this, AboutUs.class);
				startActivity(about);
				break;
			case R.id.preferences:
				Intent pref = new Intent(Menu_class.this, Prefs.class);
				startActivity(pref);
				break;
			case R.id.exit:
				finish();
				break;
		}
		return false;
	}
	
	

}