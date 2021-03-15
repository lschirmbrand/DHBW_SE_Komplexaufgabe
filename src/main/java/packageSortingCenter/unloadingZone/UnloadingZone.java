package packageSortingCenter.unloadingZone;

import control.ControlUnit;
import packageSortingCenter.unloadingZone.sensor.UnloadingDetector;
import vehicle.lkw.LKW;

public class UnloadingZone {

    private final int id;
    private LKW parkedLKW;
    UnloadingDetector unloadingDetector;
    ControlUnit controlUnit;

    public UnloadingZone(ControlUnit controlUnit, int id){
        this.controlUnit = controlUnit;
        this.id = id;
        unloadingDetector = new UnloadingDetector(id);
        unloadingDetector.addListener(controlUnit);
    }

    public int getId;

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
