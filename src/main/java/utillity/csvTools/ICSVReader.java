package utillity.csvTools;

import packagingElements.packages.Package;

import java.util.List;

public interface ICSVReader {
    List<String[]> readLKW();
    List<Package> readPackages();
}
