/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import java.util.Random;

/**
 *
 * @author alexandersteen
 */
public class AvailabilityStrategy implements AvailabilityStrategyInterface {

    private final int baseAvailability;

    public AvailabilityStrategy(int baseAvailability) {
        this.baseAvailability = baseAvailability;
    }

    @Override
    public int calculateAvailability(int baseAvailability) {
        Random r = new Random();
        int factor = 1;
        switch (r.nextInt(2)) {
            case 0:
                factor = 1;
                break;
            case 1:
                factor = -1;
                break;
        }

        int precent = r.nextInt(41) + 15;
        int change = (Math.round((this.baseAvailability * precent) / 100)) * factor;
        return this.baseAvailability + change;
    }

}
