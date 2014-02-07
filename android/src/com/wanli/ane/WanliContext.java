package com.wanli.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.wanli.func.WanliExchange;
import com.wanli.func.WanliExit;
import com.wanli.func.WanliInit;
import com.wanli.func.WanliLogin;
import com.wanli.func.WanliPay;
import com.wanli.func.WanliRecharge;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version 2014-1-16
 */
public class WanliContext extends FREContext {
	
	public static final String WANLI_FUNCTION_INIT = "wanli_function_init";
	
	public static final String WANLI_FUNCTION_LOGIN = "wanli_function_login";
	public static final String WANLI_FUNCTION_RECH = "wanli_function_rech";
	public static final String WANLI_FUNCTION_PAY = "wanli_function_pay";
	public static final String WANLI_FUNCTION_EXCHANGE = "wanli_function_exchange";
	
	public static final String WANLI_FUNCTION_EXIT = "wanli_function_exit";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(WANLI_FUNCTION_INIT, new WanliInit());
		   
	       map.put(WANLI_FUNCTION_LOGIN, new WanliLogin());
	       map.put(WANLI_FUNCTION_RECH, new WanliRecharge());
	       map.put(WANLI_FUNCTION_PAY, new WanliPay());
	       map.put(WANLI_FUNCTION_EXCHANGE, new WanliExchange());
	       
	       map.put(WANLI_FUNCTION_EXIT, new WanliExit());
	       return map;
	}

}
