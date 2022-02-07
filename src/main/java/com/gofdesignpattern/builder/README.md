### 빌더(Builder) 패턴
#### 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법

+ (복잡한) 객체를 만드는 프로세스를 독립적으로 분리할 수 있다.

#### 장점

복잡한 객체도 만드는 순서를 정의할 수 있고  
동일한 프로세스로 각기 다른 인스턴스를 생성 가능하다.

#### 단점
빌더객체를 만들어야 하는 단점이 있다.
구조가 조금 복잡해진다.

빌더 패턴 적용전 코드

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourPlan {
    private String title;

    private int nights;

    private int days;

    private LocalDate startDate;

    private String whereToStay;

    private List<DetailPlan> plans;

    public void addPlan(int day, String plan) {
        if (plans == null) plans = new ArrayList<>();
        plans.add(new DetailPlan(day, plan));
    }
}
```
TourPlan객체에 데이터를 넣기위해선 setter를 이용해야한다.
```java
public class App {
    public static void main(String[] args) {
        TourPlan tourPlan = new TourPlan();
        tourPlan.setTitle("칸쿤 여행");
        tourPlan.setNights(2);
        tourPlan.setDays(3);
        tourPlan.setStartDate(LocalDate.of(2020, 12, 9));
        tourPlan.setWhereToStay("리조트");
        tourPlan.addPlan(0, "체크인 이후 짐풀기");
        tourPlan.addPlan(0, "저녁 식사");
        tourPlan.addPlan(1, "조식");
        tourPlan.addPlan(1, "해변가 산책");
        tourPlan.addPlan(1, "점심");
        tourPlan.addPlan(1, "수영장");
        tourPlan.addPlan(2, "조식");
        tourPlan.addPlan(2, "체크아웃");
    }
}
```

보기만해도 너무 복잡하고 설령 짧은 여행일 경우 nights, days, plan등은 생략 가능한 구조로도 생성될 수 있다.

빌더패턴 적용 후 코드를 보자

1. 해당 클래스에 멤버클래스로 Builder생성하기 (lombok의 @Builder 사용하면 생성되는 로직)
```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourPlan {
    private String title;

    private int nights;

    private int days;

    private LocalDate startDate;

    private String whereToStay;

    private List<DetailPlan> plans;

    public void addPlan(int day, String plan) {
        if(plans == null) plans = new ArrayList<>();
        plans.add(new DetailPlan(day, plan));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private String title;

        private int nights;

        private int days;

        private LocalDate startDate;

        private String whereToStay;

        private List<DetailPlan> plans;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder nightsAndDays(int nights, int days){
            this.days = days;
            this.nights = nights;
            return this;
        }
        public Builder startDate(LocalDate startDate){
            this.startDate = startDate;
            return this;
        }
        public Builder whereToStay(String whereToStay) {
            this.whereToStay = whereToStay;
            return this;
        }
        public Builder addPlan(int day, String plan) {
            if(this.plans == null) plans = new ArrayList<>();
            plans.add(new DetailPlan(day, plan));
            return this;
        }
        public TourPlan build() {
            return new TourPlan(this);
        }
    }

    private TourPlan(Builder builder) {
        this.title = builder.title;
        this.nights = builder.nights;
        this.days = builder.days;
        this.startDate = builder.startDate;
        this.whereToStay = builder.whereToStay;
        this.plans = builder.plans;
    }
}
```
```java
public class App {
    public static void main(String[] args) {
        TourPlan tourPlan3 = TourPlan.builder()
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .build();
    }
}
```

2. Builder인터페이스를 이용하여 만들기
```java
public interface TourPlanBuilder {

    TourPlanBuilder title(String title);

    TourPlanBuilder nightsAndDays(int nights, int days);

    TourPlanBuilder whereToStay(String whereToStay);

    TourPlanBuilder startDate(LocalDate localDate);

    TourPlanBuilder addPlan(int day, String plan);

    TourPlan getPlan();
}
```
```java

public class DefaultTourBuilder implements TourPlanBuilder{

    private String title;
    private int nights;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans;

    @Override
    public TourPlanBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.nights = nights;
        this.days = days;
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate localDate) {
        this.startDate = localDate;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
        if(this.plans == null) this.plans = new ArrayList<>();
        this.plans.add(new DetailPlan(day, plan));
        return this;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title, nights, days, startDate, whereToStay, plans);
    }
}
```
```java
public class App {
    public static void main(String[] args) {

        TourPlanBuilder builder = new DefaultTourBuilder();

        TourPlan tourPlan1 = builder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .getPlan();
    }
}
```

위 방법에서 자주 사용하는 객체를 Director로 빼서 사용하는 방법도 있다.
```java
public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip() {
        return tourPlanBuilder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .getPlan();
    }
}
```
```java
public class App {
    public static void main(String[] args) {
        TourPlan tourPlan2 = new TourDirector(new DefaultTourBuilder()).cancunTrip();
    }
}
```