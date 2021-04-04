package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class LockCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.lock();
    }
}
