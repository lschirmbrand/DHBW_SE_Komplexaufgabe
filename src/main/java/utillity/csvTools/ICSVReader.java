package utillity.csvTools;

import packagingElements.boxes.Box;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKW;

import java.util.List;
import java.util.Map;

public interface ICSVReader {
    Map<String, Package> readPackages();

    Map<String, Box> readBoxes();

    Map<Integer, Pallet> readPallets();

    List<LKW> readLKW();
}
