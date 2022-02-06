package com.gofdesignpattern.singleton;

/**
 * 멀티쓰레드 환경에서 안전한 방법3
 */
public class Settings5 {
    private Settings5() {}

    //static inner class사용
    private static class SettingsHolder{
        private static final Settings5 SETTINGS_INSTANCE = new Settings5();
    }

    //호출될 때 lazyloading으로 객체를 생성함.
    public static Settings5 getInstance() {
        return SettingsHolder.SETTINGS_INSTANCE;
    }
}
