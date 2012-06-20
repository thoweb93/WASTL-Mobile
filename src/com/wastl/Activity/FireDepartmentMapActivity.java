package com.wastl.Activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.ithtl.essapp.R;
import com.wastl.AppFacade;

/**
 * This class is a MapActivity, it contains a mapview and displays the location of a given latitude and longitude.
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 20/06/2012
 * @since 1.3
 */
public class FireDepartmentMapActivity extends com.google.android.maps.MapActivity 
{
	private MapView mMapView = null;
	private MapController mMapController = null;
	private double mLatitude = 0.0;
	private double mLongitude = 0.0;
	private String mName = new String();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_department_map);
        
        this.initializeObjects();                
                
		
        this.displayData(this.mLatitude, this.mLongitude);
	}
	
	private void initializeObjects()
	{
		this.mLatitude = this.getIntent().getExtras().getDouble(AppFacade.GetExLat());
		this.mLongitude = this.getIntent().getExtras().getDouble(AppFacade.GetExLong());
		this.mName = this.getIntent().getExtras().getString(AppFacade.GetExName());
		
		this.mMapView 			= (MapView) this.findViewById(R.id.mapview);
		this.mMapView.setBuiltInZoomControls(true);
		this.mMapController 	= mMapView.getController();
	}
	
	@Override
	protected boolean isRouteDisplayed() 
	{
		return false;
	}
	
	private void displayData(double _latitude, double _longitude)
	{
		// Check if the conversion was successful and 
    	// set the mapView with the converted latitude and longitude
		if(mLatitude != -1 && mLongitude != -1)
			setMapView(mLatitude, mLongitude);
		
		List<Overlay> mapOverlays = mMapView.getOverlays();
		Drawable drawable = getResources().getDrawable(R.drawable.logo_place);
		FireDepartmentItemizedOverlay itemizedoverlay = new FireDepartmentItemizedOverlay(drawable);
		
		GeoPoint point = new GeoPoint((int)(mLatitude * 1e6),(int)(mLongitude * 1e6));
		
		OverlayItem overlayitem = new OverlayItem(point, "Feuerwehr", this.mName);
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		mMapView.setVisibility(0);  
	}
	
	// Sets the MapView
	private void setMapView(double _latitude, double _longitude)
	{
		GeoPoint point = new GeoPoint(
	            (int) (_latitude * 1E6), 
	            (int) (_longitude * 1E6));
	 
		this.mMapController.setCenter(point);
		this.mMapController.setZoom(17);
		this.mMapView.invalidate();
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

