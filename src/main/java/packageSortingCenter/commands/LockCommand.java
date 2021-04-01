package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class LockCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.lock();
    }
}
