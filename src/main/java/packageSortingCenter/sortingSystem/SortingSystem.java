package packageSortingCenter.sortingSystem;

import com.google.common.eventbus.Subscribe;
import events.Subscriber;
import events.sorting_system.SortEvent;
import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.roboter.Robot;
import packageSortingCenter.sortingSystem.sortingTracks.*;
import packageSortingCenter.sortingSystem.storage.*;
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

    public SortingSystem(StorageArea storageArea, ITrackLevelListener listener){
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
            while(!storageTrack.isEmpty()) {
                sortingTrack.sortPackage(storageTrack.getNext());
            }
        });
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
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
}
