package packageSortingCenter.sortingSystem;

import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.roboter.Robot;
import packageSortingCenter.sortingSystem.sortingTracks.*;
import packageSortingCenter.sortingSystem.storage.*;
import packageSortingCenter.sortingSystem.storage.sensor.ITrackLevelListener;

import java.util.ArrayList;
import java.util.List;


public class SortingSystem implements ISortingSystem {
    Robot robot;
    StorageEmptyBox storageEmptyBox;
    StorageEmptyPallet storageEmptyPallet;
    List<StorageTrack> storageTracks;
    SortingTrackNormal sortingTrackNormal;
    SortingTrackExpress sortingTrackExpress;
    SortingTrackValue sortingTrackValue;

    boolean locked;

    public SortingSystem(StorageArea storageArea, ITrackLevelListener listener){
        robot = new Robot(this, storageArea);
        storageEmptyBox = new StorageEmptyBox();
        storageEmptyPallet = new StorageEmptyPallet();
        storageTracks = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            storageTracks.add(new StorageTrack(listener));
        }
        sortingTrackNormal = new SortingTrackNormal();
        sortingTrackExpress = new SortingTrackExpress();
        sortingTrackValue = new SortingTrackValue();
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

    public SortingTrackNormal getSortingTrackNormal() {
        return sortingTrackNormal;
    }

    public SortingTrackExpress getSortingTrackExpress() {
        return sortingTrackExpress;
    }

    public SortingTrackValue getSortingTrackValue() {
        return sortingTrackValue;
    }

    public boolean isLocked() {
        return locked;
    }
}
