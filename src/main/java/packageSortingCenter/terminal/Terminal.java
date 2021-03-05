package packageSortingCenter.terminal;

import employee.EmployeeRole;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.*;
import control.ControlUnitProxy;

public class Terminal {

    private PackageSortingCenter packageSortingCenter;
    private IDCardReader cardReader;


    private EmployeeRole authenticatedRole;

    public Terminal() {
        this.cardReader = new IDCardReader(this);
        this.authenticatedRole = null;
    }

    public void authenticateRole(EmployeeRole role) {
        this.authenticatedRole = role;
    }

    public void init() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new InitCommand(packageSortingCenter));
    }

    public void next() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new NextCommand(packageSortingCenter));
    }

    public void shutdown() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ShutdownCommand(packageSortingCenter));
    }

    public void lock() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new LockCommand(packageSortingCenter));
    }

    public void unlock() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new UnlockCommand(packageSortingCenter));
    }

    public void showStatistics() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ShutdownCommand(packageSortingCenter));
    }

    public void changeSearchAlgorithm() {
        new ControlUnitProxy(authenticatedRole, packageSortingCenter.getControlUnit())
                .executeCommand(new ChangeAlgorithmCommand(packageSortingCenter));
    }

}
