/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.EventInterface;
import Interfaces.PlayerInterface;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author alexandersteen
 */
public class Event implements EventInterface{

    String name;
    String decr;
    
    int chance;
    
    int friends;
    int gun;

    public Event(String name, String decr, int chance, int friends, int gun) {
        this.name = name;
        this.decr = decr;
        
        this.chance = chance;
        
        this.friends = friends;
        this.gun = gun;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDecr() {
        return decr;
    }

    @Override
    public int getFriends() {
        return friends;
    }

    @Override
    public int getGun() {
        return gun;
    }

    @Override
    public boolean doesEventHappen(Map<String, Boolean> services) {
        int currentChance = chance;
        for (Map.Entry<String, Boolean> service : services.entrySet()) {
            if(service.getKey().equals("Friends") && service.getValue())
                currentChance -= friends;
            if(service.getKey().equals("Gun") && service.getValue())
                currentChance -= gun;
        }
        
        if(currentChance < 0)
            currentChance = 0;
        
        Random r = new Random();
        int random = r.nextInt(99)+1;
        return currentChance >= random;
    }

    @Override
    public void eventAction(PlayerInterface player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
