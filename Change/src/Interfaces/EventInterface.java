/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public interface EventInterface {
    String getName();
    String getDecr();
    int getFriends();
    int getGun();
    boolean doesEventHappen(Map<String, Boolean> services);
    void eventAction(PlayerInterface player);
}
