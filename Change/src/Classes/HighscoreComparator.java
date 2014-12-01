package Classes;

import Interfaces.HighscoreItemInterface;
import java.util.Comparator;

public class HighscoreComparator implements Comparator<HighscoreItemInterface> {

    @Override
    public int compare(HighscoreItemInterface t, HighscoreItemInterface t1) {
        if (t.getScore() > t1.getScore()) {
            return -1;
        }

        if (t.getScore() < t1.getScore()) {
            return 1;
        }

        return 0;
    }
}
