package packageSortingCenter.commands;

import packageSortingCenter.PackageSortingCenter;

public class InitCommand implements ICommand{

    private final PackageSortingCenter packageSortingCenter;

    public InitCommand(PackageSortingCenter packageSortingCenter){
        this.packageSortingCenter = packageSortingCenter;
    }

    @Override
    public void execute() {
        packageSortingCenter.init();
    }
}
