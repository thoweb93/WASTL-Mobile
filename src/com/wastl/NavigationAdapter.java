package com.wastl;

import com.ithtl.essapp.R;
import com.wastl.Activity.MainActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Defines the structure of the grid view.
 * 
 * @author Lukas Bernreiter
 * @version 1.2.2, 09/03/2012
 * @since 1.2.2
 */
public class NavigationAdapter extends BaseAdapter
{
	private Context mContext = null;
	private MainActivity mMain = null;

	private String[] mCaptions = {"Aktuelle Statistik", "Aktuelle Einsätze", "Einsatzkarte", "Feuerwehren durchsuchen", "Suchen", "WASTL Homepage"};
	private int[] mThumbIds = {R.drawable.grid_statistic, R.drawable.grid_alarm, R.drawable.grid_map, R.drawable.grid_browse, R.drawable.grid_search, R.drawable.grid_www };
	
	/**
	 * Default constructor
	 */
	public NavigationAdapter() { }
	
	/**
	 * Constructor, saves the instance of the main activity.
	 * @param _main the instance.
	 */
	public NavigationAdapter(MainActivity _main)
	{
		this.mContext = _main.getApplicationContext();
		this.mMain = _main;
	}
	
	/**
	 * Retrieves the count of the thumbs.
	 */
	public int getCount() {
		return mThumbIds.length;
	}

	/**
	 * Retrieves the drawable for a given position.
	 * @param _position The position of the drawable.
	 * @return 			The drawable.
	 */
	public Object getItem(int _position) {
		return mContext.getResources().getDrawable(mThumbIds[_position]);
	}

	/**
	 * Retrieves the id of a drawable for a given position.
	 * @param _position The position.
	 * @return 			The id.
	 */
	public long getItemId(int _position) {
		return mThumbIds[_position];
	}
	
	/**
	 * Retrieves the caption from a thumb.
	 * @param _position The position of the thumb.
	 * @return 			The caption.
	 */
	public String getCaption(int _position){
		return mCaptions[_position];
	}

	/**
	 * Retrieves the view.
	 */
	public View getView(int _position, View _convertView, ViewGroup _parent) {

		View view = null;
		
		if(null == _convertView)
		{						
			LayoutInflater inflater = mMain.getLayoutInflater();
			view = inflater.inflate(R.layout.gridview_icon, null);				
        } else 
            view = _convertView;

		// Set text
		((TextView)view.findViewById(R.id.textView_GridView)).setText(mCaptions[_position]);
		
		// Set image
		Drawable currentImage = mContext.getResources().getDrawable(mThumbIds[_position]);
		currentImage.setBounds(0, 0, 100, 100);
		((TextView)view.findViewById(R.id.textView_GridView)).setCompoundDrawables(null, currentImage, null, null);
		
        return view;
	}
	
	
}
