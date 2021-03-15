package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class ShutdownCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.shutdown();
    }
}
