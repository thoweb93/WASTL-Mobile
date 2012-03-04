package com.wastl.Activity.Splash;

import java.io.InputStream;

import com.ithtl.essapp.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * @author Thomas Weber
 *
 */

public class GifView extends View {
	Movie movie;
	InputStream is=null;
	long moviestart;
	
	public GifView(Context context,  AttributeSet attrs){
		super(context, attrs);
		is = context.getResources().openRawResource(R.drawable.splash_ff);
		movie = Movie.decodeStream(is);		
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.TRANSPARENT);
		super.onDraw(canvas);
		long now = android.os.SystemClock.uptimeMillis();
		if(moviestart ==0){
			moviestart = now;
		}
		int relTime = (int)((now - moviestart) % movie.duration());
		movie.setTime(relTime);
		movie.draw(canvas, 0, 0);		
		this.invalidate();
	}
}
