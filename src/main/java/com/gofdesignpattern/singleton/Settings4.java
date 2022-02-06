package com.gofdesignpattern.singleton;

/**
 * 멀티쓰레드 환경에서 안전한 방법3
 */
public class Settings4 {

    private static volatile Settings4 settings_instance;

    private Settings4() {}

    //if문에서 synchronized 블럭을 생성하여 double checked locking으로 효율적으로 사용
    //volatile 키워드를 사용 ( CPU Cache에 저장하지 않고 Main 메모리에 저장 시키는 키워드 )
    public static Settings4 getInstance() {
        if(settings_instance == null){
            synchronized (Settings.class) {
                if(settings_instance == null) {
                    settings_instance = new Settings4();
                }
            }
        }
        return settings_instance;
    }
}
