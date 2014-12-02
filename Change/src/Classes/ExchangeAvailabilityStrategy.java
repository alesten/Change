package Classes;

import Interfaces.AvailabilityStrategyInterface;
import java.util.Random;

public class ExchangeAvailabilityStrategy implements AvailabilityStrategyInterface {

    private final int DEFAULT_MULTIPLIER = 5;

    private final ExchangeRepository exchangeRepository = new ExchangeRepository();
    private final Random random;

    public ExchangeAvailabilityStrategy() {
        this.random = new Random();
    }

    @Override
    public int calculateAvailability() {
        String currencyA = "USD"; // We need to go from USD all the time!
        String currencyB = getRandomCurrency();

        return (int) (this.exchangeRepository.getExchangeRate(currencyA, currencyB) * DEFAULT_MULTIPLIER);
    }

    protected String getRandomCurrency() {
        int randomIndex = this.random.nextInt(this.exchangeRepository.getCurrencies().length);
        return this.exchangeRepository.getCurrencies()[randomIndex];
    }

}
