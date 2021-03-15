package packageSortingCenter.sortingSystem.roboter;

import com.google.common.eventbus.Subscribe;
import events.Subscriber;
import events.robot.StartEmptyingEvent;
import packageSortingCenter.StorageArea;
import packageSortingCenter.sortingSystem.SortingSystem;
import packageSortingCenter.sortingSystem.storage.StorageEmptyBox;
import packageSortingCenter.sortingSystem.storage.StorageEmptyPallet;
import packageSortingCenter.sortingSystem.storage.StorageTrack;
import packagingElements.boxes.Box;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;

import java.util.List;

public class Robot extends Subscriber {
    SortingSystem sortingSystem;
    StorageArea storageArea;

    public Robot(SortingSystem sortingSystem, StorageArea storageArea) {
        this.sortingSystem = sortingSystem;
        this.storageArea = storageArea;
    }

    @Subscribe
    public void receive(StartEmptyingEvent event) {
        List<StorageTrack> tracks = sortingSystem.getStorageTracks();
        StorageEmptyBox storageEmptyBox = sortingSystem.getStorageEmptyBox();
        StorageEmptyPallet storageEmptyPallet = sortingSystem.getStorageEmptyPallet();
        int trackIndex = 0;

        Pallet pallet;

        while ((pallet = storageArea.removeNext()) != null) {

            Box[][][] boxes = pallet.getBoxes();

            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[0].length; j++) {
                    for (int k = 0; k < boxes[0][0].length; k++) {
                        Package[][][] packages = boxes[i][j][k].getPackages();
                        for (int l = 0; l < packages.length; l++) {
                            for (int m = 0; m < packages[0].length; m++) {
                                for (int n = 0; n < packages[0][0].length; n++) {
                                    tracks.get(trackIndex).putPackageOnTrack(packages[l][m][n]);
                                    trackIndex = (trackIndex + 1) % tracks.size();
                                }
                            }
                        }
                        storageEmptyBox.store(boxes[i][j][k]);
                    }
                }
            }
            storageEmptyPallet.store(pallet);
        }

        return;
    }
}
