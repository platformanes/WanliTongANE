package com.wanli.func;



import com.adobe.fre.FREContext;
import com.pingan.gamecenter.GameCenterRequestCode;
import com.pingan.gamecenter.activity.ExchangeActivity;
import com.pingan.gamecenter.activity.LoginActivity;
import com.pingan.gamecenter.activity.PayActivity;
import com.pingan.gamecenter.activity.RechargeActivity;
import com.pingan.gamecenter.data.GameUser;
import com.pingan.gamecenter.manager.GameUserManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BridgeActivity extends Activity implements
OnClickListener {
	//声明开启Activity的Action
	public static final String MYACTIVITY_ACTION = "com.wanli.func.BridgeActivity";
	public String TAG = "BridgeActivity";
	public static FREContext _context;
	private LinearLayout layout;
	public static Boolean isLogin = false;
	protected static final int UPDATE_TEXT = 0;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case 1:
			finish();
			break;
		case 3:

			break;
		}
	}
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//构建界面

		super.onCreate(savedInstanceState);
		Log.d(TAG, "---------onCreate-------");

		// 隐藏标题栏  
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		// 隐藏状态栏  
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);//VERTICAL
		//		layout.setBackgroundResource(_context.getResourceId("drawable.bg"));
		this.setContentView(layout);
		layout.setId(1);
		layout.setOnClickListener(this);

		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		int wanliKey = bundle.getInt("wanliKey");
		switchFunc(wanliKey,bundle);
	}

	protected void switchFunc(int key,Bundle bundle)
	{
		switch(key)
		{
		case 0:
			LoginActivity.startLoginForResult(BridgeActivity.this);
			break;

		case 1:
			RechargeActivity.startRechargeForResult(BridgeActivity.this);
			break;

		case 2:
			String payName = bundle.getString("payName");
			int payMone = bundle.getInt("payMone");
			PayActivity.startPayForResult(BridgeActivity.this,payMone,payName);
			break;
			
		case 3:
			ExchangeActivity.startExchangeForResult(BridgeActivity.this);
			break;
			
		default:
			callBack(TAG,"the wanlikey is error");
			break;
		}
	}

	@Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == GameCenterRequestCode.LOGIN) {
	      if (resultCode == RESULT_OK) {
	        GameUser gameUser = GameUserManager.INSTANCE.getUser();
	        Toast.makeText(BridgeActivity.this, "login sucess:" + gameUser.getName(), Toast.LENGTH_SHORT)
	            .show();
	        callBack("WanliLogin","login sucess:" + gameUser.getName());
	      } else {
	        Toast.makeText(BridgeActivity.this, "login cancel", Toast.LENGTH_SHORT).show();
	        callBack("WanliLogin","login cancel");
	      }
	      finish();
	      
	    } else if (requestCode == GameCenterRequestCode.RECHARGE) {
	      if (resultCode == RESULT_OK) {
	        Toast.makeText(BridgeActivity.this, "recharge sucess:", Toast.LENGTH_SHORT).show();
	        callBack("WanliRecharge","recharge sucess");
	      } else {
	        Toast.makeText(BridgeActivity.this, "recharge cancel", Toast.LENGTH_SHORT).show();
	        callBack("WanliRecharge","recharge cancel");
	      }
	      finish();
	      
	    } else if (requestCode == GameCenterRequestCode.PAY) {
	      if (resultCode == RESULT_OK) {
	        Toast.makeText(BridgeActivity.this, "pay sucess:", Toast.LENGTH_SHORT).show();
	        callBack("WanliPay","pay sucess");
	      } else {
	        Toast.makeText(BridgeActivity.this, "pay cancel", Toast.LENGTH_SHORT).show();
	        callBack("WanliPay","pay cancel");
	      }
	      finish();
	      
	    } else if (requestCode == GameCenterRequestCode.EXCHANGE) {
	      if (resultCode == RESULT_OK) {
	        Toast.makeText(BridgeActivity.this, "exchange sucess:", Toast.LENGTH_SHORT).show();
	        callBack("WanliExchange","exchange sucess");
	      } else {
	        Toast.makeText(BridgeActivity.this, "exchange cancel", Toast.LENGTH_SHORT).show();
	        callBack("WanliExchange","exchange cancel");
	      }
	      finish();
	    }
	  }
	private void callBack(String _TAG,String status){
		Log.d(_TAG, "-----status----"+status);
		_context.dispatchStatusEventAsync(_TAG,status);
	}


	@Override  
	public boolean onKeyDown(int keyCode, KeyEvent event)  
	{  
		if (keyCode == KeyEvent.KEYCODE_BACK )  
		{  
			finish();
		}  
		return super.onKeyDown(keyCode, event);

	}  

}
