package com.android.tutorial.cokeby190;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener {

	//sound for short seconds only
	SoundPool sp;
	MediaPlayer mP;
	
	int explosion = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sound);
		
		Button sound = (Button) findViewById(R.id.sound);
		Button longsound = (Button) findViewById(R.id.longsound);
		
		sound.setOnClickListener(this);
		longsound.setOnLongClickListener(this);
		
		//SoundPool(maxstreams, streamtype, srcQuality)
		//maxstreams - how many playing at the same time
		//streamtype - normal for apps
		//srcQuality - sample rate
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		//load(context, resource id, priority)
		explosion = sp.load(this, R.raw.pikachu_splash_sound, 1);
		
		mP = MediaPlayer.create(this, R.raw.avengers);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		
			case R.id.sound:
				if(explosion != 0) {
					//play(sound id, left vol, right vol, loop [0 > no loop, -1 > loop forever], rate of play back)
					sp.play(explosion, 1, 1, 0, 0, 1);
				}
				break;
		}
	}

	@Override
	public boolean onLongClick(View view) {
		switch(view.getId()) {
		
		case R.id.longsound:
			mP.start();
			break;
		}
		return false;
	}

}
