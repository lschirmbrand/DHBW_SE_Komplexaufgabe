import configuration.SearchAlgorithm;
import employee.Administrator;
import employee.DataAnalyst;
import employee.Operator;
import employee.Supervisor;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.terminal.IDCardReader;
import packageSortingCenter.terminal.Terminal;
import utillity.csvTools.CSVBuilder;

import java.io.File;


public class Application {
    public static void main(String[] args) {

        File temp = new File("base_package.csv");
        if (!temp.exists()) {
            CSVBuilder.main();
        }

        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();
        Terminal terminal = packageSortingCenter.getTerminal();
        IDCardReader cardReader = terminal.getCardReader();

        Supervisor supervisor = new Supervisor("Saruman", "1234", true);
        Administrator admin = new Administrator("Gandalf", "2345", Administrator.Profile.A);
        Operator operator = new Operator("Aragorn", "3456");
        DataAnalyst dataAnalyst = new DataAnalyst("Eldrond", "4567");


        cardReader.readCard(supervisor.getIdCard());
        cardReader.enterPin("1234");
        terminal.init();
        terminal.changeSearchAlgorithm(SearchAlgorithm.RABIN_KARP);

        cardReader.readCard(operator.getIdCard());
        cardReader.enterPin("3456");

        terminal.next();
        terminal.next();
        terminal.next();
        terminal.next();
        terminal.next();

        cardReader.readCard(dataAnalyst.getIdCard());
        cardReader.enterPin("4567");
        terminal.showStatistics();

        cardReader.readCard(admin.getIdCard());
        cardReader.enterPin("2345");
        terminal.shutdown();
    }
}
