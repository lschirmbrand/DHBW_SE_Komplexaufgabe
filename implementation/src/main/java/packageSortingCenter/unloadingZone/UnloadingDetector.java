package packageSortingCenter.unloadingZone;

import java.util.ArrayList;
import java.util.List;

public class UnloadingDetector {

    private final List<IUnloadingListener> listenerList;
    private final int zoneID;
    private boolean activated = true;

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
