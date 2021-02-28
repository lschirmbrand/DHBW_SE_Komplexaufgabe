package packageSortingCenter.unloadingZone;

import vehicle.lkw.LKW;

public interface IUnloadingZone {
    public void setID(int id);
    public void parkLKW(LKW lkw);
    public boolean hasLKW();
}
