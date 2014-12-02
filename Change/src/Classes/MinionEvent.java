/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.PlayerInterface;
import java.util.Random;

/**
 *
 * @author alexandersteen
 */
public class MinionEvent extends Event {

    Random r;
    int money;
    
    public MinionEvent() {
        
        super("Minion pusher (Who works for you)",
                "Your pusher minion have sold some drugs on your behalf and you get money. You 0$", 5, 4, 0, 0, 2, 2);
        this.r = new Random();
        money = r.nextInt(9000)+1000;
        super.decr = "Your pusher minion have sold some drugs on your behalf and you get money. You " + money + "$";
        
    }
    
    @Override
    public void eventAction(PlayerInterface player) {
        player.deposit(money);
    }

}
