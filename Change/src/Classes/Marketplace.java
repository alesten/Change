/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import Interfaces.DrugInterface;
import Interfaces.MarketplaceInterface;
import Interfaces.PlayerInterface;
import Interfaces.PriceStrategyInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author alexandersteen
 */
public class Marketplace implements MarketplaceInterface {

    private Map<String, DrugInterface> drugs;

    public Marketplace(PriceStrategyInterface priceStrategy, AvailabilityStrategyInterface availabilityStrategy) {
        this.drugs = new HashMap<>();

        DrugInterface cocaine = new Drug("Cocaine", 30, 1200, priceStrategy, availabilityStrategy);
        DrugInterface heroin = new Drug("Heroin", 15, 1600, priceStrategy, availabilityStrategy);
        DrugInterface amphetamine = new Drug("Amphetamine", 50, 200, priceStrategy, availabilityStrategy);
        DrugInterface acid = new Drug("Acid", 33, 550, priceStrategy, availabilityStrategy);
        DrugInterface angelDust = new Drug("Angel Dust", 60, 400, priceStrategy, availabilityStrategy);
        DrugInterface crystalMeth = new Drug("Crystal Meth", 38, 800, priceStrategy, availabilityStrategy);
        DrugInterface hash = new Drug("Hash", 100, 180, priceStrategy, availabilityStrategy);
        DrugInterface weed = new Drug("Weed", 115, 150, priceStrategy, availabilityStrategy);
        DrugInterface mushrooms = new Drug("Mushrooms", 95, 120, priceStrategy, availabilityStrategy);

        drugs.put(cocaine.getName(), cocaine);
        drugs.put(heroin.getName(), heroin);
        drugs.put(amphetamine.getName(), amphetamine);
        drugs.put(acid.getName(), acid);
        drugs.put(angelDust.getName(), angelDust);
        drugs.put(crystalMeth.getName(), crystalMeth);
        drugs.put(hash.getName(), hash);
        drugs.put(weed.getName(), weed);
        drugs.put(mushrooms.getName(), mushrooms);
    }

    @Override
    public boolean buy(String drug, int amt, PlayerInterface player) {
        DrugInterface currentDrug = drugs.get(drug);
        int totalPrice = currentDrug.getPrice() * amt;
        if(amt > currentDrug.getAvailability()|| totalPrice > player.getBalance()) {
            System.out.println("Kan ikke købe");
            return false;
        }
        
        player.withdraw(totalPrice);
        int currentDrugAmtOwned = player.getDrugs().get(currentDrug.getName());
        player.setDrugs(currentDrug.getName(), currentDrugAmtOwned + amt);
        
        return true;
    }

    @Override
    public boolean sell(String drug, int amt, PlayerInterface player) {
        DrugInterface currentDrug = drugs.get(drug);
        int totalPrice = currentDrug.getPrice() * amt;
        
        if(amt > player.getDrugs().get(currentDrug.getName()))
            return false;
        
        player.deposit(totalPrice);
        int currentDrugAmtOwned = player.getDrugs().get(currentDrug.getName());
        player.setDrugs(currentDrug.getName(), currentDrugAmtOwned - amt);
        
        return true;
    }

    @Override
    public Map<String, DrugInterface> getDrugs() {
        return drugs;
    }

    @Override
    public boolean shakeMarket() {
        for(Map.Entry<String, DrugInterface> drug : drugs.entrySet()){
            drug.getValue().shakeDrug();
        }
        
        return true;
    }
}
