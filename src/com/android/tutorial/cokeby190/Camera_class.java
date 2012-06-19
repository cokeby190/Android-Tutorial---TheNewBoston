package com.android.tutorial.cokeby190;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera_class extends Activity implements OnClickListener{

	ImageButton ib_camera;
	Button b_take_photo;
	ImageView iv_show_photo;
	
	Intent photo_take;
	final static int cameraData = 0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.photo);
		initialise();
		
		//setting the bitmap to the default icon so when we set wallpaper without taking
		//a photo it will not crash the system
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}
	
	private void initialise() {
		ib_camera = (ImageButton) findViewById(R.id.ib_take_pic);
		b_take_photo = (Button) findViewById(R.id.b_set_wallpaper);
		iv_show_photo = (ImageView) findViewById(R.id.iv_photo_view);
		
		ib_camera.setOnClickListener(this);
		b_take_photo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.ib_take_pic:
				photo_take = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				//int type variable that will collect the data (cameraData)
				startActivityForResult(photo_take, cameraData);
				break;
			case R.id.b_set_wallpaper:
				try {
					getApplicationContext().setWallpaper(bmp);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK) {
			Bundle extra = data.getExtras();
			bmp = (Bitmap) extra.get("data");
			iv_show_photo.setImageBitmap(bmp);
		}
	}
}
