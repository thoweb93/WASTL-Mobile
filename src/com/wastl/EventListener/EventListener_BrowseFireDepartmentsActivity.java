package com.wastl.EventListener;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ithtl.essapp.R;
import com.wastl.AppFacade;
import com.wastl.Activity.BrowseFireDepartmentsActivity;
import com.wastl.Activity.FireDepartmentInfoActivity;

/**
 * 
 * @author Lukas Bernreiter
 * @version 1.3, 20/06/2012
 * @since 1.3
 */
public class EventListener_BrowseFireDepartmentsActivity implements OnItemClickListener 
{
	private BrowseFireDepartmentsActivity mFireDepartmentActivity = null;
	
	public EventListener_BrowseFireDepartmentsActivity(BrowseFireDepartmentsActivity _activity)
	{
		this.mFireDepartmentActivity = _activity;
	}
	
	public void setEvents()
	{
		((ListView)this.mFireDepartmentActivity.findViewById(R.id.listView_Content)).setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> _adapter, View _view, int _position, long _id) 
	{
		Intent intent = new Intent(this.mFireDepartmentActivity, FireDepartmentInfoActivity.class);
		intent.putExtra(AppFacade.GetExId(), this.mFireDepartmentActivity.getDistrictId());
		intent.putExtra(AppFacade.GetExFId(), _id);
		
		this.mFireDepartmentActivity.startActivity(intent);
	}
}
