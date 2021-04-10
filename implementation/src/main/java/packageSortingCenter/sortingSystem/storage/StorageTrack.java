package packageSortingCenter.sortingSystem.storage;

import packagingElements.packages.Package;

import java.util.ArrayDeque;
import java.util.Queue;

public class StorageTrack {
    private final Queue<Package> packages;
    private final LevelSensor sensor;

    public StorageTrack(ITrackLevelListener listener) {
        packages = new ArrayDeque<>();
        sensor = new LevelSensor();
        sensor.addListener(listener);
    }

    public void putPackageOnTrack(Package pack) {
        if (packages.size() >= 600) {
            return;
        }
        packages.add(pack);

        if (packages.size() == 600) {
            sensor.trackIsFull();
        }
    }

    public Package getNext() {
        return packages.poll();
    }

    public boolean isEmpty() {
        return packages.isEmpty();
    }
}
