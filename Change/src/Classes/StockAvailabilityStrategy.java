package Classes;

import Interfaces.AvailabilityStrategyInterface;
import java.util.List;
import java.util.Random;

public class StockAvailabilityStrategy implements AvailabilityStrategyInterface {

    private final int DEFAULT_AVAILABILITY = 10;

    private final Random random;
    private final List<Double> possibleAvailabilities;

    public StockAvailabilityStrategy(List<Double> availabilities) {
        this.random = new Random();
        this.possibleAvailabilities = availabilities;
    }

    @Override
    public int calculateAvailability() {
        if (this.possibleAvailabilities.isEmpty()) {
            return DEFAULT_AVAILABILITY;
        }

        int randomIndex = this.random.nextInt(this.possibleAvailabilities.size());
        double stockAvailability = this.possibleAvailabilities.get(randomIndex);

        return (int) stockAvailability;
    }

}
