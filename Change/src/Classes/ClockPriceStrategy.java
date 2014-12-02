package Classes;

import Interfaces.PriceStrategyInterface;
import java.util.Calendar;
import java.util.TimeZone;

public class ClockPriceStrategy implements PriceStrategyInterface {

    private final Calendar calendar;

    public ClockPriceStrategy() {
        calendar = Calendar.getInstance(TimeZone.getDefault());
    }

    @Override
    public int calculatePrice(int goldenNumber) {
        return calendar.get(Calendar.SECOND) * 2;
    }

}
