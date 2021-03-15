package packageSortingCenter.commands;

import control.ControlUnit;
import control.IControlUnit;

public interface ICommand {
    void execute(ControlUnit controlUnit);
}
