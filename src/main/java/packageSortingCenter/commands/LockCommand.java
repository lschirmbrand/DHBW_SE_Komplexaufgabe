package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class LockCommand implements ICommand {
    private final PackageSortingCenter packageSortingCenter;

    public LockCommand(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.lock();
    }
}
