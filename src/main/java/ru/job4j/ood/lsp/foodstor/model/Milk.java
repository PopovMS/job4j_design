package ru.job4j.ood.lsp.foodstor.model;

import java.time.LocalDateTime;

public class Milk implements Food {
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime expiryDate;
    private int price;
    private int discount;
    private int freshLevel;

    public Milk(String name, LocalDateTime createDate, LocalDateTime expiryDate) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public int getFreshLevel() {
        return freshLevel;
    }

    @Override
    public void setFreshLevel(int freshLevel) {
        this.freshLevel = freshLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
