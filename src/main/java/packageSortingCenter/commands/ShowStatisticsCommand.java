package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class ShowStatisticsCommand implements ICommand {
    private final PackageSortingCenter packageSortingCenter;

    public ShowStatisticsCommand(PackageSortingCenter packageSortingCenter){
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.lock();
    }
}
