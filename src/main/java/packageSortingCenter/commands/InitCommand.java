package packageSortingCenter.commands;

import control.ControlUnit;

public class InitCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.init();
    }
}
