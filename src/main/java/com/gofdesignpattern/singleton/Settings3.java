package com.gofdesignpattern.singleton;

/**
 * 멀티쓰레드 환경에서 안전한 방법2
 */
public class Settings3 {

    //이른 초기화 사용하기(eager initialization)
    //객체 생성 비용이 크지않는 경우 미리 만들어서 사용가능하다.
    private static final Settings3 SETTINGS_INSTANCE = new Settings3();

    private Settings3() {}

    public static Settings3 getInstance() {
        return SETTINGS_INSTANCE;
    }
}
