package control;

import com.google.common.eventbus.EventBus;
import configuration.SearchAlgorithm;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;
import packageSortingCenter.unloadingZone.sensor.IUnloadingListener;


public class ControlUnit implements IControlUnit, IUnloadingListener {

    private final EventBus eventBus;

    private final PackageSortingCenter packageSortingCenter;

    public ControlUnit(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;

        eventBus = new EventBus("SortingCenter");
    }

    public void executeCommand(ICommand command) {
        command.execute(this);
    }

    public void init() {
    }

    public void next() {

    }

    public void shutdown() {
        packageSortingCenter.shutdown();
    }

    public void lock() {
        packageSortingCenter.lock();
    }

    public void unlock() {
        packageSortingCenter.unlock();
    }

    public void showStatistics() {
        packageSortingCenter.showStatistics();
    }

    public void changeAlgorithm(SearchAlgorithm searchAlgorithm) {
        packageSortingCenter.changeAlgorithm();
    }

    public void sensorTriggered() {

    }
}
