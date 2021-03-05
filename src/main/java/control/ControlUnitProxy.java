package control;

import employee.EmployeeRole;
import packageSortingCenter.commands.*;

import java.util.List;

public class ControlUnitProxy implements IControlUnit {

    private final EmployeeRole role;
    private final ControlUnit controlUnit;

    public ControlUnitProxy(EmployeeRole role, ControlUnit controlUnit) {
        this.role = role;
        this.controlUnit = controlUnit;
    }

    private List<EmployeeRole> allowedForInit = List.of(
            EmployeeRole.SUPERVISOR
    );
    private List<EmployeeRole> allowedForNext = List.of(
            EmployeeRole.SUPERVISOR,
            EmployeeRole.OPERATOR
    );
    private List<EmployeeRole> allowedForShutdown = List.of(
            EmployeeRole.SUPERVISOR,
            EmployeeRole.ADMINISTRATOR
    );
    private List<EmployeeRole> allowedForLock = List.of(
            EmployeeRole.SUPERVISOR
    );
    private List<EmployeeRole> allowedForUnlock = List.of(
            EmployeeRole.SUPERVISOR
    );
    private List<EmployeeRole> allowedForShowStatistics = List.of(
            EmployeeRole.SUPERVISOR,
            EmployeeRole.ADMINISTRATOR,
            EmployeeRole.OPERATOR,
            EmployeeRole.DATA_ANALYST
    );
    private List<EmployeeRole> allowedForChangeAlgorithm = List.of(
            EmployeeRole.SUPERVISOR
    );

    @Override
    public void executeCommand(ICommand command) {
        if (command instanceof InitCommand) {
            if (allowedForInit.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof NextCommand) {
            if (allowedForNext.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof ShutdownCommand) {
            if (allowedForShutdown.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof LockCommand) {
            if (allowedForLock.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof UnlockCommand) {
            if (allowedForUnlock.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof ShowStatisticsCommand) {
            if (allowedForShutdown.contains(role)) {
                controlUnit.executeCommand(command);
            }
        } else if (command instanceof ChangeAlgorithmCommand) {
            if (allowedForChangeAlgorithm.contains(role)) {
                controlUnit.executeCommand(command);
            }
        }
    }
}
