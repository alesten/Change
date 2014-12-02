package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.Random;

public class OldMemoryPriceStrategy implements PriceStrategyInterface {

    private static final int START_PRICE = 1000;
    private final Random random = new Random();

    private int lastPrice = START_PRICE;
    private int days = -1;

    @Override
    public int calculatePrice(int goldenNumber) {
        days++;

        if (days == 0) {
            this.lastPrice = START_PRICE;
        } else if (days == 1) {
            boolean isPositive = this.random.nextBoolean();
            double factor = (this.random.nextInt(55) + 10) / 100;

            this.lastPrice = (this.lastPrice * ((isPositive)
                    ? (int) (1 + factor)
                    : (int) (1 - factor))) + 75;
        } else {
            boolean isPositive = this.random.nextBoolean();
            double factor = (this.random.nextInt(25) + 10) / 100;

            this.lastPrice = (this.lastPrice * ((isPositive)
                    ? (int) (1 + factor)
                    : (int) (1 - factor))) + 17;
        }

        return this.lastPrice;
    }

}
