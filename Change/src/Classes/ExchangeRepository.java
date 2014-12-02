package Classes;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExchangeRepository {

    private static final List<ExchangeRateModel> exchangeRates = new LinkedList<>();

    private String[] currencies = null;

    public ExchangeRepository() {
        List<Thread> threads = new LinkedList<>();

        for (final String currency : getCurrencies()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    getExchangeRate("USD", currency);
                }
            });

            threads.add(thread);

            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ExchangeRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public double getExchangeRate(String currencyA, String currencyB) {

        for (ExchangeRateModel model : ExchangeRepository.exchangeRates) {
            if (model.getFromCurrency().equals(currencyA) && model.getToCurrency().equals(currencyB)) {
                return model.getExchangeRate();
            }
        }

        double exchangeRate = ExchangeFinder.getExchangeRate(currencyA, currencyB);
        exchangeRates.add(new ExchangeRateModel(currencyA, currencyB, exchangeRate));

        return exchangeRate;
    }

    public String[] getCurrencies() {
        if (currencies == null) {
            currencies = "DKK,JPY,GBP,AUD,EUR,ESP,GHS,ILS,KES,JOD,LKR,LVL,MAD,MWK,NOK,PHP,NOK,PKR,RUB,SGD".split(",");
        }

        return currencies;
    }
}
