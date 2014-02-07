package com.wanli.func;

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version 2014-1-17
 */
public class WanliLogin implements FREFunction {

	private String TAG = "WanliLogin";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		BridgeActivity._context = _context;
		Intent intent = new Intent(BridgeActivity.MYACTIVITY_ACTION);
		intent.putExtra("wanliKey", 0);
		Log.d(TAG, "---------startActivity-------");
		_context.getActivity().startActivity(intent);
		
		callBack("success");
		//--------------------------------
		
		return result;
	}

	
	public void callBack(String status){
		Log.d(TAG, status);
		_context.dispatchStatusEventAsync(TAG,status);
	}
}
