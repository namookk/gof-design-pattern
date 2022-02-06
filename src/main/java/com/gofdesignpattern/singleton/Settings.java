package com.gofdesignpattern.singleton;

/**
 * 해당 방법은 멀티쓰레드 환경에서 안전하지 않다.
 */
public class Settings {

    private static Settings settings_instance = null;

    private Settings() {}

    public static Settings getInstance() {
        if(settings_instance == null){
            settings_instance = new Settings();
        }
        return settings_instance;
    }
}
