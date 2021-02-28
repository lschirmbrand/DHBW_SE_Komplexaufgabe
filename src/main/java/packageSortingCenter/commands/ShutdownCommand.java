package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class ShutdownCommand implements ICommand {
    private final PackageSortingCenter packageSortingCenter;

    public ShutdownCommand(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.shutdown();
    }
}
