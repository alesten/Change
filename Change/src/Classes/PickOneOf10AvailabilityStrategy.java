package Classes;

import Interfaces.AvailabilityStrategyInterface;
import java.util.Random;

public class PickOneOf10AvailabilityStrategy implements AvailabilityStrategyInterface {

    private final Random random;
    private final int[] possibleAvailbilities;

    public PickOneOf10AvailabilityStrategy(int[] availbilities) {
        this.random = new Random();
        this.possibleAvailbilities = availbilities;
    }

    @Override
    public int calculateAvailability() {
        int randomIndex = this.random.nextInt(this.possibleAvailbilities.length);

        return this.possibleAvailbilities[randomIndex];
    }

}
