package com.wastl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class Networkstate 
{

	
	/**
	 * Retrieves the current network state, determines if the phone is online. 
	 * @param _context The application context.
	 * @return True if a connection to the Internet is present, false otherwise.
	 */
    public static Boolean GetNetworkState(Context _context)
    {
    	ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    	
    	return null != activeNetworkInfo;
    }
}
