package com.gofdesignpattern.builder;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        //before
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

        //after
        TourPlan tourPlan3 = TourPlan.builder()
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .build();

        TourPlanBuilder builder = new DefaultTourBuilder();

        TourPlan tourPlan1 = builder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .getPlan();

        TourPlan tourPlan2 = new TourDirector(new DefaultTourBuilder()).cancunTrip();

    }
}
