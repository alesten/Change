/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.DrugInterface;
import Interfaces.MarketplaceInterface;
import Interfaces.PlayerInterface;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class Marketplace implements MarketplaceInterface{

    @Override
    public boolean buy(DrugInterface drug, int amt, PlayerInterface player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sell(DrugInterface drug, int amt, PlayerInterface player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<DrugInterface, Integer> getDrugs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
