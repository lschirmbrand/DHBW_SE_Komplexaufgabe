package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class ChangeAlgorithmCommand implements ICommand {

    private final PackageSortingCenter packageSortingCenter;

    public ChangeAlgorithmCommand(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.changeAlgorithm();
    }
}
