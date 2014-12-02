package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.Random;

public class ExchangePriceStrategy implements PriceStrategyInterface {

    private final int DEFAULT_MULTIPLIER = 10;

    private final ExchangeRepository exchangeRepository = new ExchangeRepository();
    private final Random random;

    public ExchangePriceStrategy() {
        this.random = new Random();
    }

    @Override
    public int calculatePrice(int goldenNumber) {
        String currencyA = "USD"; // We need to go from USD all the time!
        String currencyB = getRandomCurrency();

        return (int) (this.exchangeRepository.getExchangeRate(currencyA, currencyB) * DEFAULT_MULTIPLIER);
    }

    private String getRandomCurrency() {
        int randomIndex = this.random.nextInt(this.exchangeRepository.getCurrencies().length);
        return this.exchangeRepository.getCurrencies()[randomIndex];
    }

}
