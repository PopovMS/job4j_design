package ru.job4j.ood.lsp.foodstor.model;

import java.time.LocalDateTime;



public interface Food {

    public int getFreshLevel();

    public void setFreshLevel(int freshLevel);

    String getName();

    void setName(String name);

    LocalDateTime getCreateDate();

    void setCreateDate(LocalDateTime createDate);

    LocalDateTime getExpiryDate();

    void setExpiryDate(LocalDateTime expiryDate);

    int getPrice();

    void setPrice(int price);

    int getDiscount();

    void setDiscount(int discount);
}
