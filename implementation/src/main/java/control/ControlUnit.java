package control;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import configuration.Configuration;
import events.Subscriber;
import events.autonomous_vehicle.UnloadEvent;
import events.autonomous_vehicle.UnloadingFinishedEvent;
import events.robot.StartEmptyingEvent;
import events.sorting_system.SortEvent;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.ICommand;
import packageSortingCenter.sortingSystem.storage.ITrackLevelListener;
import packageSortingCenter.unloadingZone.IUnloadingListener;

import java.util.concurrent.ThreadLocalRandom;


public class ControlUnit extends Subscriber implements IControlUnit, IUnloadingListener, ITrackLevelListener {

    private final EventBus eventBus;
    private final PackageSortingCenter packageSortingCenter;

    private int filledStorageTracks = 0;

    public ControlUnit(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;

        eventBus = new EventBus("SortingCenter");
        addEventSubscriber(this);
    }

    public void addEventSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void executeCommand(ICommand command) {
        command.execute(packageSortingCenter);
    }

    public void sensorTriggered(int zoneID) {
        int vehicleID = ThreadLocalRandom.current().nextInt(Configuration.instance.numberOfAutonomousVehicles);
        eventBus.post(new UnloadEvent(vehicleID, zoneID));
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    @Subscribe
    public void receive(UnloadingFinishedEvent event) {
        eventBus.post(new StartEmptyingEvent());
    }

    @Override
    public void trackFull() {
        filledStorageTracks++;
        if (filledStorageTracks == 8) {
            eventBus.post(new SortEvent());
            filledStorageTracks = 0;
        }
    }
}
