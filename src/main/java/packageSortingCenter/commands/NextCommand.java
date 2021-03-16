package packageSortingCenter.commands;

import control.ControlUnit;

public class NextCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.next();
    }
}
