package packageSortingCenter.commands;

import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public interface ICommand {
    void execute(PackageSortingCenter sortingCenter);
}
