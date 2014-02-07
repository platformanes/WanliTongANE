package air.com.wanli.ane;

import android.app.Application;

import com.pingan.gamecenter.GameCenter;

/**
 * 此类的包名会根据不同的项目包名而改变.
 * <li>例如 demo 包名为 air.com.wanli.ane
 * <li>则这个类的包名为 air.com.wanli.ane
 * <li>下面的GAME_KEY 应该是平台分配,请自行修改.
 * <li>最后祝产品大卖!by Rect.
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version 2014-1-16
 */
public class DoudizhuApplication extends Application {

  @SuppressWarnings("unused")
private final static String GAME_KEY_1 = "4b6df10997bd6a22b20afc65f9ff136d";
  private final static String GAME_KEY_2 = "dbbf4ceef0e28179c987d75a4b14bd82";
  private final static String TEST_GAME_KEY = GAME_KEY_2;

  private static DoudizhuApplication instance;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;

    GameCenter.init(this, TEST_GAME_KEY);
  }

  public static DoudizhuApplication getInstance() {
    return instance;
  }

  public void exit() {
    GameCenter.exit();
  }
}
