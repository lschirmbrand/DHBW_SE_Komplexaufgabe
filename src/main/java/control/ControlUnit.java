package control;

import com.google.common.eventbus.EventBus;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;


public class ControlUnit implements IControlUnit {

    private final EventBus eventBus;

    private final PackageSortingCenter packageSortingCenter;

    public ControlUnit(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;

        eventBus = new EventBus("SortingCenter");
    }

    public void executeCommand(ICommand command) {
        command.execute();
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

    public void changeAlgorithm() {
        packageSortingCenter.changeAlgorithm();
    }

    public void sensorTriggered() {

    }
}
