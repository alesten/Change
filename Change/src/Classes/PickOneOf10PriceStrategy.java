package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.Random;

public class PickOneOf10PriceStrategy implements PriceStrategyInterface {

    private final Random random;
    private final int[] possiblePrices;

    public PickOneOf10PriceStrategy(int[] prices) {
        this.random = new Random();
        this.possiblePrices = prices;
    }

    @Override
    public int calculatePrice(int goldenNumber) {
        
        int randomIndex = this.random.nextInt(this.possiblePrices.length);
        
        return this.possiblePrices[randomIndex];
    }

}