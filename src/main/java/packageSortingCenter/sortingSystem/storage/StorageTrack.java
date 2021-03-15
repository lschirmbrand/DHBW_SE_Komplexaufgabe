package packageSortingCenter.sortingSystem.storage;

import packageSortingCenter.sortingSystem.storage.sensor.LevelSensor;
import packageSortingCenter.sortingSystem.storage.sensor.ITrackLevelListener;
import packagingElements.packages.Package;

import java.util.ArrayDeque;
import java.util.Queue;

public class StorageTrack {
    Queue<Package> packages;
    LevelSensor sensor;

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
}
