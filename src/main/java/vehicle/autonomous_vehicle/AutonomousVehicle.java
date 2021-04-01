package vehicle.autonomous_vehicle;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import events.Subscriber;
import events.autonomous_vehicle.UnloadingFinishedEvent;
import events.autonomous_vehicle.UnloadEvent;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.StorageArea;
import packageSortingCenter.parkingZoneAutonom.ParkingZone;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKWTrailer;

public class AutonomousVehicle extends Subscriber {
    private final int id;
    private final PackageSortingCenter sortingCenter;
    private final EventBus eventBus;

    public AutonomousVehicle(int id, PackageSortingCenter sortingCenter, EventBus eventBus) {
        this.id = id;
        this.sortingCenter = sortingCenter;
        this.eventBus = eventBus;
    }

    @Subscribe
    public void receive(UnloadEvent event) {
        if (event.getVehicleID() != id) {
            return;
        }

        ParkingZone parkingZone = sortingCenter.getParkingZone();
        LKWTrailer trailer = sortingCenter.getUnloadingZones().get(event.getZoneID()).getParkedLKW().getTrailer();
        StorageArea storageArea = sortingCenter.getStorageArea();

        parkingZone.leave(this);

        Pallet next;
        while ((next = trailer.unloadNext()) != null) {
            storageArea.store(next);
        }

        parkingZone.addVehicle(this);
        eventBus.post(new UnloadingFinishedEvent());
    }
}
