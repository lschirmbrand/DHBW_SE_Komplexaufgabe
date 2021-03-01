package packageSortingCenter.sortingSystem;

import packageSortingCenter.sortingSystem.roboter.Roboter;
import packageSortingCenter.sortingSystem.sortingTracks.*;
import packageSortingCenter.sortingSystem.storage.*;


public class SortingSystem implements ISortingSystem {
    Roboter roboter;
    StorageEmptyBox storageEmptyBox;
    StorageEmptyPallet storageEmptyPallet;
    WarehouseTrack[] warehouseTrack;
    SortingTrackNormal sortingTrackNormal;
    SortingTrackExpress sortingTrackExpress;
    SortingTrackValue sortingTrackValue;

    public SortingSystem(){
        roboter = new Roboter();
        storageEmptyBox = new StorageEmptyBox();
        storageEmptyPallet = new StorageEmptyPallet();
        warehouseTrack = new WarehouseTrack[8];
        sortingTrackNormal = new SortingTrackNormal();
        sortingTrackExpress = new SortingTrackExpress();
        sortingTrackValue = new SortingTrackValue();
    }

}
