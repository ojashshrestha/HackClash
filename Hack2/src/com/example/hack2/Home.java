package com.example.hack2;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Home extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_home);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeAsUpIndicator(R.drawable.abc);
		 actionBar.setDisplayShowHomeEnabled(true);
	}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {

			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		
		public boolean onOptionsItemSelected(MenuItem item){
		    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
		    startActivityForResult(myIntent, 0);
		    return true;

		}
		
	

	public void Find(View view)
	{
		Intent intent = new Intent (this, Levels.class);
		startActivity(intent);
		
	}
	public void Practice(View view)
	{
		Intent intent = new Intent (this, LevelP.class);
		startActivity(intent);
	}
	
	public void trythis(View view)
	{
		Intent intent = new Intent (this, Trythis.class);
		startActivity(intent);
	}
	public void facts(View view)
	{
		Intent intent = new Intent (this, Facts.class);
		startActivity(intent);
	}
	
	
}
