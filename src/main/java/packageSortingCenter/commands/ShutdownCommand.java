package packageSortingCenter.commands;

import control.ControlUnit;

public class ShutdownCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.shutdown();
    }
}
