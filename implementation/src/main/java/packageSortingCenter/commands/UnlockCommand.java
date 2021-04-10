package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class UnlockCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.unlock();
    }
}
