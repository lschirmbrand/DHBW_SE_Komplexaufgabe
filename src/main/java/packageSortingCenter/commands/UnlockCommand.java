package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class UnlockCommand implements ICommand {

    private final PackageSortingCenter packageSortingCenter;

    public UnlockCommand(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.unlock();
    }
}
