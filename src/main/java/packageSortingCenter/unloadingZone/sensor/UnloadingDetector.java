package packageSortingCenter.unloadingZone.sensor;

import java.util.ArrayList;

public class UnloadingDetector {

    private ArrayList<IUnloadingListener> listenerList;

    public UnloadingDetector(){
        listenerList = new ArrayList<>();
    }

    public void triggerSensor(){
        for(IUnloadingListener listener : listenerList){
            listener.sensorTriggered();
        }
    }

    public void addListener(IUnloadingListener listener){
        listenerList.add(listener);
    }

    public void removeListener(IUnloadingListener listener){
        listenerList.remove(listener);
    }
}
