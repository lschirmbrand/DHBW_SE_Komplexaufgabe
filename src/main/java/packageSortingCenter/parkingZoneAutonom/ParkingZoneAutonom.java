package packageSortingCenter.parkingZoneAutonom;

import configuration.Configuration;
import vehicle.autonomousVehicle.AutonomousVehicle;

public class ParkingZoneAutonom implements IParkingZoneAutonom {
    private AutonomousVehicle[] autonomVehicleList = new AutonomousVehicle[Configuration.instance.numberOfParkingZoneAutonom];
}
