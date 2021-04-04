package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class ShowStatisticsCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.showStatistics();
    }
}
