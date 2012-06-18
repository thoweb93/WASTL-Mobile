package com.wastl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * 
 * @author Patrik Kimmeswenger
 *
 */
public class WastlMap extends ZoomAbleImageView
{		
	public static Drawable map;
	
	public WastlMap(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		
		image = WastlMap.map;
		
		imageHeigth = image.getIntrinsicHeight();
		imageWidth  = image.getIntrinsicWidth();
	
	}	

}
