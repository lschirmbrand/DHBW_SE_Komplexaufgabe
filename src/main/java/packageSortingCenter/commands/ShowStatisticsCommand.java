package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class ShowStatisticsCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.showStatistics();
    }
}
