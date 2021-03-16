package packageSortingCenter;

import configuration.Configuration;
import configuration.SearchAlgorithm;
import control.ControlUnit;
import packageSortingCenter.parkingZoneAutonom.ParkingZone;
import packageSortingCenter.sortingSystem.SortingSystem;
import packageSortingCenter.unloadingZone.UnloadingZone;
import packageSortingCenter.waitingZone.WaitingZone;
import utillity.csvTools.CSVReader;
import vehicle.autonomous_vehicle.AutonomousVehicle;
import vehicle.lkw.LKW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PackageSortingCenter implements IPackageSortingCenter {
    private final CSVReader csvReader;

    private final ControlUnit controlUnit;
    private final SortingSystem sortingSystem;
    private final List<UnloadingZone> unloadingZones;
    private final ParkingZone parkingZone;
    private final WaitingZone waitingZone;
    private final StorageArea storageArea;

    public PackageSortingCenter() {
        csvReader = new CSVReader();
        controlUnit = new ControlUnit(this);
        unloadingZones = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfUnloadingZones; i++) {
            unloadingZones.add(new UnloadingZone(controlUnit, i));
        }
        parkingZone = new ParkingZone();
        for (int i = 0; i < Configuration.instance.numberOfAutonomousVehicles; i++) {
            AutonomousVehicle vehicle = new AutonomousVehicle(i, this, controlUnit.getEventBus());
            parkingZone.addVehicle(vehicle);
            controlUnit.addEventSubscriber(vehicle);
        }

        waitingZone = new WaitingZone();
        storageArea = new StorageArea();
        sortingSystem = new SortingSystem(storageArea, controlUnit);
        controlUnit.addEventSubscriber(sortingSystem.getRobot());
        controlUnit.addEventSubscriber(sortingSystem);
    }

    public ControlUnit getControlUnit() {
        return controlUnit;
    }

    @Override
    public void init() {
        csvReader.readLKW().forEach(waitingZone::add);
    }

    @Override
    public void next() {
        LKW lkw = waitingZone.getNext();
        int unloadingIndex = ThreadLocalRandom.current().nextInt(unloadingZones.size());
        unloadingZones.get(unloadingIndex).parkLKW(lkw);
    }

    @Override
    public void shutdown() {
        for (UnloadingZone zone : unloadingZones) {
            zone.deactivateSensor();
        }
    }

    @Override
    public void lock() {
        sortingSystem.setLocked(true);
    }

    @Override
    public void unlock() {
        sortingSystem.setLocked(false);
    }

    @Override
    public void showStatistics() {
//        Report report = new Report.Builder()
//                .date()
//                .dispatchedLKWs(dispatchedLKW.size())
//                .setNumberDangerousPackages(numberDangerousPackages)
//                .setNumberPackagesGrouped(packageTypeCount)
//                .build();
//        try {
//            report.writeToLog();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void changeAlgorithm(SearchAlgorithm algorithm) {

    }

    public List<UnloadingZone> getUnloadingZones() {
        return unloadingZones;
    }

    public ParkingZone getParkingZone() {
        return parkingZone;
    }

    public StorageArea getStorageArea() {
        return storageArea;
    }
}
