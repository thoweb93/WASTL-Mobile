package com.wastl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * 
 * @author Patrik Kimmeswenger
 *
 */

public class BitmapCombinator {
	
	
	public static Drawable combinate(Drawable _bottomImage, Drawable _topImage)
	{	
		
		Bitmap bottomImage = ((BitmapDrawable)_bottomImage).getBitmap();
		Bitmap topImage    = ((BitmapDrawable)_topImage)   .getBitmap();
		
		Bitmap base = Bitmap.createBitmap(bottomImage.getWidth(), bottomImage.getHeight(), Bitmap.Config.ARGB_8888 );
		
		Canvas comboImage = new Canvas(base);
		
		// Then draw the second on top of that
		comboImage.drawBitmap(bottomImage, new Matrix(), null);
		comboImage.drawBitmap(topImage,    new Matrix(), null);
		comboImage.save();

		// bottomImage is now a composite of the two. 
		return new BitmapDrawable(base);
	}
	
	public static Drawable combinate(Drawable _bottomImage, Drawable _topImage, String _outPutPath)
	{	
		
		Bitmap bottomImage = ((BitmapDrawable)_bottomImage).getBitmap();
		Bitmap topImage    = ((BitmapDrawable)_topImage)   .getBitmap();
		
		Bitmap base = Bitmap.createBitmap(bottomImage.getWidth(), bottomImage.getHeight(), Bitmap.Config.ARGB_8888 );
		
		Canvas comboImage = new Canvas(base);
		
		// Then draw the second on top of that
		comboImage.drawBitmap(bottomImage, new Matrix(), null);
		comboImage.drawBitmap(topImage,    new Matrix(), null);
		comboImage.save();

		// bottomImage is now a composite of the two. 
		
		// To write the file out to the SDCard:
		OutputStream os = null;
		try 
		{
		    os = new FileOutputStream(_outPutPath);
		    base.compress(CompressFormat.PNG, 0, os);
		} 
		catch(IOException e) 
		{
		    Log.e(AppFacade.GetTag(), "Error while combinating images");
		}

		return new BitmapDrawable(base);
	}


}
