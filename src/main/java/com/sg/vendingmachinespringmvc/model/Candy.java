/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author nthao
 */
public class Candy {

    private int id;
    private String name;
    private BigDecimal cost;
    private int quantity;

    public Candy() {

    }

    public Candy(int id, String name, BigDecimal cost, int quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
