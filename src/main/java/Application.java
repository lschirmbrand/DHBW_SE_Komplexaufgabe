import utillity.csvTools.CSVReader;
import employee.Administrator;
import packageSortingCenter.PackageSortingCenter;

public class Application {
    public static void main(String[] args) {
        Administrator administrator = new Administrator();


        CSVReader csvReader = new CSVReader();
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();

        packageSortingCenter.init();

        //csvReader.readLKW();


        var packages = csvReader.readPackages();

        int i = 0;
    }
}
