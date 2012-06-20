package com.wastl.Activity;

import java.io.IOException;
import java.util.Locale;

import com.ithtl.essapp.R;
import com.wastl.AppFacade;
import com.wastl.Database.DatabaseFacade;
import com.wastl.Database.FireDepartments;
import com.wastl.Entity.FireDepartmentEntity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
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
 * @version 1.3, 19/06/2012
 * @since 1.2.1
 */
public class FireDepartmentInfoActivity extends Activity implements Runnable 
{
	private ProgressDialog mProgressDialog = null;
	private FireDepartmentEntity mEntity = null;
	private double mLatitude = 0.0;
	private double mLongitude = 0.0;
	
	private long mDistrictId = 0;
	private long mFId = 0;

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_department_info);
        
        this.initializeObjects();                
        
		this.loadData();
	}
	
	private void initializeObjects()
	{
		this.mDistrictId = this.getIntent().getExtras().getLong(AppFacade.GetExId());
		this.mFId = this.getIntent().getExtras().getLong(AppFacade.GetExFId());
	}
	// show the progress dialog and start a tread to read the clicked fire department.
	private void loadData()
	{
		this.mProgressDialog = ProgressDialog.show(this, "", "Daten werden gelesen", true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		FireDepartments fireDepartments = new FireDepartments(this);
		Cursor c = fireDepartments.fetchFireDepartment(this.mFId);
		this.mEntity = this.getDataFromCursor(c);
		
		try{
			this.mLatitude = this.getLatitude(this.mEntity.getFireDepartmentLocation());
			this.mLongitude = this.getLongitude(this.mEntity.getFireDepartmentLocation());
		}catch(Exception e)
		{
			Log.d(AppFacade.GetTag(), e.getMessage());
		}
		
		
		this.handler.sendEmptyMessage(0);
	}
	
	private FireDepartmentEntity getDataFromCursor(Cursor _cursor)
	{
		if(_cursor.getCount() > 1)		
			return null;
		else
		{
			FireDepartmentEntity entity = new FireDepartmentEntity();
			
			entity.setFireDepartmentDistrictID(this.mDistrictId);
			entity.setFireDepartmentId(_cursor.getInt(_cursor.getColumnIndex(DatabaseFacade.GetColumnFdId())));
			entity.setFireDepartmentName(_cursor.getString(_cursor.getColumnIndex(DatabaseFacade.GetColumnFdName())));
			entity.setFireDepartmentLocation(_cursor.getString(_cursor.getColumnIndex(DatabaseFacade.GetColumnFdLocation())));
			entity.setFireDepartmentPhoneNumber(_cursor.getString(_cursor.getColumnIndex(DatabaseFacade.GetColumnFdPhoneNumber())));
			
			return entity;
		}
	}
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	mProgressDialog.dismiss();
                      
        	setMobilePhoneNumber(mEntity.getFireDepartmentPhoneNumber());
        	setLocationText(mEntity.getFireDepartmentLocation());
        	setFireDepartment(mEntity.getName());
    		
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
			Log.d(AppFacade.GetTag(), "Unable to convert address to latitude");
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
			Log.d(AppFacade.GetTag(), "Unable to convert address to longitude");
			return -1;
		}	
	}
	
	public double getLatitude() { return this.mLatitude; }
	
	public double getLongitude() { return this.mLongitude; }
}