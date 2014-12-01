package Classes;

import Interfaces.HighscoreItemInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HighscoreRepository {

    private final String filename;

    public HighscoreRepository(String filename) {
        this.filename = filename;
    }

    public boolean insert(HighscoreItemInterface highscore) {
        try {
            StringBuilder strBuilder = new StringBuilder();

            try (Scanner scanner = new Scanner(new File(this.filename))) {
                while (scanner.hasNextLine()) {
                    strBuilder.append(scanner.nextLine()).append("\n");
                }
            }

            strBuilder.append(serialize(highscore));

            try (PrintWriter writer = new PrintWriter(new File(this.filename))) {
                writer.write(strBuilder.toString());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighscoreRepository.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

        return true;
    }

    public List<HighscoreItemInterface> fetch() {
        List<HighscoreItemInterface> highscores = new LinkedList<>();

        try (Scanner scanner = new Scanner(new File(this.filename))) {
            while (scanner.hasNextLine()) {
                highscores.add(deserialize(scanner.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighscoreRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Sort the array
        highscores.sort(new HighscoreComparator());

        return highscores;
    }

    private String serialize(HighscoreItemInterface highscore) {
        return highscore.getName() + "," + highscore.getScore();
    }

    private HighscoreItemInterface deserialize(String str) {
        String[] strArr = str.split(",");

        return new HighscoreItem(strArr[0], Integer.parseInt(strArr[1]));
    }
}
