package packageSortingCenter.sortingSystem;

import packageSortingCenter.sortingSystem.roboter.Robot;
import packageSortingCenter.sortingSystem.sortingTracks.*;
import packageSortingCenter.sortingSystem.storage.*;


public class SortingSystem implements ISortingSystem {
    Robot robot;
    StorageEmptyBox storageEmptyBox;
    StorageEmptyPallet storageEmptyPallet;
    WarehouseTrack[] warehouseTrack;
    SortingTrackNormal sortingTrackNormal;
    SortingTrackExpress sortingTrackExpress;
    SortingTrackValue sortingTrackValue;

    public SortingSystem(){
        robot = new Robot();
        storageEmptyBox = new StorageEmptyBox();
        storageEmptyPallet = new StorageEmptyPallet();
        warehouseTrack = new WarehouseTrack[8];
        sortingTrackNormal = new SortingTrackNormal();
        sortingTrackExpress = new SortingTrackExpress();
        sortingTrackValue = new SortingTrackValue();
    }

}
