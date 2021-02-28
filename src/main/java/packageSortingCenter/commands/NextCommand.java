package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class NextCommand implements ICommand {

    private final PackageSortingCenter packageSortingCenter;

    public NextCommand(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.next();
    }
}
