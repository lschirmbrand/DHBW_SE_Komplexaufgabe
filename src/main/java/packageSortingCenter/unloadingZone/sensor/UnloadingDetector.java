package packageSortingCenter.unloadingZone.sensor;

import java.util.ArrayList;
import java.util.List;

public class UnloadingDetector {

    private final List<IUnloadingListener> listenerList;
    private boolean activated = true;
    private final int zoneID;

    public UnloadingDetector(int zoneID) {
        this.zoneID = zoneID;
        listenerList = new ArrayList<>();
    }

    public void triggerSensor() {
        if (activated) {
            for (IUnloadingListener listener : listenerList) {
                listener.sensorTriggered(zoneID);
            }
        }
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void addListener(IUnloadingListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(IUnloadingListener listener) {
        listenerList.remove(listener);
    }
}
