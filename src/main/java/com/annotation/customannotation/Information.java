package com.annotation.customannotation;


import com.annotation.customannotation.annotation.CanBeNull;
import com.annotation.customannotation.annotation.RunNow;
import com.annotation.customannotation.annotation.VeryImportant;

@VeryImportant(time = 4)
public class Information {
    @CanBeNull
    private String name;
    private int quantity;

    public Information(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public Information() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RunNow
    public double getAmount(){
        return Math.sqrt(quantity);
    }
}
