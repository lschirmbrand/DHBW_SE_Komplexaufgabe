package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class NextCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.next();
    }
}
