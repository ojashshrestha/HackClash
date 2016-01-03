package com.example.hack2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

public class Levels extends ActionBarActivity {
	private ImageButton pause;
	private ImageButton playa;
	private ImageButton imageButton1;
	private ImageButton play;
	private static Levels INSTANCE;
	public MediaPlayer mp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_levels);
		pause = (ImageButton)findViewById(R.id.pause);
		playa= (ImageButton)findViewById(R.id.playa);
		play= (ImageButton)findViewById(R.id.play);
		imageButton1= (ImageButton)findViewById(R.id.imageButton1);
		INSTANCE = this;
		
		pause.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 if (mp==null)
	        	 {
	        	 mp = MediaPlayer.create(Levels.INSTANCE, R.raw.level);
			        mp.start();
	        	 }
	        	 else
	        	 {
	        		 mp.stop();
	        		 mp=null;
	        	 }
	        	 
	         }
		
	});
		imageButton1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 if (mp==null)
	        	 {
	        	 mp = MediaPlayer.create(Levels.INSTANCE, R.raw.leve);
			        mp.start();
	        	 }
	        	 else
	        	 {
	        		 mp.stop();
	        		 mp=null;
	        	 }
	        	 
	         }
		
	});
		play.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 if (mp==null)
	        	 {
	        	 mp = MediaPlayer.create(Levels.INSTANCE, R.raw.lev);
			        mp.start();
	        	 }
	        	 else
	        	 {
	        		 mp.stop();
	        		 mp=null;
	        	 }
	        	 
	         }
		
	});
		playa.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 if (mp==null)
	        	 {
	        	 mp = MediaPlayer.create(Levels.INSTANCE, R.raw.le);
			        mp.start();
	        	 }
	        	 else
	        	 {
	        		 mp.stop();
	        		 mp=null;
	        	 }
	        	 
	         }
		
	});
		
	}
	
	

}
