package com.gofdesignpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Product {
    private Long id;
    private String name;
    private String category;
    private Long price;
    private String description;
    private Long reviewCount;
    private LocalDate createAt;

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private Long id;
        private String name;
        private String category;
        private Long price;
        private String description;
        private Long reviewCount;
        private LocalDate createAt;

        public Builder(){
            this.reviewCount = 0L;
            this.createAt = LocalDate.now();
        }
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder category(String category){
            this.category = category;
            return this;
        }
        public Builder price(Long price){
            this.price = price;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder reviewCount(Long reviewCount){
            this.reviewCount = reviewCount;
            return this;
        }
        public Builder createAt(LocalDate createAt){
            this.createAt = createAt;
            return this;
        }
        public Product build(){
            return new Product(this);
        }
    }

    private Product(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.description = builder.description;
        this.reviewCount = builder.reviewCount;
        this.createAt = builder.createAt;
    }
}

class Client{
    public static void main(String[] args) {
        Product product = Product.builder()
                .id(1L)
                .name("제품명")
                .category("카테고리")
                .price(10_000L)
                .build();
    }
}