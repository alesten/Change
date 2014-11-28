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
public class PriceStrategy implements PriceStrategyInterface{

    @Override
    public int calculatePrice(int basePrice, int goldenNumber) {
        Random r = new Random();
        int factor = 1;
        switch(r.nextInt(2)){
            case 0:
                factor = 1;
                break;
            case 1:
                factor = -1;
                break;
        }

        if(goldenNumber >= r.nextInt(99)+1){
            int finalPrice = basePrice * 10 * factor;
            if(finalPrice < 1)
                finalPrice = 1;
            return finalPrice;
        }else{
            int precent = r.nextInt(85)+1;
            int change = (Math.round((basePrice * precent) / 100)) * factor;
            return basePrice + change;
        }
    }
    
}
