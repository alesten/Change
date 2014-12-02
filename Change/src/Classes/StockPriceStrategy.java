package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.List;
import java.util.Random;

public class StockPriceStrategy implements PriceStrategyInterface {

    private final int DEFAULT_PRICE = 100;

    private final Random random;
    private final List<Double> possiblePrices;

    public StockPriceStrategy(List<Double> prices) {
        this.random = new Random();
        this.possiblePrices = prices;
    }

    @Override
    public int calculatePrice(int goldenNumber) {
        if (this.possiblePrices.isEmpty()) {
            return DEFAULT_PRICE;
        }

        int randomIndex = this.random.nextInt(this.possiblePrices.size());
        double stockPrice = this.possiblePrices.get(randomIndex);

        return (int) stockPrice;
    }

}
