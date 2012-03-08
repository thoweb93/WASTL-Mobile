package com.wastl.Activity.Splash;

import com.ithtl.essapp.R;
import com.wastl.XMLWrapper;
import com.wastl.Activity.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Defines the splash screen. Downloads the global XML file and fills the district map.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 04/03/2012
 * @since 1.2.1
 */
public class SplashActivity extends Activity implements Runnable {

	private XMLWrapper mXMLWrapper = null;
	private Thread mSplash = null;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		this.initializeObjects();
	}
	
	private void initializeObjects()
	{
		this.mSplash = new Thread(this);
		this.mSplash.start();
	}
	
	public void run() {
		synchronized (this) {
			mXMLWrapper = new XMLWrapper();
			mXMLWrapper.refreshStatus();
			
			// When finished start the main activity
			startActivity(new Intent(SplashActivity.this,MainActivity.class));
			finish();
		}
	}
	
}