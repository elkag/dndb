package dndm.app.setup.wizard.settlements.dragexample;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<V> {
    private V value;
    private final List<Observer<V>> observers = new ArrayList<>();

    public void setValue(V value) {
        this.value = value;
        for (Observer<V> observer : this.observers) {
            observer.update(value);
        }
    }

    public void addObserver(Observer<V> observer) {
        observers.add(observer);
    }
}
