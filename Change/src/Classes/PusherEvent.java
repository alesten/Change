/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.PlayerInterface;

/**
 *
 * @author alexandersteen
 */
public class PusherEvent extends Event{

    public PusherEvent() {
        super("Pusher", "You where assaulted by an angry pusher. You lose 20% of your health", 5, 1, 2);
    }

    @Override
    public void eventAction(PlayerInterface player) {
        player.loseLife(player.getLife()/5);
    }
}
