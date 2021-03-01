package control;

import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;


public class ControlUnit implements IControlUnit {

    PackageSortingCenter packageSortingCenter;
    ChangeAlgorithmCommand changeAlgorithmCommand;
    InitCommand initCommand;
    LockCommand lockCommand;
    UnlockCommand unlockCommand;
    NextCommand nextCommand;
    ShowStatisticsCommand showStatisticsCommand;
    ShutdownCommand shutdownCommand;

    public ControlUnit(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
        changeAlgorithmCommand = new ChangeAlgorithmCommand(packageSortingCenter);
        initCommand = new InitCommand(packageSortingCenter);
        lockCommand = new LockCommand(packageSortingCenter);
        unlockCommand = new UnlockCommand(packageSortingCenter);
        nextCommand = new NextCommand(packageSortingCenter);
        showStatisticsCommand = new ShowStatisticsCommand(packageSortingCenter);
        shutdownCommand = new ShutdownCommand(packageSortingCenter);
    }

    @Override
    public void init() {
        packageSortingCenter.init();
    }

    @Override
    public void next() {
        packageSortingCenter.next();
    }

    @Override
    public void shutdown() {
        packageSortingCenter.shutdown();
    }

    @Override
    public void lock() {
        packageSortingCenter.lock();
    }

    @Override
    public void unlock() {
        packageSortingCenter.unlock();
    }

    @Override
    public void showStatistics() {
        packageSortingCenter.showStatistics();
    }

    @Override
    public void changeAlgorithm() {
        packageSortingCenter.changeAlgorithm();
    }

    @Override
    public void sensorTriggered() {

    }
}
