/*
 * Filename: MapActivity.java
 * Author: Lukas Bernreiter
 * Last change: 02.10.2011
 * Description: Activity class of the map screen
 */
package com.wastl.Activity;

// com.wastl
import java.security.acl.Group;

import com.wastl.BitmapCombinator;
import com.ithtl.essapp.R;
import com.wastl.WastlMap;
import com.wastl.District.District;
import com.wastl.District.DistrictFactory;
import com.wastl.Enums.EnumDistricts;
import com.ithtl.essapp.R.id;
// Android
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * 
 * @author Patrik Kimmeswenger
 *
 */

public class MapActivity extends Activity implements Runnable{
	
	private Context context;
	
	private ProgressDialog progressDialog;
	
	@SuppressWarnings("unused")
	private Group group_showLegend;
	
	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.context = this.getApplicationContext();
        
        this.createMap();
        
    }
    
	private void createMap()
	{
		
		if(WastlMap.map != null)
		{
			setContentView(R.layout.map);
			Log.d("WASTL", "null");
			return;
		}
		
		this.progressDialog = ProgressDialog.show(this, "", "Karte wird erstellt...", true);

		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	
        	progressDialog.dismiss();
                    
        	setContentView(R.layout.map);
        }
       
	};

	public void run()
	{
		Drawable map = context.getResources().getDrawable(R.drawable.niederoesterreich);
		
		for(int i=0; i < DistrictFactory.getMap().size(); i++)
		{
			
			Integer districtId = ((District)(DistrictFactory.getMap().values().toArray()[i])).getId();
			
			switch(districtId)
			{
				case EnumDistricts.Id_BAZ_AMSTETTEN:
					
					map = this.switchAlert(i, map, R.drawable.amstetten_low, R.drawable.amstetten_middle, R.drawable.amstetten_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_HOLLABRUNN:
					
					map = this.switchAlert(i, map, R.drawable.hollabrunn_low, R.drawable.hollabrunn_middle, R.drawable.hollabrunn_high);
					break;
					
					
				case EnumDistricts.Id_AAZ_KLOSTERNEUBURG:
					
					map = this.switchAlert(i, map, R.drawable.klosterneuburg_low, R.drawable.klosterneuburg_middle, R.drawable.klosterneuburg_high);
					break;
					
					
				case EnumDistricts.Id_AAZ_SCHWECHAT:
					
					map = this.switchAlert(i, map, R.drawable.schwechat_low, R.drawable.schwechat_middle, R.drawable.schwechat_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_BADEN:
					
					map = this.switchAlert(i, map, R.drawable.baden_low, R.drawable.baden_middle, R.drawable.baden_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_BRUCK_LEITHA:
					
					map = this.switchAlert(i, map, R.drawable.bruck_low, R.drawable.bruck_middle, R.drawable.bruck_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_GMÜND:
					
					map = this.switchAlert(i, map, R.drawable.gmuend_low, R.drawable.gmuend_middle, R.drawable.gmuend_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_GÄNSENDORF:
					
					map = this.switchAlert(i, map, R.drawable.gaenserndorf_low, R.drawable.gaenserndorf_middle, R.drawable.gaenserndorf_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_HORN:
					
					map = this.switchAlert(i, map, R.drawable.horn_low, R.drawable.horn_middle, R.drawable.horn_high);
					break;
				
					
				case EnumDistricts.Id_BAZ_KREMS_DONAU:
					
					map = this.switchAlert(i, map, R.drawable.krems_low, R.drawable.krems_middle, R.drawable.krems_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_LILIENFELD:
					
					map = this.switchAlert(i, map, R.drawable.lilienfeld_low, R.drawable.lilienfeld_middle, R.drawable.lilienfeld_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_MELK:
					
					map = this.switchAlert(i, map, R.drawable.melk_low, R.drawable.melk_middle, R.drawable.melk_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_MISTELBACH:
					
					map = this.switchAlert(i, map, R.drawable.mistelbach_low, R.drawable.mistelbach_middle, R.drawable.mistelbach_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_MÖDLING:
					
					map = this.switchAlert(i, map, R.drawable.moedling_low, R.drawable.moedling_middle, R.drawable.moedling_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_NEUNKIRCHEN:
					
					map = this.switchAlert(i, map, R.drawable.neunkirchen_low, R.drawable.neunkirchen_middle, R.drawable.neunkirchen_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_SCHEIBBS:
					
					map = this.switchAlert(i, map, R.drawable.scheibbs_low, R.drawable.scheibbs_middle, R.drawable.scheibbs_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_ST_PÖLTEN:
					
					map = this.switchAlert(i, map, R.drawable.stpoelten_low, R.drawable.stpoelten_middle, R.drawable.stpoelten_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_STOCKERAU:
					
					map = this.switchAlert(i, map, R.drawable.klosterneuburg_low, R.drawable.korneuburg_middle, R.drawable.korneuburg_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_TULLN:
					
					map = this.switchAlert(i, map, R.drawable.tulln_low, R.drawable.tulln_middle, R.drawable.tulln_high);
					break;
				
				case EnumDistricts.Id_BAZ_WAIDHOFEN_THAYA:
					
					map = this.switchAlert(i, map, R.drawable.waidhofen_low, R.drawable.waidhofen_middle, R.drawable.waidhofen_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_WIENER_NEUSTADT:
	
					map = this.switchAlert(i, map, R.drawable.wrneustadt_low, R.drawable.wrneustadt_middle, R.drawable.wrneustadt_high);
					break;
					
				case EnumDistricts.Id_AAZ_PURKERSDORF:
					map = this.switchAlert(i, map, R.drawable.wup_low, R.drawable.wup_middle, R.drawable.wup_high);
					break;
					
					
				case EnumDistricts.Id_BAZ_ZWETTL:
					
					map = this.switchAlert(i, map, R.drawable.zwettl_low, R.drawable.zwettl_middle, R.drawable.zwettl_high);
					break;
					
				default:
					break;
			}
		
		
		}
		WastlMap.map = map;
		
		handler.sendEmptyMessage(0);
	}
	
	private Drawable switchAlert(Integer _bezirk, Drawable _map, Integer _low, Integer _middle, Integer _high)
	{
		Integer missions = ((District)(DistrictFactory.getMap().values().toArray()[_bezirk])).getCountFireDepartment();
		
		if(missions == 0)
			return _map;
		
		switch(missions)
		{
			case 1:
			case 2:  
				
				_map = BitmapCombinator.combinate(_map, context.getResources().getDrawable(_low));
				break;
				
			case 3:
			case 4:
			case 5:
				
				_map = BitmapCombinator.combinate(_map, context.getResources().getDrawable(_middle));
				break;
				
			default:
				
				_map = BitmapCombinator.combinate(_map, context.getResources().getDrawable(_high));
				break;
		}
		
		return _map;
	
	}
	
	
	public boolean onCreateOptionsMenu(Menu _menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.map_menu, _menu);
		
        //this.MenuItem_showLegend_low = (MenuItem) _menu.findItem(id.item_showlegend_low);
        //this.MenuItem_showLegend_middle = (MenuItem) _menu.findItem(id.item_showlegend_middle);
        //this.MenuItem_showLegend_high = (MenuItem) _menu.findItem(id.item_showlegend_high);
		this.group_showLegend = (Group) _menu.findItem(id.group_showlegend);
        //this.MenuItemRefresh.setOnMenuItemClickListener(this.eventListener);
		return true;
	}
}
