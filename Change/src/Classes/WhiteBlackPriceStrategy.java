package Classes;

import Interfaces.PriceStrategyInterface;

public class WhiteBlackPriceStrategy implements PriceStrategyInterface {

    private int[] possiblePrices;
    private int days = 0;

    public WhiteBlackPriceStrategy(int[] prices) {
        this.possiblePrices = prices;
    }

    @Override
    public int calculatePrice(int goldenNumber) {
        return possiblePrices[(days++) % possiblePrices.length];
    }

}
