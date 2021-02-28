package packageSortingCenter.waitingZone;

import vehicle.lkw.LKW;

public class WaitingZone {
    private LKW lkwWaitingSpace;

    public WaitingZone(LKW lkw) {
        this.lkwWaitingSpace = lkw;
    }

    private void setLKW(LKW lkw) {
        this.lkwWaitingSpace = lkw;
    }
}
