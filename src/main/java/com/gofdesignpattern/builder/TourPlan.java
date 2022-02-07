package com.gofdesignpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
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
