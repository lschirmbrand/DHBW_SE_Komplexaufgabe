import org.junit.jupiter.api.Test;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.StorageArea;
import packageSortingCenter.WaitingZone;
import packageSortingCenter.commands.InitCommand;
import vehicle.autonomous_vehicle.AutonomousVehicle;
import vehicle.lkw.LKW;

import static org.junit.jupiter.api.Assertions.*;

public class TestPackageSortingCenter {
    @Test
    public void testSetup() {
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();

        assertNotNull(packageSortingCenter.getControlUnit());

        assertEquals(7, packageSortingCenter.getUnloadingZones().size());
        for (int i = 0; i < 7; i++) {
            assertNotNull(packageSortingCenter.getUnloadingZones().get(i));
        }

        assertNotNull(packageSortingCenter.getParkingZone());
        assertEquals(5, packageSortingCenter.getParkingZone().getCount());

        assertNotNull(packageSortingCenter.getSortingSystem());
    }

    @Test
    public void lkwUnloadingTest() {
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();

        packageSortingCenter.getControlUnit().executeCommand(new InitCommand());

        WaitingZone waitingZone = packageSortingCenter.getWaitingZone();
        LKW lkw = waitingZone.getNext();
        AutonomousVehicle autonomousVehicle = packageSortingCenter.getParkingZone().getAutonomousVehicles().get(0);
        StorageArea storageArea = packageSortingCenter.getStorageArea();

        autonomousVehicle.unload(lkw);
        assertNull(lkw.getTrailer().unloadNext());
        assertEquals(10, storageArea.getPalletCount());
    }
}
