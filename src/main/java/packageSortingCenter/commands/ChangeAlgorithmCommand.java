package packageSortingCenter.commands;

import configuration.SearchAlgorithm;
import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;

public class ChangeAlgorithmCommand implements ICommand {
    private SearchAlgorithm searchAlgorithm;

    public ChangeAlgorithmCommand(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.changeAlgorithm(searchAlgorithm);
    }
}
