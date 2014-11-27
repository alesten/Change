package Presentation;

import Classes.Controller;
import Interfaces.ControllerInterface;
import java.util.Observable;

public class GameController extends Observable {

    private static GameController instance;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController(new Controller(""));
        }
        
        return instance;
    }

    private final ControllerInterface service;

    public GameController(ControllerInterface service) {
        this.service = service;
    }

    public ControllerInterface getService() {
        return service;
    }

    public void requestUpdate() {
        setChanged();
        notifyObservers();
    }

}
