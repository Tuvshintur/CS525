package counter;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private final Collection<Observer> observerCollection = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        observerCollection.add(observer);
    }

    public void onNotify() {
        for (Observer observer : observerCollection) {
            observer.update();
        }
    }
}
