package packageSortingCenter.unloadingZone;

import control.ControlUnit;
import vehicle.lkw.LKW;

public class UnloadingZone {

    private final UnloadingDetector unloadingDetector;
    private LKW parkedLKW;

    public UnloadingZone(ControlUnit controlUnit, int id) {
        unloadingDetector = new UnloadingDetector(id);
        unloadingDetector.addListener(controlUnit);
    }

    public void parkLKW(LKW lkw) {
        this.parkedLKW = lkw;
        unloadingDetector.triggerSensor();
    }

    public boolean hasLKW() {
        return this.parkedLKW != null;
    }

    public LKW getParkedLKW() {
        return parkedLKW;
    }

    public void deactivateSensor() {
        this.unloadingDetector.setActivated(false);
    }
}
