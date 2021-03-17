package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class UnlockCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.unlock();
    }
}
