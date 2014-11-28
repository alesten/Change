package Classes;

import Interfaces.HighscoreItemInterface;

public class HighscoreItem implements HighscoreItemInterface {

    private String name;
    private int score;

    public HighscoreItem(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

}
