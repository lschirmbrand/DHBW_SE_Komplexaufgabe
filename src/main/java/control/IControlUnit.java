package control;

import packageSortingCenter.commands.ICommand;
import packageSortingCenter.unloadingZone.IUnloadingZone;
import packageSortingCenter.unloadingZone.sensor.IUnloadingListener;

public interface IControlUnit {

    void executeCommand(ICommand command);
}
