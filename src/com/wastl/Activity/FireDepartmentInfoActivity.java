/*
 * Filename: FireDepartmentInfoActivity.java
 * Author: Lukas Bernreiter
 * Last change: 06.12.2011
 * Description: 
 */

package com.wastl.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.ithtl.essapp.R;
import com.wastl.Entity.FireDepartmentEntity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;

//2A:40:BD:94:AC:19:ED:F0:12:4B:BF:92:5C:C7:31:3D:A1:6B:4B:53

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.2.1, 19/02/2012
 * 
 * TODO Rewrite database connection with new database adapter
 */
public class FireDepartmentInfoActivity extends com.google.android.maps.MapActivity implements Runnable {

	
	// Objects
	// from GUI	
	private String selectedItemText;
	private MapView mapView;
	private MapController mapController;
	private ProgressDialog progressDialog;
	private Context context;
	private String phoneNumber;
	private String address;
	private double latitude;
	private double longitude;
	
	// intern
//	private DBAdapter dbAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_department_info);
        
        this.initializeObjects();                
        
        // Set Banner        
        this.setFireDepartment(this.selectedItemText);
        
        this.mapView.setBuiltInZoomControls(true);
		
		this.loadData();
		
		
	}
	
	private void initializeObjects()
	{
        this.selectedItemText 	= this.getIntent().getExtras().getString("selectedItemText");        
        this.context 			= this.getApplicationContext();        
        this.mapView 			= (MapView) this.findViewById(R.id.mapview);		
//        this.dbAdapter 			= new DBAdapter(this.context);                       
		this.mapController 		= mapView.getController();
	}
	// show the progress dialog and start a tread to read the clicked fire department.
	private void loadData()
	{
		this.progressDialog = ProgressDialog.show(this, "", "Daten werden gelesen", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		/*FireDepartmentEntity fireDepartment = this.dbAdapter.readFireDepartmentByString(this.selectedItemText);
		
		try{		
			// telephone number of the selected fire department
			this.phoneNumber = fireDepartment.getFireDepartmentPhoneNumber();
					
			// location of the fire department
			this.address = fireDepartment.getFireDepartmentLocation();
			
		
				// Convert address to latitude and longitude
				this.latitude = this.getLatitude(address);
				this.longitude = this.getLongitude(address);
							
			
		}catch(Exception e){Log.d("WASTL", e.getMessage());}
		*/
		this.handler.sendEmptyMessage(0);
	}
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	progressDialog.dismiss();
                      
        	setMobilePhoneNumber(phoneNumber);
        	setLocationText(address);
        	
        	// Check if the conversion was successful and 
        	// set the mapView with the converted latitude and longitude
    		if(latitude != -1 && longitude != -1)
    			setMapView(latitude, longitude);
    		
    		List<Overlay> mapOverlays = mapView.getOverlays();
    		Drawable drawable = getResources().getDrawable(R.drawable.logo_place);
    		FireDepartmentItemizedOverlay itemizedoverlay = new FireDepartmentItemizedOverlay(drawable);
    		
    		GeoPoint point = new GeoPoint((int)(latitude * 1e6),(int)(longitude * 1e6));
    		
    		OverlayItem overlayitem = new OverlayItem(point, "Feuerwehr", selectedItemText);
    		
    		itemizedoverlay.addOverlay(overlayitem);
    		mapOverlays.add(itemizedoverlay);
    		
    			mapView.setVisibility(0);    			
    		
        }
	};
	
	private void setFireDepartment(String _fireDepartment)
	{
		TextView tvFireDepartment = (TextView)this.findViewById(R.id.tvFireDepartment);
		
		tvFireDepartment.setText(_fireDepartment);
	}
	
	private void setLocationText(String _location)
	{
		TextView tvLocation = (TextView)this.findViewById(R.id.textView_Location);
	
		tvLocation.setText(_location);
		Linkify.addLinks(tvLocation, Linkify.MAP_ADDRESSES);
	}
	
	private void setMobilePhoneNumber(String _phoneNumber)
	{
		TextView tvMobilePhone = (TextView)this.findViewById(R.id.textView_MobilePhone);
		
		tvMobilePhone.setText("Tel.: "+_phoneNumber);		
		
		Linkify.addLinks(tvMobilePhone, Linkify.PHONE_NUMBERS);
	}
	
	@Override
	protected boolean isRouteDisplayed() {			
		return false;
	}
	// retrieves the longitude for a specific address
	private double getLatitude(String _address)
	{
		double latitude = 0;
		Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
		
		try {
			// convert address
			Address convertedAddress = geoCoder.getFromLocationName(_address,1).get(0);
			
			// retrieve latitude
			latitude = convertedAddress.getLatitude();
			
			// return latitude
			return latitude;
			
		} catch (IOException e) {
			Log.d("WASTL", "Unable to convert address");
			return -1;
		}					
	}
	
	// retrieves the longitude for a specific address
	private double getLongitude(String _address)
	{
		double longitude = 0;
		Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
	
		try {
			Address convertedAddress = geoCoder.getFromLocationName(_address,1).get(0);
			
			longitude = convertedAddress.getLongitude();
			
			return longitude;
			
		} catch (IOException e) {
			Log.d("WASTL", "Unable to convert address");
			return -1;
		}	
	}
	// Sets the MapView
	private void setMapView(double _latitude, double _longitude)
	{
		GeoPoint point = new GeoPoint(
	            (int) (_latitude * 1E6), 
	            (int) (_longitude * 1E6));
	 
		this.mapController.setCenter(point);
		this.mapController.setZoom(17);
		this.mapView.invalidate();
	}	
}
class FireDepartmentItemizedOverlay extends ItemizedOverlay<OverlayItem>
{
	private ArrayList<OverlayItem> mapOverlays = new ArrayList<OverlayItem>();	
	
	public FireDepartmentItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));	
	}
	
	public void addOverlay(OverlayItem overlay) {
		mapOverlays.add(overlay);
	    populate();
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		return mapOverlays.get(i);
	}

	@Override
	public int size() {
		return mapOverlays.size();
	}		
}
