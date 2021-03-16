package packageSortingCenter.sortingSystem;

import com.google.common.eventbus.Subscribe;
import configuration.SearchAlgorithm;
import events.Subscriber;
import events.sorting_system.SortEvent;
import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.roboter.Robot;
import packageSortingCenter.sortingSystem.sortingTracks.*;
import packageSortingCenter.sortingSystem.storage.StorageEmptyBox;
import packageSortingCenter.sortingSystem.storage.StorageEmptyPallet;
import packageSortingCenter.sortingSystem.storage.StorageTrack;
import packageSortingCenter.sortingSystem.storage.sensor.ITrackLevelListener;
import packagingElements.packages.Package;

import java.util.ArrayList;
import java.util.List;


public class SortingSystem extends Subscriber implements ISortingSystem {
    Robot robot;
    StorageEmptyBox storageEmptyBox;
    StorageEmptyPallet storageEmptyPallet;
    List<StorageTrack> storageTracks;
    List<SortingTrack> sortingTracks;

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
        SortingTrackNormal normalTrack = new SortingTrackNormal(expressTrack);

        sortingTracks = List.of(normalTrack, expressTrack, valueTrack);
    }

    @Subscribe
    public void receive(SortEvent event) {
        for (StorageTrack storageTrack : storageTracks) {
            while (!storageTrack.isEmpty()) {
                Package next = storageTrack.getNext();
                sortingTracks.get(0).sortPackage(next);
            }
        }
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

    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        for (SortingTrack sortingTrack : sortingTracks) {
            sortingTrack.changeSearchAlgorithm(algorithm);
        }
    }
}
