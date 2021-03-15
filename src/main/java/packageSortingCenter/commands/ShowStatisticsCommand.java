package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class ShowStatisticsCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.showStatistics();
    }
}
