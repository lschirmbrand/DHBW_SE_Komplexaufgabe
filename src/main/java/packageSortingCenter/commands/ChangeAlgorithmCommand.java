package packageSortingCenter.commands;

import configuration.SearchAlgorithm;
import packageSortingCenter.PackageSortingCenter;

public class ChangeAlgorithmCommand implements ICommand {
    private final SearchAlgorithm searchAlgorithm;

    public ChangeAlgorithmCommand(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void execute(PackageSortingCenter sortingCenter) {
        sortingCenter.changeAlgorithm(searchAlgorithm);
    }
}
