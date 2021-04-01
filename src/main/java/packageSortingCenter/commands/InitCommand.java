package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class InitCommand implements ICommand {
    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.init();
    }
}
