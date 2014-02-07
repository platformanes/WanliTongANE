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
 * @version 2014-1-16
 */
public class WanliPay implements FREFunction {

	private String TAG = "WanliPay";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		String payName = null;
		int payMon = 0;
		try
		{
			payMon = arg1[0].getAsInt();
			payName = arg1[1].getAsString();
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("argv is error");
			return null;
		}
		BridgeActivity._context = _context;
		Intent intent = new Intent(BridgeActivity.MYACTIVITY_ACTION);
		intent.putExtra("wanliKey", 2);
		intent.putExtra("payName", payName);
		intent.putExtra("payMon", payMon);
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
