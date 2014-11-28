/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.PlayerInterface;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class CustomsEvent extends Event{

    public CustomsEvent() {
        super("Customs", "You where caught by customs. You lose 10% of your health and 50% of your inventory", 5, 2, 0);
    }
    
    @Override
    public void eventAction(PlayerInterface player) {
        player.loseLife(player.getLife()/10);
        Map<String, Integer> drugs = player.getDrugs();        
        Map<String, Integer> newDrugs = new HashMap<>();

        for (Map.Entry<String, Integer> drug : drugs.entrySet()) {
            player.setDrugs(drug.getKey(), Math.round(drug.getValue()/2));
        }
    }
}
