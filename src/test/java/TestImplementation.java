import configuration.SearchAlgorithm;
import employee.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.terminal.IDCardReader;
import packageSortingCenter.terminal.Terminal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestImplementation {
    private PackageSortingCenter packageSortingCenter;
    private Terminal terminal;
    private IDCardReader cardReader;

    private Supervisor supervisor;
    private Administrator admin;
    private Operator operator;
    private DataAnalyst dataAnalyst;

    @BeforeEach()
    public void init() {
        packageSortingCenter = new PackageSortingCenter();
        terminal = packageSortingCenter.getTerminal();
        cardReader = terminal.getCardReader();

        supervisor = EmployeeFactory.createSupervisor("Saruman", "1234", true);
        admin = EmployeeFactory.createAdministrator("Gandalf", "2345", Administrator.Profile.A);
        operator = EmployeeFactory.createOperator("Aragorn", "3456");
        dataAnalyst = EmployeeFactory.createDataAnalyst("Eldrond", "4567");
    }

    @Test
    public void testImplementation() {
        testChangeSearchAlgorithm();
        testNext();
        testShowStatistics();
        testShutdown();
    }


    @DisplayName("Test ChangeSearchAlgorithm with role Supervisor")
    public void testChangeSearchAlgorithm() {
        cardReader.readCard(supervisor.getIdCard());
        cardReader.enterPin("1234");
        assertEquals(EmployeeRole.SUPERVISOR, terminal.getAuthenticatedRole());
        terminal.init();
        terminal.changeSearchAlgorithm(SearchAlgorithm.RABIN_KARP);
    }

    @DisplayName("Test Next with role Operator")
    public void testNext() {
        cardReader.readCard(operator.getIdCard());
        cardReader.enterPin("3456");
        assertEquals(EmployeeRole.OPERATOR, terminal.getAuthenticatedRole());

        terminal.next();
        terminal.next();
        terminal.next();
        terminal.next();
        terminal.next();

        assertTrue(packageSortingCenter.getWaitingZone().isEmpty());
        assertEquals(5, packageSortingCenter.getNumberDispatchedLKW());
        assertEquals(4, packageSortingCenter.getNumberDangerousPackages());
        assertEquals(24000, packageSortingCenter.getScannedPackages());
    }


    @DisplayName("Test ShowStatistics with role DataAnalyst")
    public void testShowStatistics() {
        cardReader.readCard(dataAnalyst.getIdCard());
        cardReader.enterPin("4567");
        assertEquals(EmployeeRole.DATA_ANALYST, terminal.getAuthenticatedRole());
        terminal.showStatistics();
    }

    @DisplayName("Test Shutdown with role Administrator")
    public void testShutdown() {
        cardReader.readCard(admin.getIdCard());
        cardReader.enterPin("2345");
        assertEquals(EmployeeRole.ADMINISTRATOR, terminal.getAuthenticatedRole());
        terminal.shutdown();
    }
}
