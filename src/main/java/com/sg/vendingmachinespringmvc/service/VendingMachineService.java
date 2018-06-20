/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Candy;
import com.sg.vendingmachinespringmvc.model.Change;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author nthao
 */
@Component
public class VendingMachineService {

    @Inject
    VendingMachineDao dao;
    private BigDecimal money = new BigDecimal("0");
    private int selectedId = 0;
    private String message = "";
    private String change = "";
    private Change ch = new Change();

    public List<Candy> getAllCandy() {
        return dao.getAllCandy();
    }

    public Candy getCandy(int id) {
        return dao.getCandy(id);
    }

    public void setSelectedCandyId(int id) {
        selectedId = id;
    }

    public void removeCandyQuantity(int id) {
        dao.removeCandyQuantity(id);
    }

    public BigDecimal getUserMoney() {
        return money;
    }

    public void setUserMoney(String userMoney) {
        BigDecimal a = new BigDecimal(userMoney);
        money = (money.add(a)).setScale(2, RoundingMode.HALF_UP);
    }

    public void makePurchase() {
        if (selectedId > 0 || selectedId < 10) {
            Candy candySelected = getCandy(selectedId);
            if (candySelected.getQuantity() < 1) {
                message = "SOLD OUT!!!";
            } else if (money.compareTo(candySelected.getCost()) < 0) {
                BigDecimal moneyNeeded = candySelected.getCost().subtract(money);
                message = "Please insert: " + moneyNeeded.toString();
            } else {
                setChangeAmount(selectedId);
                money = new BigDecimal("0");
                removeCandyQuantity(selectedId);
                selectedId = 0;
                message = "Thank you!!!";
            }
        }

    }

    public String getChange() {
        return change;
    }

    public void setChangeAmount(int id) {
        BigDecimal changeDue;
        Candy candy = getCandy(id);
        BigDecimal candyPrice = candy.getCost();
        changeDue = money.subtract(candyPrice).setScale(2, RoundingMode.HALF_UP);
        ch.getChangeCoin(changeDue);

        change = ch.getQuarter() + " Quarters, " + ch.getDime() + " Dimes, " + ch.getNickel() + " Nickels";
    }

    public void dispenseChange() {
        money = new BigDecimal("0");
        selectedId = 0;
        message = "";
        change = "";
    }

    public String getMessages() {
        return message;
    }

}
