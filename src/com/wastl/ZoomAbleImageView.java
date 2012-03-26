package com.wastl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

/**
 * 
 * @author Patrik Kimmeswenger
 * @version 1.2.3, 26/03/2012
 * @since 1.2.1
 */

public class ZoomAbleImageView extends ImageView {

	protected Drawable image;


	protected int imageHeigth;
	protected int imageWidth;
	
	
	private float scaleFactor    = 0.f;
	private float scaleFactorMin = 0.f;
	private float scaleFactorMax = 2.f;
	
	private float 	 lastTouchX	   = 0.f;
	private float 	 lastTouchY	   = 0.f;
	
	private Integer  dx = 0;
	private Integer	 dy = 0;
	
	private ScaleGestureDetector scaleDetector;
	
	private static final int INVALID_POINTER_ID = -1;

	// The ‘active pointer’ is the one currently moving our object.
	private int activePointerId = INVALID_POINTER_ID;
	
	
	public ZoomAbleImageView(Context context, AttributeSet attrs) {
	
		super(context, attrs);
		
		this.scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		
		this.setFocusable(true);
	}
	
	
	
	
	@Override
	protected void onDraw(Canvas _canvas) {
		
		super.onDraw(_canvas);
		
		Integer top    = 0;
		Integer bottom = 0;
		Integer left   = 0;
		Integer right  = 0;
		
	    Configuration c = getResources().getConfiguration();
	      	 
		
		// if this funktion is called first time
		// set the scaleFactor to maximize the view to the view height
		if(this.scaleFactor == 0.f)
		{
			
			// portrait
		    if(c.orientation == Configuration.ORIENTATION_PORTRAIT ) 
				this.scaleFactorMin = (float)((float)this.getHeight() / (float)this.imageHeigth);
				
		    // landscape
		    else if(c.orientation == Configuration.ORIENTATION_LANDSCAPE )
		    	this.scaleFactorMin = (float)((float)this.getWidth() / (float)this.imageWidth);
				
		    
		    this.scaleFactor    = this.scaleFactorMin;
		}
		
		// Set Bounds
		top    = (int) (((this.imageHeigth * this.scaleFactor) - this.getHeight()) / -2) - this.dy;
		bottom = (int) (this.getHeight() + ((this.imageHeigth * this.scaleFactor) - this.getHeight()) /2) - this.dy;
		
		left   = (int) (((this.imageWidth * this.scaleFactor) - this.getWidth()) / -2) - this.dx;
		right  = (int) (this.getWidth() + ((this.imageWidth * this.scaleFactor) - this.getWidth()) / 2) - this.dx;
		
		
		// if left bound is on the letf side of the view
		if (left > 0)
		{
			left = 0;
			right = (int) (this.getWidth() + ((this.imageWidth * this.scaleFactor) - this.getWidth()));
			this.dx = (int) (((this.imageWidth * this.scaleFactor) - this.getWidth()) / -2);
		}
		
		// if right bound is on the right side of the view
		if (this.getWidth() > right)
		{
			right = this.getWidth();
			left  = (int) (((this.imageWidth * this.scaleFactor) - this.getWidth()) * -1);
			this.dx = (int) (((this.imageWidth * this.scaleFactor) - this.getWidth()) / 2);
		}
	
		// if top bound is on the top side of the view
		if (top > 0)
		{
			top = 0;
			bottom = (int) (this.getHeight() + ((this.imageHeigth * this.scaleFactor) - this.getHeight()));
			this.dy = (int) (((this.imageHeigth * this.scaleFactor) - this.getHeight()) / -2);
		}
		
		// if bottom bound is on the bottom side of the view
		if (this.getHeight() > bottom)
		{
			bottom = this.getHeight();
			top    = (int) (((this.imageHeigth * this.scaleFactor) - this.getHeight()) * -1);
			this.dy = (int) (((this.imageHeigth * this.scaleFactor) - this.getHeight()) / 2);
		}

		this.image.setBounds(left, top, right, bottom);
		this.image.draw(_canvas);
	}


	@Override
	public boolean onTouchEvent(MotionEvent _e) 
	{

		final int action = _e.getAction();
		
		// Let the ScaleGestureDetector inspect all events.
		this.scaleDetector.onTouchEvent(_e);

		switch (action & MotionEvent.ACTION_MASK) {
    
    		case MotionEvent.ACTION_DOWN:
    		{
    			final float x = _e.getX();
    			final float y = _e.getY();
    		
    			// Remember last Touch
    			this.lastTouchX = x;
    			this.lastTouchY = y;
    			
    			this.activePointerId = _e.getPointerId(0);
    			break;
    		}
    
    		
    		case MotionEvent.ACTION_MOVE:
    		{
    			// Find the index of the active pointer and fetch its position    		
    			final float x = _e.getX();
    			final float y = _e.getY();
    			
    			
    			// Only move if the ScaleGestureDetector isn't processing a gesture.
    	        if (!this.scaleDetector.isInProgress()) 
    	        {
    	        	
    	        	this.dx += (int) (-(x - this.lastTouchX) ) / 2;
    	        	this.dy += (int) (-(y - this.lastTouchY)   / 2);

    	            invalidate();
    	        }

    			
    			// the difference to the last touch point
    			// needed to move the object in OnDraw()
    	        this.dx += (int) (-(x - this.lastTouchX) ) / 2;
    	        this.dy += (int) (-(y - this.lastTouchY)   / 2);
    			
    			// remeber this touch point
    			this.lastTouchX = x;
    			this.lastTouchY = y;
    			
    			// Invalidate to request a redraw
    			this.invalidate();
    			break;
    		}
    		
    		case MotionEvent.ACTION_UP:
    		{
    			this.activePointerId = ZoomAbleImageView.INVALID_POINTER_ID;
    			break;
    		}
    
    		case MotionEvent.ACTION_CANCEL:
    		{
    			this.activePointerId = ZoomAbleImageView.INVALID_POINTER_ID;
    			break;
    		}
    		
    		case MotionEvent.ACTION_POINTER_UP:
    		{
    			// Extract the index of the pointer that left the touch sensor
    			final int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
    					>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
    				
    			final int pointerId = _e.getPointerId(pointerIndex);
    			
    			if(pointerId == this.activePointerId)
    			{
    				// This was our active pointer going up. Choose a new
    	            // active pointer and adjust accordingly.
    				final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
    				
    				this.lastTouchX = _e.getX(newPointerIndex);
    				this.lastTouchY = _e.getY(newPointerIndex);
    				this.activePointerId  = _e.getPointerId(newPointerIndex);
    			}
    			
    			break;
    		}
    			    
		}
    
		return true;
	}
	
	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
	    @Override
	    public boolean onScale(ScaleGestureDetector detector) 
	    {
	    	scaleFactor *= detector.getScaleFactor();
	        
	        // Don't let the object get too small or too large.
	        scaleFactor = Math.max(scaleFactorMin, Math.min(scaleFactor, scaleFactorMax));

	        invalidate();
	        return true;
	    }
	}
	
	
}

