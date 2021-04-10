package packageSortingCenter.sortingSystem.storage;

import packageSortingCenter.sortingSystem.storage.ITrackLevelListener;

import java.util.ArrayList;
import java.util.List;

public class LevelSensor {
    private final List<ITrackLevelListener> listeners;

    public LevelSensor() {
        listeners = new ArrayList<>();
    }

    public void addListener(ITrackLevelListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ITrackLevelListener listener) {
        listeners.remove(listener);
    }

    public void trackIsFull() {
        listeners.forEach(ITrackLevelListener::trackFull);
    }
}
