/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nthao
 */
@Controller
public class VendingMachineController {

    @Inject
    VendingMachineService service;
    int candyId;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("candy", service.getAllCandy());

        if (candyId == 0) {
            model.addAttribute("itemSelected", "");
        } else {
            model.addAttribute("itemSelected", candyId);
        }
        model.addAttribute("moneyInserted", service.getUserMoney());
        model.addAttribute("message", service.getMessages());
        model.addAttribute("changeToDisplay", service.getChange());

        return "index";
    }

    @RequestMapping(value = "/selectItem", method = RequestMethod.POST)
    public String selectItem(HttpServletRequest request) {
        String candySelected = request.getParameter("candyButton");
        candyId = Integer.parseInt(candySelected);
        service.setSelectedCandyId(candyId);

        return "redirect:/";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public String addMoney(HttpServletRequest request) {
        String money = request.getParameter("addMoneyButton");
        service.setUserMoney(money);

        return "redirect:/";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.POST)
    public String makePurchase() {
        if (candyId != 0) {
        service.makePurchase();
        return "redirect:/";
}
        return "redirect:/";
    }

    @RequestMapping(value = "/getChange", method = RequestMethod.POST)
    public String getChange() {
        service.dispenseChange();
        candyId = 0;

        return "redirect:/";
    }
}
