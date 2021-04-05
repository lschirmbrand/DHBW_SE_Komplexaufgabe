package packageSortingCenter;

import configuration.Configuration;
import configuration.SearchAlgorithm;
import control.ControlUnit;
import packageSortingCenter.parkingZoneAutonom.ParkingZone;
import packageSortingCenter.report.Report;
import packageSortingCenter.sortingSystem.SortingSystem;
import packageSortingCenter.terminal.Terminal;
import packageSortingCenter.unloadingZone.UnloadingZone;
import packageSortingCenter.waitingZone.WaitingZone;
import packagingElements.packages.Package;
import packagingElements.packages.PackageType;
import utillity.csvTools.CSVReader;
import utillity.csvTools.ICSVReader;
import vehicle.autonomous_vehicle.AutonomousVehicle;
import vehicle.lkw.LKW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class PackageSortingCenter {
    private final ICSVReader csvReader;

    private final ControlUnit controlUnit;
    private final Terminal terminal;
    private final SortingSystem sortingSystem;
    private final List<UnloadingZone> unloadingZones;
    private final ParkingZone parkingZone;
    private final WaitingZone waitingZone;
    private final StorageArea storageArea;
    private final EnumMap<PackageType, Integer> scannedPackages = new EnumMap<>(PackageType.class);
    private int numberDispatchedLKW = 0;
    private int numberDangerousPackages = 0;

    public PackageSortingCenter() {
        csvReader = new CSVReader();
        controlUnit = new ControlUnit(this);
        terminal = new Terminal(this);
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
        sortingSystem = new SortingSystem(this, storageArea, controlUnit);
        controlUnit.addEventSubscriber(sortingSystem.getRobot());
        controlUnit.addEventSubscriber(sortingSystem);

        scannedPackages.put(PackageType.NORMAL, 0);
        scannedPackages.put(PackageType.EXPRESS, 0);
        scannedPackages.put(PackageType.VALUE, 0);
    }

    public ControlUnit getControlUnit() {
        return controlUnit;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void init() {
        csvReader.readLKW().forEach(waitingZone::add);
    }

    public void next() {
        LKW lkw = waitingZone.getNext();
        int unloadingIndex = ThreadLocalRandom.current().nextInt(unloadingZones.size());
        unloadingZones.get(unloadingIndex).parkLKW(lkw);
        numberDispatchedLKW++;
    }

    public void shutdown() {
        for (UnloadingZone zone : unloadingZones) {
            zone.deactivateSensor();
        }
        sortingSystem.unloadComponents();
    }

    public void lock() {
        sortingSystem.setLocked(true);
    }

    public void unlock() {
        sortingSystem.setLocked(false);
    }

    public void showStatistics() {
        Report report = new Report.Builder()
                .date(new Date())
                .dispatchedLKWs(numberDispatchedLKW)
                .numberDangerousPackages(numberDangerousPackages)
                .numberPackagesGrouped(scannedPackages)
                .build();
        try {
            report.writeToLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeAlgorithm(SearchAlgorithm algorithm) {
        sortingSystem.changeSearchAlgorithm(algorithm);
    }

    public void packageScanned(Package pack, boolean dangerous) {
        PackageType packageType = pack.getPackageType();
        scannedPackages.put(packageType, scannedPackages.get(packageType) + 1);

        if (dangerous) {
            numberDangerousPackages++;
        }
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

    public SortingSystem getSortingSystem() {
        return sortingSystem;
    }

    public WaitingZone getWaitingZone() {
        return waitingZone;
    }
}
