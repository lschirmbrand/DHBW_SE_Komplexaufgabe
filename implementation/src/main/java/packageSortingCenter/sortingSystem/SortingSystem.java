package packageSortingCenter.sortingSystem;

import com.google.common.eventbus.Subscribe;
import configuration.SearchAlgorithm;
import events.Subscriber;
import events.sorting_system.SortEvent;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrack;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackExpress;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackNormal;
import packageSortingCenter.sortingSystem.sortingTracks.SortingTrackValue;
import packageSortingCenter.sortingSystem.storage.ITrackLevelListener;
import packageSortingCenter.sortingSystem.storage.StorageTrack;
import packagingElements.packages.Package;

import java.util.ArrayList;
import java.util.List;


public class SortingSystem extends Subscriber {
    private final Robot robot;
    private final EmptyBoxStorage emptyBoxStorage;
    private final EmptyPalletStorage emptyPalletStorage;
    private final List<StorageTrack> storageTracks;
    private final List<SortingTrack> sortingTracks;
    private final PackageSortingCenter packageSortingCenter;
    private boolean locked;

    public SortingSystem(PackageSortingCenter packageSortingCenter, StorageArea storageArea, ITrackLevelListener listener) {
        this.packageSortingCenter = packageSortingCenter;

        robot = new Robot(this, storageArea);
        emptyBoxStorage = new EmptyBoxStorage();
        emptyPalletStorage = new EmptyPalletStorage();
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
        if (locked) throw new SortingSystemLockedException();
        for (StorageTrack storageTrack : storageTracks) {
            while (!storageTrack.isEmpty()) {
                Package next = storageTrack.getNext();
                boolean dangerous = sortingTracks.get(0).sortPackage(next);
                packageSortingCenter.packageScanned(next, dangerous);
            }
        }
    }

    public Robot getRobot() {
        return robot;
    }

    public EmptyBoxStorage getStorageEmptyBox() {
        return emptyBoxStorage;
    }

    public EmptyPalletStorage getStorageEmptyPallet() {
        return emptyPalletStorage;
    }

    public List<StorageTrack> getStorageTracks() {
        return storageTracks;
    }

    public boolean getLocked() {
        return this.locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        for (SortingTrack sortingTrack : sortingTracks) {
            sortingTrack.changeSearchAlgorithm(algorithm);
        }
    }

    public void unloadComponents() {
        for (SortingTrack sortingTrack : sortingTracks) {
            sortingTrack.unloadComponent();
        }
    }
}
