package packageSortingCenter;

import configuration.Configuration;
import control.ControlUnit;
import utillity.csvTools.CSVReader;
import vehicle.lkw.LKW;
import packageSortingCenter.parkingZoneAutonom.ParkingZoneAutonom;
import packageSortingCenter.report.Report;
import packageSortingCenter.sortingSystem.SortingSystem;
import packageSortingCenter.unloadingZone.UnloadingZone;
import packageSortingCenter.waitingZone.WaitingZone;
import packagingElements.packages.Package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class PackageSortingCenter implements IPackageSortingCenter {
    private final ControlUnit controlUnit;
    private final SortingSystem sortingSystem;
    private final UnloadingZone[] unloadingZone;
    private final ParkingZoneAutonom parkingZoneAutonom;
    private final WaitingZone[] waitingZone = new WaitingZone[5];

    private final ArrayList<LKW> lkwList = new ArrayList<>();
    private ArrayList<LKW> dispatchedLKW = new ArrayList<>();
    private EnumMap<Package.PackageTypeE, Integer> packageTypeCount = new EnumMap<>(Package.PackageTypeE.class);
    private int numberDangerousPackages = 0;

    private String usedAlgorithm = Configuration.instance.algorithmBM;

    public PackageSortingCenter() {
        controlUnit = new ControlUnit(this);
        unloadingZone = new UnloadingZone[Configuration.instance.numberOfUnloadingZones];
        parkingZoneAutonom = new ParkingZoneAutonom();
        sortingSystem = new SortingSystem();
    }

    public ControlUnit getControlUnit() {
        return controlUnit;
    }

    @Override
    public void init() {
        for (int i = 0; i < Configuration.instance.numberOfLKWS; i++) {
            lkwList.add(new LKW());
        }

        CSVReader csvReader = new CSVReader();
        List<String[]> lkwContent = csvReader.readLKW();

        for (LKW s : lkwList) {
            s.fillTrailerFromList(lkwContent);
        }

        for (int i = 0; i < lkwList.size(); i++) {
            waitingZone[i] = new WaitingZone(lkwList.get(i));
        }
    }

    @Override
    public void next() {
        for(int i = 0; i< unloadingZone.length; i++){
            unloadingZone[i] = new UnloadingZone(controlUnit);
            unloadingZone[i].setID(i);
            if(!unloadingZone[i].hasLKW()){
                unloadingZone[i].parkLKW(lkwList.get(i));
                break;
            }
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void lock() {

    }

    @Override
    public void unlock() {

    }

    @Override
    public void showStatistics() {
        Report report = new Report.Builder()
                .date()
                .dispatchedLKWs(dispatchedLKW.size())
                .setNumberDangerousPackages(numberDangerousPackages)
                .setNumberPackagesGrouped(packageTypeCount)
                .build();
        try {
            report.writeToLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeAlgorithm() {
        if(this.usedAlgorithm.equals(Configuration.instance.algorithmBM)){
            this.usedAlgorithm = Configuration.instance.algorithmRK;
        }else{
            this.usedAlgorithm = Configuration.instance.algorithmBM;
        }
    }
}
