package packageSortingCenter.unloadingZone;

import vehicle.lkw.LKW;

public class UnloadingZone implements IUnloadingZone {

    private int id;
    private LKW parkedLKW;

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void parkLKW(LKW lkw) {
        this.parkedLKW = lkw;
    }

    @Override
    public boolean hasLKW() {
        return this.parkedLKW != null;
    }
}
