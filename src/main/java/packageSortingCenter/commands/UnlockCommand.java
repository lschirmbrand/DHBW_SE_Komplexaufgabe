package packageSortingCenter.commands;

import control.ControlUnit;

public class UnlockCommand implements ICommand {
    @Override
    public void execute(ControlUnit controlUnit) {
        controlUnit.unlock();
    }
}
