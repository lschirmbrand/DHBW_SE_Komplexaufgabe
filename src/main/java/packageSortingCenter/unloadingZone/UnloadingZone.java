package packageSortingCenter.unloadingZone;

import control.ControlUnit;
import packageSortingCenter.unloadingZone.sensor.UnloadingDetector;
import vehicle.lkw.LKW;

public class UnloadingZone implements IUnloadingZone {

    private int id;
    private LKW parkedLKW;
    UnloadingDetector unloadingDetector = new UnloadingDetector();
    ControlUnit controlUnit;

    public UnloadingZone(ControlUnit controlUnit){
        this.controlUnit = controlUnit;
        unloadingDetector.addListener(controlUnit);
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void parkLKW(LKW lkw) {
        this.parkedLKW = lkw;
        unloadingDetector.triggerSensor();
    }

    @Override
    public boolean hasLKW() {
        return this.parkedLKW != null;
    }
}
