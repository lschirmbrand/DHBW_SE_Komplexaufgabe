package packageSortingCenter;

import vehicle.autonomous_vehicle.AutonomousVehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingZone {
    private final List<AutonomousVehicle> autonomousVehicles;

    public ParkingZone() {
        autonomousVehicles = new ArrayList<>();
    }

    public void addVehicle(AutonomousVehicle vehicle) {
        autonomousVehicles.add(vehicle);
    }

    public void leave(AutonomousVehicle vehicle) {
        autonomousVehicles.remove(vehicle);
    }

    public List<AutonomousVehicle> getAutonomousVehicles() {
        return autonomousVehicles;
    }

    public int getCount() {
        return autonomousVehicles.size();
    }
}
