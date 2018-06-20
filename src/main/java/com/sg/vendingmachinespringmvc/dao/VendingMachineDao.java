/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Candy;
import java.util.List;

/**
 *
 * @author nthao
 */
public interface VendingMachineDao {

    public List<Candy> getAllCandy();

    public Candy getCandy(int id);

    public Candy removeCandyQuantity(int id);

}
