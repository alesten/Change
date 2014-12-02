package Classes;

import Interfaces.AvailabilityStrategyInterface;

public class OldMemoryAvailabilityStrategy implements AvailabilityStrategyInterface {

    private static final int START_AVAILABILITY = 100;

    private int lastAvalability = START_AVAILABILITY;
    private int days = -1;

    @Override
    public int calculateAvailability() {
        days++;

        if (days == 0) {
            this.lastAvalability = START_AVAILABILITY;
        } else if (days == 1) {
            this.lastAvalability += 7;
        } else {
            this.lastAvalability += 13;
        }

        return this.lastAvalability;
    }

}
