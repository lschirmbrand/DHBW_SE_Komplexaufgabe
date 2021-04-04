package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class ShutdownCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.shutdown();
    }
}
