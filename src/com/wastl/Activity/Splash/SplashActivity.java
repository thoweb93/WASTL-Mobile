package com.wastl.Activity.Splash;

import com.wastl.R;
import com.wastl.XML;
import com.wastl.Activity.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 */
public class SplashActivity extends Activity {

	private XML xml;	
	private final int welcomeScreenDisplay = 20000;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.splash);
	
	Thread welcomeThread = new Thread() {

		int wait = 0;
		
		@Override
		public void run() {
			try {
				super.run();		
				while (wait < welcomeScreenDisplay) {
					sleep(100);
					wait += 100;
				}				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	};
	
	Thread initaliazeObjectsThread = new Thread() {
		public void run(){
			xml = new XML();	
			xml.initaliazeObjects();			
			startActivity(new Intent(SplashActivity.this,MainActivity.class));
			finish();
		}
	};
	
	initaliazeObjectsThread.start();
	welcomeThread.start();
	
	}
	
}