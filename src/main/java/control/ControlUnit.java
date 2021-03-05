package control;

import com.google.common.eventbus.EventBus;
import events.Subscriber;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;


public class ControlUnit implements IControlUnit {

    private final EventBus eventBus;

    private final PackageSortingCenter packageSortingCenter;
    private final ChangeAlgorithmCommand changeAlgorithmCommand;
    private final InitCommand initCommand;
    private final LockCommand lockCommand;
    private final UnlockCommand unlockCommand;
    private final NextCommand nextCommand;
    private final ShowStatisticsCommand showStatisticsCommand;
    private final ShutdownCommand shutdownCommand;

    public ControlUnit(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
        changeAlgorithmCommand = new ChangeAlgorithmCommand(packageSortingCenter);
        initCommand = new InitCommand(packageSortingCenter);
        lockCommand = new LockCommand(packageSortingCenter);
        unlockCommand = new UnlockCommand(packageSortingCenter);
        nextCommand = new NextCommand(packageSortingCenter);
        showStatisticsCommand = new ShowStatisticsCommand(packageSortingCenter);
        shutdownCommand = new ShutdownCommand(packageSortingCenter);

        eventBus = new EventBus("SortingCenter");
    }

    public void addSubscriber(Subscriber subscriber){
        eventBus.register(subscriber);
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
