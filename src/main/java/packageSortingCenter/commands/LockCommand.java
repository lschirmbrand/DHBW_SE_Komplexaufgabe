package packageSortingCenter.commands;

import control.ControlUnit;

public class LockCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.lock();
    }
}
