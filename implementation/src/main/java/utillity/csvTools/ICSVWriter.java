package utillity.csvTools;

import packagingElements.boxes.Box;
import packagingElements.packages.Package;
import packagingElements.pallets.Pallet;
import vehicle.lkw.LKW;

import java.util.List;

public interface ICSVWriter {
    void writePackage(List<Package> packages);

    void writeBox(List<Box> boxes);

    void writePallet(List<Pallet> pallets);

    void writeLKW(List<LKW> lkwList);
}
