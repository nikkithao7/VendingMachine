/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Candy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author nthao
 */
@Component
public class VendingMachineMemDao implements VendingMachineDao {

    private List<Candy> candyList = new ArrayList<>();

    public VendingMachineMemDao() {
        candyList.add(new Candy(1, "Snickers", new BigDecimal(1.85), 9));
        candyList.add(new Candy(2, "M & Ms", new BigDecimal(1.50), 2));
        candyList.add(new Candy(3, "Pringles", new BigDecimal(2.10), 5));
        candyList.add(new Candy(4, "Reese's", new BigDecimal(1.85), 4));
        candyList.add(new Candy(5, "Pretzels", new BigDecimal(1.25), 9));
        candyList.add(new Candy(6, "Twinkies", new BigDecimal(1.95), 3));
        candyList.add(new Candy(7, "Doritos", new BigDecimal(1.75), 11));
        candyList.add(new Candy(8, "Almond Joy", new BigDecimal(1.85), 0));
        candyList.add(new Candy(9, "Trident", new BigDecimal(1.95), 6));
    }

    @Override
    public List<Candy> getAllCandy() {
        return candyList;
    }

    @Override
    public Candy getCandy(int id) {
        for (Candy c : candyList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Candy removeCandyQuantity(int id) {
        for (Candy c : candyList) {
            if (c.getId() == id) {
                int quantity = c.getQuantity();
                quantity--;
                c.setQuantity(quantity);
                return c;
            }
        }
        return null;
    }

}
