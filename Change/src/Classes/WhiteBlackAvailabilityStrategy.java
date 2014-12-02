package Classes;

import Interfaces.AvailabilityStrategyInterface;

public class WhiteBlackAvailabilityStrategy implements AvailabilityStrategyInterface {

    private int[] possibleAvailabilities;
    private int days = 0;

    public WhiteBlackAvailabilityStrategy(int[] availabilities) {
        this.possibleAvailabilities = availabilities;
    }

    @Override
    public int calculateAvailability() {

        return possibleAvailabilities[(days++) % possibleAvailabilities.length];
    }

}
