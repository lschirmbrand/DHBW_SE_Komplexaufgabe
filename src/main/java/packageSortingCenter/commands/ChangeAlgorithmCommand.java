package packageSortingCenter.commands;

import configuration.SearchAlgorithm;
import control.ControlUnit;

public class ChangeAlgorithmCommand implements ICommand {
    private SearchAlgorithm searchAlgorithm;

    public ChangeAlgorithmCommand(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.changeAlgorithm(searchAlgorithm);
    }
}
