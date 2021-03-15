package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class NextCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.next();
    }
}
