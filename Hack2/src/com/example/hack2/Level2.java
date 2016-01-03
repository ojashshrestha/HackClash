package com.example.hack2;

import java.io.IOException;
import java.util.Random;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Level2 extends ActionBarActivity {
	Button play,stop,record;
	   private MediaRecorder myAudioRecorder;
	   private String outputFile = null;
	   private TextView textView1;
	   private TextView textView3;
       private TextView textView2;
       private long  start=0;
       private int ok=0;
	
	private static Level2 INSTANCE;
	public MediaPlayer mp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_level2);
		Intent intent = getIntent();
		Bundle b=intent.getExtras();
		if (b!=null)
			{
				 ok = b.getInt("ok");
				
				
			}
		 INSTANCE = this;
		 textView1=(TextView)findViewById(R.id.textView1);
		 textView2=(TextView)findViewById(R.id.textView2);
		 textView3=(TextView)findViewById(R.id.textView3);
			play=(Button)findViewById(R.id.button3);
		      stop=(Button)findViewById(R.id.button2);
		      record=(Button)findViewById(R.id.button1);
		      
		      stop.setEnabled(false);
		      play.setEnabled(false);
		      outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";;
		      
		      myAudioRecorder=new MediaRecorder();
		      myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		      myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		      myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		      myAudioRecorder.setOutputFile(outputFile);
		      
		      record.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick(View v) {
		            try {
		            	if(start == 0)
		                     start = System.currentTimeMillis();
		               myAudioRecorder.prepare();
		               myAudioRecorder.start();
		            }
		            
		            catch (IllegalStateException e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		            
		            catch (IOException e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		            
		            record.setEnabled(false);
		            stop.setEnabled(true);
		            
		            Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
		         }
		      });
		      
		      stop.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick(View v) {
		            myAudioRecorder.stop();
		            myAudioRecorder.release();
		            double time = (System.currentTimeMillis() - start) / 1000.0;
		            
		            int b=(int) time;
		            if(b<=9)
		              textView3.setText("00:0"+Integer.toString(b));
		            else
		            	textView3.setText("00:"+Integer.toString(b));
		            myAudioRecorder  = null;
		            
		            stop.setEnabled(false);
		            play.setEnabled(true);
		            
		            Toast.makeText(getApplicationContext(), "Audio recorded successfully",Toast.LENGTH_SHORT).show();
		            if(time>10)
		            {
		            	
		        	      getAnother();
		            	            	
		            }
		            else
		            {
		            	tryAnother();
		            }
		         }
		      });
		      
		      play.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick(View v) throws IllegalArgumentException,SecurityException,IllegalStateException {
		            MediaPlayer m = new MediaPlayer();
		            
		            try {
		               m.setDataSource(outputFile);
		            }
		            
		            catch (IOException e) {
		               e.printStackTrace();
		            }
		            
		            try {
		               m.prepare();
		            }
		            
		            catch (IOException e) {
		               e.printStackTrace();
		            }
		            
		            m.start();
		            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
		         }
		      });
			
			
		      
		      
		}	     
			
		
		
			
			

	public void getAnother()
	{
		new AlertDialog.Builder(this)
	    .setTitle("Retry")
	    .setMessage("You took way too long? retry?")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	load();
	    
	        	
	        }
	     })
	    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // do nothing
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}
		
	
	public void tryAnother()
	{
		new AlertDialog.Builder(this)
	    .setTitle("Good")
	    .setMessage("How do you think you did?")
	    .setPositiveButton("Good", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	ok=ok+1;
	        	if (ok<3)
	        	  load();
	        	else
	        		
	        		loadAnother();
	    
	        	
	        }
	     })
	    .setNegativeButton("Not good.", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            ok=0;
	        	load();
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}
	public void load()
	{
		Intent intent = new Intent(this,Level2.class);
	    intent.putExtra("ok", ok);
    	startActivity(intent);
    	this.finish();
	}
		
	public void loadAnother()
	{
		new AlertDialog.Builder(this)
	    .setTitle("Great!!")
	    .setMessage("Its time to move to next level..")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	loadc();
	    
	        	
	        }
	     })
	    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // do nothing
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
	}
	public void loadc()
	{
		Intent intent = new Intent(this,LevelP.class);
    	startActivity(intent);
    	this.finish();
	}
		public void play(View view)
		{
			if (mp==null)
			{
				 Random randomGenerator = new Random();
				 int randomInt =randomGenerator.nextInt(6);
				 switch(randomInt)
				 {
				 //database will be used for bigger data
				 case 1:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.b);
				        mp.start();
				        textView1.setText("My mom drove me to school fifteen minutes late on Tuesday.");
				        textView2.setText("00:05");
				       break;
				 case 2:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.c);
				        mp.start();
				        textView1.setText("My shoes are blue with yellow stripes and green stars on the front.");
				        textView2.setText("00:05");
				        break;
				 case 3:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.d);
				        mp.start();
				        textView1.setText("The door slammed down on my hand and I screamed like a little baby.");
				        textView2.setText("00:05");
				        break;
				 case 4:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.e);
				        mp.start();
				        textView1.setText("The tape got stuck on my lips so I couldn't talk anymore.");
				        textView2.setText("00:05");
				        break;
				 case 5:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.f);
				        mp.start();
				        textView1.setText("The mouse was so hungry he ran across the kitchen floor without even looking for humans.");
				        textView2.setText("00:06");
				        break;
				 case 6:
					 mp = MediaPlayer.create(Level2.INSTANCE, R.raw.g);
				        mp.start();
				        textView1.setText("The girl wore her hair in two braids, tied with two blue bows.");
				        textView2.setText("00:06");
				        break;
					 
				 }
				 
			   
				 
			}
			else
			{
				mp.stop();
				mp=null;
			}
		 
		}
		@Override
	     public void onBackPressed() {
			if(mp!=null)
			  {
				mp.stop();
			  mp=null;
			  goBack();
			  }
			else
			{
				goBack();
			}
	   	  
	   	  
	     }
	     
		public void goBack()
		{
			Intent intent=new Intent(this,LevelP.class);
			startActivity(intent);
		}
		
		public void trythis(View view)
		{
			Intent intent=new Intent(this,Trythis.class);
			startActivity(intent);
					
		}
		
		
		 
		
	}


