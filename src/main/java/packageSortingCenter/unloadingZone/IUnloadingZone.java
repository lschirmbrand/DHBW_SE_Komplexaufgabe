package packageSortingCenter.unloadingZone;

import vehicle.lkw.LKW;

public interface IUnloadingZone {
    void setID(int id);

    void parkLKW(LKW lkw);

    boolean hasLKW();
}
