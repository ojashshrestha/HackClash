package com.example.hack2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class LevelP extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_level);

		
	}

	@Override
    public void onBackPressed() {
		Intent intent = new Intent (this, Home.class);
		startActivity(intent);
	}
	
	public void abc(View view)
	{
		Intent intent = new Intent (this, Level1.class);
		startActivity(intent);
	}
	public void level2(View view)
	{
		Intent intent = new Intent(this, Level2.class);
		startActivity(intent);
		
	}
}
