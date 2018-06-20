/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author nthao
 */
public final class Change {

    private BigDecimal change;
    private BigDecimal cost;
    private BigDecimal userMoney;
    private int quarter;
    private int dime;
    private int nickel;
    private int penny;

    public Change() {

    }

    public int getChangeCoin(BigDecimal userChange) {
        penny = userChange.multiply(new BigDecimal("100")).intValueExact();

        quarter = penny / 25;
        penny = penny % 25;

        dime = penny / 10;
        penny = penny % 10;

        nickel = penny / 5;
        penny = penny % 5;

        return penny;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getDime() {
        return dime;
    }

    public int getNickel() {
        return nickel;
    }

    public int getPenny() {
        return penny;
    }

}
