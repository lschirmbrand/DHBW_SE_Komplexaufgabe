package events.autonomous_vehicle;

public class UnloadEvent {
    private final int vehicleID;
    private final int zoneID;

    public UnloadEvent(int vehicleID, int zoneID) {
        this.vehicleID = vehicleID;
        this.zoneID = zoneID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public int getZoneID() {
        return zoneID;
    }
}
