package Classes;

import Interfaces.AvailabilityStrategyInterface;

public class TenPercentAvailabilityStrategy implements AvailabilityStrategyInterface {

    private static final int START_AMOUNT = 40;

    private int days = 0;

    @Override
    public int calculateAvailability() {
        return (int)(START_AMOUNT * (1 + (0.1 * days++)));
    }

}
