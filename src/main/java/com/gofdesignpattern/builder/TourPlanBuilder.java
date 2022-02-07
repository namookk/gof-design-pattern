package com.gofdesignpattern.builder;

import java.time.LocalDate;

public interface TourPlanBuilder {

    TourPlanBuilder title(String title);

    TourPlanBuilder nightsAndDays(int nights, int days);

    TourPlanBuilder whereToStay(String whereToStay);

    TourPlanBuilder startDate(LocalDate localDate);

    TourPlanBuilder addPlan(int day, String plan);

    TourPlan getPlan();
}
