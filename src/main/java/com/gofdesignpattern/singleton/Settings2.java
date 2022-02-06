package com.gofdesignpattern.singleton;

/**
 * 멀티쓰레드 환경에서 안전한 방법1
 */
public class Settings2 {

    private static Settings2 settings_instance = null;

    private Settings2() {}

    //synchronized 키워드를 사용하여 안전하게 할 수 있지만 메소르르 호출할 때마다 동기화처리를 해야하므로 성능부하가 발생한다.
    public static synchronized Settings2 getInstance() {
        if(settings_instance == null){
            settings_instance = new Settings2();
        }
        return settings_instance;
    }
}
