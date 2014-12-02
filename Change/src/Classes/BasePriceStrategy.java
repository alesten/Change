/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.Random;

/**
 *
 * @author alexandersteen
 */
public class BasePriceStrategy implements PriceStrategyInterface {

    private final int basePrice;
    private int lastPrice;

    public BasePriceStrategy(int basePrice) {
        this.basePrice = this.lastPrice = basePrice;
    }

    @Override
    public int calculatePrice(int goldenNumber) {
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

        if (goldenNumber >= r.nextInt(99) + 1) {
            int finalPrice = this.lastPrice * 10 * factor;
            if (finalPrice < 1) {
                finalPrice = 1;
            }
            this.lastPrice = finalPrice;
        } else {
            int precent = r.nextInt(85) + 1;
            int change = (Math.round((this.lastPrice * precent) / 100)) * factor;
            this.lastPrice = this.lastPrice + change;
        }

        return this.lastPrice;
    }

}
