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
public class MafiaEvent extends Event{

    public MafiaEvent() {
        super("Mafia trespassing", "You have trespassed on the mafias territory. You lose 50 health, 50% money and drugs", 5, -2, -1, 0, 0, 0);
    }
    
    @Override
    public void eventAction(PlayerInterface player) {
        player.loseLife(50);
        
        for (Map.Entry<String, Integer> drug : player.getDrugs().entrySet()) {
            player.setDrugs(drug.getKey(), Math.round(drug.getValue()/2));
        }
        
        player.withdraw(player.getBalance()/2);
    }
    
}
