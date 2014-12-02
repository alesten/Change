package Classes;

import Interfaces.AvailabilityStrategyInterface;
import java.util.Calendar;
import java.util.TimeZone;

public class ClockAvailabilityStrategy implements AvailabilityStrategyInterface {

    private final Calendar calendar;

    public ClockAvailabilityStrategy() {
        calendar = Calendar.getInstance(TimeZone.getDefault());
    }

    @Override
    public int calculateAvailability() {
        return calendar.get(Calendar.SECOND);
    }

}
