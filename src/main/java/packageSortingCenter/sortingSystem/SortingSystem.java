package packageSortingCenter.sortingSystem;

import com.google.common.eventbus.Subscribe;
import events.Subscriber;
import events.sorting_system.SortEvent;
import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.roboter.Robot;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrack;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackExpress;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackNormal;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackValue;
import packageSortingCenter.sortingSystem.storage.StorageEmptyBox;
import packageSortingCenter.sortingSystem.storage.StorageEmptyPallet;
import packageSortingCenter.sortingSystem.storage.StorageTrack;
import packageSortingCenter.sortingSystem.storage.sensor.ITrackLevelListener;

import java.util.ArrayList;
import java.util.List;


public class SortingSystem extends Subscriber implements ISortingSystem {
    Robot robot;
    StorageEmptyBox storageEmptyBox;
    StorageEmptyPallet storageEmptyPallet;
    List<StorageTrack> storageTracks;
    SortingTrack sortingTrack;

    boolean locked;

    public SortingSystem(StorageArea storageArea, ITrackLevelListener listener) {
        robot = new Robot(this, storageArea);
        storageEmptyBox = new StorageEmptyBox();
        storageEmptyPallet = new StorageEmptyPallet();
        storageTracks = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            storageTracks.add(new StorageTrack(listener));
        }
        SortingTrackValue valueTrack = new SortingTrackValue(null);
        SortingTrackExpress expressTrack = new SortingTrackExpress(valueTrack);
        sortingTrack = new SortingTrackNormal(expressTrack);
    }

    @Subscribe
    public void receive(SortEvent event) {
        storageTracks.forEach(storageTrack -> {
            while (!storageTrack.isEmpty()) {
                sortingTrack.sortPackage(storageTrack.getNext());
            }
        });
    }

    public Robot getRobot() {
        return robot;
    }

    public StorageEmptyBox getStorageEmptyBox() {
        return storageEmptyBox;
    }

    public StorageEmptyPallet getStorageEmptyPallet() {
        return storageEmptyPallet;
    }

    public List<StorageTrack> getStorageTracks() {
        return storageTracks;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
