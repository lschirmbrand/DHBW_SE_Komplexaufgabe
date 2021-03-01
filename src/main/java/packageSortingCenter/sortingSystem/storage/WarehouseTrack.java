package packageSortingCenter.sortingSystem.storage;

import java.util.ArrayList;

public class WarehouseTrack {
    ArrayList<Package> warehouseTrack;

    public WarehouseTrack(){
        warehouseTrack = new ArrayList<>();
    }

    public void putPackageOnTrack(Package packagee){
        warehouseTrack.add(packagee);
    }
}
