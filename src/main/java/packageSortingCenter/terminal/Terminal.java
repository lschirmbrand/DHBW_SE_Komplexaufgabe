package packageSortingCenter.terminal;

import configuration.SearchAlgorithm;
import control.ControlUnitProxy;
import employee.EmployeeRole;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;

public class Terminal {

    private final PackageSortingCenter packageSortingCenter;
    private final IDCardReader cardReader;

    private EmployeeRole authenticatedRole;

    public Terminal(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
        this.cardReader = new IDCardReader(this);
        this.authenticatedRole = null;
    }

    public void authenticateRole(EmployeeRole role) {
        this.authenticatedRole = role;
    }

    public IDCardReader getCardReader() {
        return cardReader;
    }

    public void init() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new InitCommand());
    }

    public void next() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new NextCommand());
    }

    public void shutdown() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ShutdownCommand());
    }

    public void lock() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new LockCommand());
    }

    public void unlock() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new UnlockCommand());
    }

    public void showStatistics() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ShowStatisticsCommand());
    }

    public void changeSearchAlgorithm(SearchAlgorithm searchAlgorithm) {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ChangeAlgorithmCommand(searchAlgorithm));
    }

    public EmployeeRole getAuthenticatedRole() {
        return authenticatedRole;
    }
}
