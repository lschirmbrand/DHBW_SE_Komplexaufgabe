package packageSortingCenter.sortingSystem.storage.sensor;

import java.util.ArrayList;
import java.util.List;

public class LevelSensor {
    private List<ITrackLevelListener> listeners;

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
