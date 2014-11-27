package Presentation;

import java.util.Observable;

public class MainViewState extends Observable {

    private static MainViewState instance;

    public static MainViewState getInstance() {
        if (instance == null) {
            instance = new MainViewState();
        }

        return instance;
    }

    public void change(String name) {
        setChanged();
        notifyObservers(name);
    }

}
