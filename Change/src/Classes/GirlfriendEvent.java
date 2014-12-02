/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.PlayerInterface;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class GirlfriendEvent extends Event{

    public GirlfriendEvent() {
        super("New girl/boyfriend (Who helps you)", "You got a new girl/boyfriend. You get 10% more drugs", 5, 3, 0, 2, 4, 3);
    }
    
    @Override
    public void eventAction(PlayerInterface player) {
        for (Map.Entry<String, Integer> drug : player.getDrugs().entrySet()) {
            player.setDrugs(drug.getKey(), Math.round((drug.getValue()/10)+drug.getValue()));
        }
    }
}
