import configuration.SearchAlgorithm;
import control.ControlUnit;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.ChangeAlgorithmCommand;
import packageSortingCenter.commands.InitCommand;
import packageSortingCenter.commands.NextCommand;
import packageSortingCenter.commands.ShowStatisticsCommand;


public class Application {
    public static void main(String[] args) {
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();

        ControlUnit controlUnit = packageSortingCenter.getControlUnit();
        controlUnit.executeCommand(new InitCommand());
        controlUnit.executeCommand(new ChangeAlgorithmCommand(SearchAlgorithm.RABIN_KARP));
        controlUnit.executeCommand(new NextCommand());
        controlUnit.executeCommand(new NextCommand());
        controlUnit.executeCommand(new NextCommand());
        controlUnit.executeCommand(new NextCommand());
        controlUnit.executeCommand(new NextCommand());
        controlUnit.executeCommand(new ShowStatisticsCommand());
    }
}
