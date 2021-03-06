package Classes;

import Interfaces.PriceStrategyInterface;

public class TenPercentPriceStrategy implements PriceStrategyInterface {

    private static final int START_PRICE = 180;

    private int days = 0;

    @Override
    public int calculatePrice(int goldenNumber) {
        return (int) (START_PRICE * (1 + (0.1 * days++)));
    }

}
