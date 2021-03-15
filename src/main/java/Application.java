import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.InitCommand;
import packageSortingCenter.commands.NextCommand;


public class Application {
    public static void main(String[] args) {
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();

        ControlUnit controlUnit = packageSortingCenter.getControlUnit();
        controlUnit.executeCommand(new InitCommand());
        controlUnit.executeCommand(new NextCommand());
    }
}
