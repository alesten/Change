package Classes;

public class ExchangeRateModel {

    private final String fromCurrency;
    private final String toCurrency;
    private final double exchangeRate;

    public ExchangeRateModel(String fromCurrency, String toCurrency, double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

    public String getFromCurrency() {
        return this.fromCurrency;
    }

    public String getToCurrency() {
        return this.toCurrency;
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }
}
