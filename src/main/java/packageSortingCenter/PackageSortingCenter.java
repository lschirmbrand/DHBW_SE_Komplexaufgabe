package packageSortingCenter;

import configuration.Configuration;
import control.ControlUnit;
import csvTools.CSVReader;
import lkw.LKW;
import packageSortingCenter.sortingSystem.SortingSystem;
import packageSortingCenter.parkingZoneAutonom.ParkingZoneAutonom;
import packageSortingCenter.unloadingZone.UnloadingZone;
import packageSortingCenter.waitingZone.WaitingZone;

import java.util.ArrayList;
import java.util.List;

public class PackageSortingCenter implements IPackageSortingCenter{
    private final ControlUnit controlUnit;
    private UnloadingZone[] unloadingZone;
    private ParkingZoneAutonom[] parkingZoneAutonom;
    private final SortingSystem sortingSystem;
    private WaitingZone[] waitingZone = new WaitingZone[5];

    private ArrayList<LKW> lkwList = new ArrayList<>();

    public PackageSortingCenter(){
        controlUnit = new ControlUnit(this);
        unloadingZone = new UnloadingZone[Configuration.instance.numberOfUnloadingZones];
        parkingZoneAutonom = new ParkingZoneAutonom[Configuration.instance.numberOfParkingZoneAutonom];
        sortingSystem = new SortingSystem();
    }

    @Override
    public void init() {
        for(int i = 0; i<Configuration.instance.numberOfLKWS; i++){
            lkwList.add(new LKW());
        }

        CSVReader csvReader = new CSVReader();
        List<String[]> lkwContent = csvReader.readLKW();

        for(LKW s : lkwList){
            s.fillTrailerFromList(lkwContent);
        }

        for(int i = 0; i< lkwList.size(); i++){
            waitingZone[i] = new WaitingZone(lkwList.get(i));
;        }
        int i = 0;
    }

    @Override
    public void next() {

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

    }

    @Override
    public void changeAlgorithm() {

    }
}
