package packageSortingCenter.commands;

import control.ControlUnit;

public class ShowStatisticsCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.showStatistics();
    }
}
