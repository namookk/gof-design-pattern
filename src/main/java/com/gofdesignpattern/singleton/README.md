### 싱글톤 (Singleton) 패턴
#### 인스턴스를 오직 한개만 제공하는 클래스

+ 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있다.
+ 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다



#### 구현하는 방법

```java
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
```
위 방법으로 간단하게 싱글톤 클래스를 구현할 수 있다.  

인스턴스를 가져와보고 비교해보자.

```java
public static void main(String[] args) {
    Settings settings = Settings.getInstance();
    System.out.println(settings == Settings.getInstance()); // true
}
```

하지만 위 방법으로는 멀티 쓰레드 환경에서 안전하지 않다.
왜냐하면 멀티 쓰레드에서 if문을 동일하게 동작할 수 있어 new Settings()가 여러번 호출 될 수 있습니다.


멀티 쓰레드 환경에서 안전하게 구현하는 방법은 아래와 같다.

1. synchronized키워드 사용

```java
public class Settings {

    private static Settings settings_instance = null;

    private Settings() {}
    
    public static synchronized Settings getInstance() {
        if(settings_instance == null){
            settings_instance = new Settings();
        }
        return settings_instance;
    }
}
```

synchronized키워드를 사용하여 멀티쓰레드 환경에서 안전하게 구현하는 방법이 있지만 메소르르 호출할 때마다 동기화처리를 해야하므로 성능부하가 발생한다.

2. 이른 초기화 사용하기(eager initialization)

```java
public class Settings {
    
    private static final Settings SETTINGS_INSTANCE = new Settings3();

    private Settings() {}

    public static Settings getInstance() {
        return SETTINGS_INSTANCE;
    }
}
```
처음부터 객체를 미리 생성해놓고 사용하면 멀티쓰레드 환경에서 안전하지만 객체 생성 비용이 크고 사용을 안하게되면 비효율적인 방법입니다.

3. synchronized코드 블럭 사용

```java
public class Settings {

    private static volatile Settings settings_instance;

    private Settings() {}
    
    public static Settings getInstance() {
        if(settings_instance == null){
            synchronized (Settings.class) {
                if(settings_instance == null) {
                    settings_instance = new Settings();
                }
            }
        }
        return settings_instance;
    }
}
```
if문에서 synchronized 블럭을 생성하여 double checked locking으로 효율적으로 사용할 수 있으며
instance변수에 volatile 키워드를 사용해야 함 ( CPU Cache에 저장하지 않고 Main 메모리에 저장 시키는 키워드 )
java1.5이상 사용 가능

4. inner static class 사용 (권장)

```java
public class Settings {
    private Settings() {}

    //static inner class사용
    private static class SettingsHolder{
        private static final Settings SETTINGS_INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.SETTINGS_INSTANCE;
    }
}
```
inner static class를 사용하여 lazy loading으로 인스턴스를 생성하여 사용 가능하며 멀티쓰레드 환경에서 안전한 방법중 권장하는 방법이다.
