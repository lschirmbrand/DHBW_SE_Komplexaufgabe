import configuration.SearchAlgorithm;
import control.ControlUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.commands.ChangeAlgorithmCommand;
import packageSortingCenter.commands.InitCommand;
import packageSortingCenter.commands.NextCommand;
import packageSortingCenter.commands.ShowStatisticsCommand;

public class TestImplementation {

    @Test
    @DisplayName("Test the complete Implementation")
    public void testImplementation(){
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
