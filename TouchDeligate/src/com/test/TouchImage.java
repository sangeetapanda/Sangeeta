package com.test;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.touchdeligate.R;


public class TouchImage extends Activity implements android.view.View.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		View parent = (RelativeLayout)findViewById(R.id.parent);
	parent.post( new Runnable() {
	    public void run() { 
	        final Rect rect = new Rect(); 
	        ImageView v = (ImageView)findViewById(R.id.imageView1);
	        v.setOnClickListener(TouchImage.this);
	        v.getHitRect(rect); 
	        rect.top -= 100;    // increase top hit area
	        rect.left -= 100;   // increase left hit area
	        rect.bottom += 100; // increase bottom hit area           
	        rect.right += 100;  // increase right hit area
	        TouchDelegate touchDelegate = new TouchDelegate(rect,
					v);

			if (View.class.isInstance(v.getParent())) {
				((View) v.getParent())
						.setTouchDelegate(touchDelegate);
			}
	    } 
	}); 
		
	}	
		

	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("TAG", "Hello");
	}

}
