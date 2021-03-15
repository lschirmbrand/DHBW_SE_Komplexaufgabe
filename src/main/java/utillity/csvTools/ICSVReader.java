package utillity.csvTools;

import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKW;

import java.util.List;

public interface ICSVReader {
    List<Package> readPackages();

    List<Pallet> readPallets();

    List<LKW> readLKW();
}
