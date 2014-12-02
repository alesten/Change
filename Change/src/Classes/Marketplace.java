/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.DrugInterface;
import Interfaces.MarketplaceInterface;
import Interfaces.PlayerInterface;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class Marketplace implements MarketplaceInterface {

    private final Map<String, DrugInterface> drugs;

    public Marketplace(DrugInterface[] drugs) {
        this.drugs = new HashMap<>();

        for (DrugInterface drug : drugs) {
            this.drugs.put(drug.getName(), drug);
        }
    }

    @Override
    public boolean buy(String drug, int amt, PlayerInterface player) {
        DrugInterface currentDrug = drugs.get(drug);
        int totalPrice = currentDrug.getPrice() * amt;
        if (amt > currentDrug.getAvailability() || totalPrice > player.getBalance()) {
            return false;
        }

        player.withdraw(totalPrice);
        int currentDrugAmtOwned = player.getDrugs().get(currentDrug.getName());
        player.setDrugs(currentDrug.getName(), currentDrugAmtOwned + amt);
        currentDrug.setAvailability(currentDrug.getAvailability() - amt);

        return true;
    }

    @Override
    public boolean sell(String drug, int amt, PlayerInterface player) {
        DrugInterface currentDrug = drugs.get(drug);
        int totalPrice = currentDrug.getPrice() * amt;

        if (amt > player.getDrugs().get(currentDrug.getName())) {
            return false;
        }

        player.deposit(totalPrice);
        int currentDrugAmtOwned = player.getDrugs().get(currentDrug.getName());
        player.setDrugs(currentDrug.getName(), currentDrugAmtOwned - amt);
        currentDrug.setAvailability(currentDrug.getAvailability() + amt);

        return true;
    }

    @Override
    public Map<String, DrugInterface> getDrugs() {
        return drugs;
    }

    @Override
    public boolean shakeMarket() {
        for (Map.Entry<String, DrugInterface> drug : drugs.entrySet()) {
            drug.getValue().shakeDrug();
        }

        return true;
    }
}
