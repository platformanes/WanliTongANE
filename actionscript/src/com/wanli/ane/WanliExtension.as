package com.wanli.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class WanliExtension extends EventDispatcher 
	{ 
		public static const WANLI_FUNCTION_INIT:String = "wanli_function_init";//与java端中Map里的key一致
		public static const WANLI_FUNCTION_LOGIN:String = "wanli_function_login";//与java端中Map里的key一致
		public static const WANLI_FUNCTION_RECH:String = "wanli_function_rech";//与java端中Map里的key一致
		public static const WANLI_FUNCTION_PAY:String = "wanli_function_pay";//与java端中Map里的key一致
		public static const WANLI_FUNCTION_EXCHANGE:String = "wanli_function_exchange";//与java端中Map里的key一致
		public static const WANLI_FUNCTION_EXIT:String = "wanli_function_exit";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.wanli.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:WanliExtension; 
		public function WanliExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():WanliExtension
		{
			if(_instance == null) 
				_instance = new WanliExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		
		public function WanliInit(key:int):String{
			if(extContext ){
				return extContext.call(WANLI_FUNCTION_INIT,key) as String;
			}
			return "call login failed";
		} 
		
		
			
		public function WanliLogIn(key:int):String{
			if(extContext ){
				return extContext.call(WANLI_FUNCTION_LOGIN,key) as String;
			}
			return "call login failed";
		} 
		
		public function WanliRech(key:int):String{
			if(extContext ){
				return extContext.call(WANLI_FUNCTION_RECH,key) as String;
			}
			return "call WanliRech failed";
		} 
		 
		public function WanliPay( payName:String = null,payMon:int = 0):String{
			if(extContext){ 
				return extContext.call(WANLI_FUNCTION_PAY,payMon,payName)as String;
			}
			return "call pay failed";
		}
		
		public function WanliExch(key:int):String{
			if(extContext ){
				return extContext.call(WANLI_FUNCTION_EXCHANGE,key) as String;
			}
			return "call WanliRech failed";
		} 
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function WanliExit(key:int):String{
			if(extContext){ 
				return extContext.call(WANLI_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
	} 
}