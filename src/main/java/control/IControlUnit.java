package control;

import packageSortingCenter.unloadingZone.IUnloadingZone;
import packageSortingCenter.unloadingZone.sensor.IUnloadingListener;

public interface IControlUnit extends IUnloadingListener {
    void init();
    void next();
    void shutdown();
    void lock();
    void unlock();
    void showStatistics();
    void changeAlgorithm();
}
